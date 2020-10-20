import API.BaseAPI;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import static java.lang.Thread.sleep;

public class APIServer extends AbstractHandler {
    private static Database dataBase;
    private static String SeverType;
    private static AppServer appServer;
    private static Boolean IsTest = false, UTF8 = false;
    private static Integer Port;
    private static PrintWriter logPrintWriter, logDataPrintWriter, exceptionPrintWriter;
    private static String curDir;
    private static String serverResponse;


    public static Boolean getIsTest() {
        return IsTest;
    }

    public static Database getDataBase() {
        return dataBase;
    }

    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) {
        long startTime = System.currentTimeMillis();

        String exceptionAsString = "";
        DataBaseResponse dataBaseResponse;
        try {
            dataBaseResponse = appServer.response(target, request);

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            exceptionAsString = sw.toString();
            dataBaseResponse = new DataBaseResponse("500^" + e.getClass().getCanonicalName() + "^");
        }

        try {
            // System.out.println(target);
            // System.out.println(appServer.getAppSettings().toString());
            StringBuilder logText = new StringBuilder();
            logText.append("date").append("\t").append("= ").append(getCurDateTime()).append("\n");
            logText.append("address").append("\t").append("= ").append(request.getRemoteAddr()).append("\n");
            logText.append("target").append("\t").append("= ").append(target).append("\n");
            logText.append("method").append("\t").append("= ").append(request.getMethod()).append("\n");
            logText.append("auth").append("\t").append("= ").append(dataBaseResponse.getAuthorization()).append("\n");
            logText.append("rBody").append("\t").append("= ").append(dataBaseResponse.getRespBody()).append("\n");
            logText.append("params").append("\t").append("= ").append(request.getParameterMap().toString()).append("\n");

            logText.append("status").append("\t").append("= ").append(dataBaseResponse.getStatus()).append("\n");
            logText.append("body").append("\t").append("= ").append(dataBaseResponse.getBody(serverResponse)).append("\n");
            logText.append("excep").append("\t").append("= ").append(exceptionAsString).append("\n");
            logText.append("********************************************************").append("\n");
            // System.out.println(logText);

            if (!exceptionAsString.equals("")) {
                getExceptionPrintWriter().println(logText);
                getExceptionPrintWriter().flush();
                if (appServer.getAppSettings().getString("log_view").equals("console")) {
                    System.out.println(logText);
                }
            } else if (target.equals("/data")) {
                switch (appServer.getAppSettings().getString("log_view_data")) {
                    case "console":
                        System.out.println(logText);
                        break;
                    case "file":
                        getLogDataPrintWriter().println(logText);
                        getLogDataPrintWriter().flush();
                        break;
                }
            } else {
                switch (appServer.getAppSettings().getString("log_view")) {
                    case "console":
                        System.out.println(logText);
                        break;
                    case "file":
                        getLogPrintWriter().println(logText);
                        getLogPrintWriter().flush();
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {

            if (serverResponse.equals("json")) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.setHeader("Server", "aTaxi." + SeverType);
                response.setContentType("application/json;charset=utf-8");
                JSONObject result = new JSONObject();
                result.put("status", dataBaseResponse.getStatusName());
                result.put("status_code", dataBaseResponse.getStatusCode());
                if (dataBaseResponse.getStatusCode().equals("200")) {
                    if (dataBaseResponse.getBody(serverResponse) != null) {
                        try {
                            result.put("result", new JSONObject(dataBaseResponse.getBody(serverResponse)));
                        } catch (JSONException e) {
                            result.put("result", dataBaseResponse.getBody(serverResponse));
                        }
                    }
                } else if (dataBaseResponse.getBody(serverResponse) != null) {
                    try {
                        result.put("error", new JSONObject(dataBaseResponse.getBody(serverResponse)));
                    } catch (JSONException e) {
                        result.put("error", dataBaseResponse.getBody(serverResponse));
                    }

                    // result.put("error", dataBaseResponse.getBody(serverResponse));
                }
                result.put("time", (System.currentTimeMillis() - startTime) / 1000.0);

                baseRequest.setHandled(true);
                response.getWriter().print(result.toString());

                return;

            } // if (appServer.getAppSettings().getString("response").equals("json")){


            if (dataBaseResponse.getStatus() == HttpServletResponse.SC_OK) {
                if (dataBaseResponse.getBody(serverResponse).equals("200 OK")) {
                    response.setContentType("application/text;charset=utf-8");
                } else {
                    response.setContentType("application/json;charset=utf-8");
                }
            } else {
                response.setContentType("application/text;charset=utf-8");
            }
            response.setStatus(dataBaseResponse.getStatus());
            response.setHeader("Server", "aTaxi." + SeverType);
            baseRequest.setHandled(true);

            if (dataBaseResponse.getFile() == null) {

                try {
                    response.getWriter().print(dataBaseResponse.getBody(serverResponse));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                File file = new File(dataBaseResponse.getFile());
                String mimeType = URLConnection.guessContentTypeFromName(file.getName());
                //System.out.println("File location on server: " + file.getAbsolutePath());
                //System.out.println("File mimeType: " + mimeType);
                InputStream fis = new FileInputStream(file);
                response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
                response.setContentLength((int) file.length());
                response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                ServletOutputStream os = response.getOutputStream();
                byte[] bufferData = new byte[1024];
                int read;
                while ((read = fis.read(bufferData)) != -1) {
                    os.write(bufferData, 0, read);
                }
                os.flush();
                os.close();
                fis.close();
                //System.out.println("File downloaded at client successfully");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws InterruptedException, CacheException, IOException {
        // Читаем настройки из файла
        Properties properties = new Properties();
        curDir = new File("").getAbsolutePath();
        FileInputStream fis = new FileInputStream(curDir + "/server.properties");
        properties.load(fis);

        String dataBaseURL = "jdbc:Cache://" + properties.getProperty("db.address") + ":" + properties.getProperty("db.port") + "/" + properties.getProperty("db.namespace");
        String dataBaseUser = properties.getProperty("db.username");
        String dataBasePwd = properties.getProperty("db.password");

        Port = Integer.parseInt(properties.getProperty("server.port"));
        SeverType = properties.getProperty("server.type");

        serverResponse = properties.getProperty("server.response", "");


        boolean HTTPS = Boolean.parseBoolean(properties.getProperty("server.https"));

        IsTest = Boolean.parseBoolean(properties.getProperty("server.test"));
        UTF8 = Boolean.parseBoolean(properties.getProperty("server.utf8"));

        new File(curDir + "/log/").mkdir();

        System.out.println(getCurDateTime() + "Properties loaded");

        System.out.println(getCurDateTime() + "Connecting to DataBase " + dataBaseURL);
        dataBase = CacheDatabase.getDatabase(dataBaseURL, dataBaseUser, dataBasePwd);

        System.out.println(getCurDateTime() + "Connecting to DataBase " + dataBaseURL + " success");


        switch (SeverType) {
            case "TaximeterRegistration":
                appServer = new TaximeterRegistrationAppServer();
                break;
            case "MobileAPP":
                appServer = new MobileAppServer();
                break;
            case "ckassa":
                appServer = new CKassaAppServer();
                break;
            case "Taximeter":
                appServer = new TaximeterAppServer();
                break;
            case "MainAPI":
                appServer = new MainAPIAppServer();
                break;
            case "Taximeter2":
                appServer = new TaximeterAppServer_v2();
                break;
            case "Booking":
                appServer = new BookingAppServer();
                break;
            case "Exchange":
                appServer = new ExchangeAppServer();
                break;
        }


        appServer.setDataBase(dataBase);
        appServer.setSeverType(SeverType);
        appServer.setTest(IsTest);
        appServer.UTF = UTF8.toString();
        try {
            BaseAPI.Initialize(dataBase, SeverType);

        } catch (CacheException e) {
            e.printStackTrace();
        }

        System.out.println(getCurDateTime() + "Start " + SeverType + " server at port " + Port);


        Server server = new Server(new QueuedThreadPool(512, 32, 120));
        ServerConnector connector = new ServerConnector(server);


        if (HTTPS) {
            HttpConfiguration https = new HttpConfiguration();
            https.addCustomizer(new SecureRequestCustomizer());

            SslContextFactory sslContextFactory = new SslContextFactory();
            sslContextFactory.setKeyStorePath(curDir + "/keystore.jks");
            sslContextFactory.setKeyStorePassword("rj45mlk64");
            sslContextFactory.setKeyManagerPassword("rj45mlk64");
            ServerConnector sslConnector = new ServerConnector(server,
                    new SslConnectionFactory(sslContextFactory, "http/1.1"),
                    new HttpConnectionFactory(https));
            sslConnector.setPort(Port);
            server.setConnectors(new Connector[]{connector, sslConnector});
        } else {
            connector.setPort(Port);
            server.setConnectors(new Connector[]{connector});
        }
        server.setHandler(new APIServer());
        while (!server.isStarted()) {
            try {
                server.start();
            } catch (Exception e) {
                //System.out.pr
                sleep(5 * 1000);
            }
        }
        System.out.println(getCurDateTime() + "Started " + SeverType + " server at port " + String.valueOf(Port) + " success");

        try {
            server.join();
        } catch (InterruptedException e) {
            System.out.println("!!!");
            e.printStackTrace();
        }
    }

    static JSONArray getMergeJsonArrays(ArrayList<JSONArray> jsonArrays) throws JSONException {
        JSONArray MergedJsonArrays = new JSONArray();
        for (JSONArray tmpArray : jsonArrays) {
            for (int i = 0; i < tmpArray.length(); i++) {
                MergedJsonArrays.put(tmpArray.get(i));
            }
        }
        return MergedJsonArrays;
    }

    static Integer getPort() {
        return Port;
    }

    static String getCurDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " ";
    }


    private static PrintWriter getExceptionPrintWriter() throws FileNotFoundException {
        if (exceptionPrintWriter == null) {
            String logFileName = curDir + "/log/" + appServer.SeverType + "_" + getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + "exception_log.txt";// + String.format("%s%s", getCurDateTime(), "log.txt");
            exceptionPrintWriter = new PrintWriter(new File(logFileName));
        }
        return exceptionPrintWriter;
    }

    static String getCurDir() {
        return curDir;
    }

    private static PrintWriter getLogPrintWriter() throws FileNotFoundException {
        if (logPrintWriter == null) {
            String logFileName = curDir + "/log/" + appServer.SeverType + "_" + getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + "log.txt";// + String.format("%s%s", getCurDateTime(), "log.txt");
            logPrintWriter = new PrintWriter(new File(logFileName));
        }
        return logPrintWriter;
    }

    private static PrintWriter getLogDataPrintWriter() throws FileNotFoundException {
        if (logDataPrintWriter == null) {
            String logFileName = curDir + "/log/" + appServer.SeverType + "_" + getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + "data_log.txt";// + String.format("%s%s", getCurDateTime(), "log.txt");
            logDataPrintWriter = new PrintWriter(new File(logFileName));
        }
        return logDataPrintWriter;
    }

    static Boolean getUTF8() {
        return UTF8;
    }

    static void httpGetThread(final String urlString){

        Runnable task = new Runnable() {
            @Override
            public void run() {
                httpGet(urlString);
                System.out.println(urlString);
            }
        };
        Thread thread = new Thread(task);
        thread.start();

    }

    static void consoleLog(Object TAG, String method, Object message){
        System.out.println(getCurDateTime() + "##### " + TAG.getClass().getName() + "." + method + "." + message.toString());
    }



    static JSONObject httpGet(String urlString) {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            result = new JSONObject(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
