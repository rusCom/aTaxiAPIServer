import API.BaseAPI;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.json.JSONArray;
import org.json.JSONException;



import static java.lang.Thread.sleep;

public class APIServer extends AbstractHandler {
    private static Database dataBase;
    private static String SeverType, googleMatrixAPIKey, googlePlacesAPIKey;
    private static AppServer appServer;
    private static Boolean IsTest  = false, UTF8 = false;
    private static Integer Port;
    private static PrintWriter logPrintWriter, logDataPrintWriter, exceptionPrintWriter;
    private static String curDir;


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
                       HttpServletResponse response)
            throws IOException
    {
        String exceptionAsString = "";
        DataBaseResponse dataBaseResponse;
        try {
            switch (target){
                case "/preferences":dataBaseResponse = appServer.Preferences(request);break;
                case "/profile":dataBaseResponse = appServer.Profile(request);break;
                case "/profile/registration":dataBaseResponse = appServer.ProfileRegistration(request);break;

                default:dataBaseResponse = appServer.response(target, request);
            }
        } catch (CacheException | IOException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            exceptionAsString = sw.toString();
            dataBaseResponse = new DataBaseResponse("500");
        }

        StringBuilder logText = new StringBuilder();
        logText.append("date").append("\t").append("= ").append(getCurDateTime()).append("\n");
        logText.append("address").append("\t").append("= ").append(request.getRemoteAddr()).append("\n");
        logText.append("target").append("\t").append("= ").append(target).append("\n");
        logText.append("method").append("\t").append("= ").append(request.getMethod()).append("\n");
        logText.append("params").append("\t").append("= ").append(request.getParameterMap().toString()).append("\n");
        logText.append("status").append("\t").append("= ").append(dataBaseResponse.getStatus()).append("\n");
        logText.append("body").append("\t").append("= ").append(dataBaseResponse.getBody()).append("\n");
        logText.append("excep").append("\t").append("= ").append(exceptionAsString).append("\n");
        logText.append("********************************************************").append("\n");

        if (!exceptionAsString.equals("")){
            getExceptionPrintWriter().println(logText);
            getExceptionPrintWriter().flush();
            if (appServer.getAppSettings().getString("log_view").equals("console")){
                System.out.println(logText);
            }
        }
        else if (appServer.getAppSettings().getString("log_view").equals("file") && appServer.getAppSettings().getString("log_view_data").equals("true") && target.equals("/data")){
            if (IsTest){System.out.println(logText);}
            else {
                getLogDataPrintWriter().println(logText);
                getLogDataPrintWriter().flush();
            }
        }
        else if (appServer.getAppSettings().getString("log_view").equals("file") && !target.equals("/data")){
            if (IsTest){System.out.println(logText);}
            else {
                getLogDataPrintWriter().println(logText);
                getLogDataPrintWriter().flush();
            }
        }
        else if (appServer.getAppSettings().getString("log_view").equals("console") && appServer.getAppSettings().getString("log_view_data").equals("true") && target.equals("/data")){
            System.out.println(logText);
        }
        else if (appServer.getAppSettings().getString("log_view").equals("console") && !target.equals("/data")){
            System.out.println(logText);
        }

        if (dataBaseResponse.getStatus() == HttpServletResponse.SC_OK){
            if (dataBaseResponse.getBody().equals("200 OK")){response.setContentType("application/text;charset=utf-8");}
            else {response.setContentType("application/json;charset=utf-8");}
        }
        else {response.setContentType("application/text;charset=utf-8");}
        response.setStatus(dataBaseResponse.getStatus());
        response.setHeader("Server", "aTaxi." + SeverType);
        baseRequest.setHandled(true);

        if (dataBaseResponse.getFile() == null){

            response.getWriter().print(dataBaseResponse.getBody());
        }
        else {
            File file = new File(dataBaseResponse.getFile());
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            //System.out.println("File location on server: " + file.getAbsolutePath());
            //System.out.println("File mimeType: " + mimeType);
            InputStream fis = new FileInputStream(file);
            response.setContentType(mimeType != null? mimeType:"application/octet-stream");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            ServletOutputStream os = response.getOutputStream();
            byte[] bufferData = new byte[1024];
            int read;
            while((read = fis.read(bufferData))!= -1){
                os.write(bufferData, 0, read);
            }
            os.flush();
            os.close();
            fis.close();
            //System.out.println("File downloaded at client successfully");
        }
    }


    public static void main(String[] args) throws Exception
    {
        // Читаем настройки из файла
        Properties properties = new Properties();
        curDir = new File("").getAbsolutePath();
        FileInputStream fis = new FileInputStream(curDir + "/server.properties");
        properties.load(fis);

        String dataBaseURL  = "jdbc:Cache://"+properties.getProperty("db.address")+":"+properties.getProperty("db.port")+"/"+properties.getProperty("db.namespace");
        String dataBaseUser = properties.getProperty("db.username");
        String dataBasePwd  = properties.getProperty("db.password");

        Port     = Integer.parseInt(properties.getProperty("server.port"));
        SeverType    = properties.getProperty("server.type");
        Boolean HTTPS = Boolean.parseBoolean(properties.getProperty("server.https"));

        IsTest = Boolean.parseBoolean(properties.getProperty("server.test"));
        UTF8 = Boolean.parseBoolean(properties.getProperty("server.utf8"));

        new File(curDir + "/log/").mkdir();

        googleMatrixAPIKey = properties.getProperty("google.matrix_api_key");
        googlePlacesAPIKey = properties.getProperty("google.places_api_key");



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
            case "web_app":
                appServer = new WebAppServer();
                break;
            case "GEO":
                appServer = new GEO2AppServer();
                break;
                /*
            case "geo":
                appServer = new GEOAppServer();
                break;
                */
            case "phone_gateway":
                appServer = new PhoneGatewayAppServer();
                break;
            case "aksioma":
                appServer = new AksiomaAppServer();
                break;
            case "ckassa":
                appServer = new CKassaAppServer();
                break;
            case "taximeter":
                appServer = new TaximeterAppServer();
                break;
            case "dispatcher":
                appServer = new DispatcherAppServer();
                break;

        }


        appServer.setDataBase(dataBase);
        appServer.setSeverType(SeverType);
        try {
            BaseAPI.Initialize(dataBase, SeverType);

        } catch (CacheException e) {
            e.printStackTrace();
        }





        System.out.println(getCurDateTime() + "Start " + SeverType + " server at port " + String.valueOf(Port));




        Server server = new Server(new QueuedThreadPool(512, 32, 120));
        ServerConnector connector = new ServerConnector(server);


        if (HTTPS){
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
            server.setConnectors(new Connector[] { connector, sslConnector });
        }
        else {
            connector.setPort(Port);
            server.setConnectors(new Connector[] {connector});
        }


        server.setHandler(new APIServer());






        while (!server.isStarted()){
            try {
                server.start();
            }
            catch (Exception e){
                //System.out.pr
                sleep(5*1000);
            }
        }
        System.out.println(getCurDateTime() + "Started " + SeverType + " server at port " + String.valueOf(Port) + " success");
        server.join();
    }

    static JSONArray getMergeJsonArrays(ArrayList<JSONArray> jsonArrays) throws JSONException
    {
        JSONArray MergedJsonArrays= new JSONArray();
        for(JSONArray tmpArray:jsonArrays)
        {
            for(int i=0;i<tmpArray.length();i++)
            {
                MergedJsonArrays.put(tmpArray.get(i));
            }
        }
        return MergedJsonArrays;
    }

    static String getGoogleMatrixAPIKey() {
        return googleMatrixAPIKey;
    }

    static String getGooglePlacesAPIKey() {
        return googlePlacesAPIKey;
    }

    static Integer getPort() {
        return Port;
    }

    public static String getCurDateTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " ";
    }

    private static PrintWriter getExceptionPrintWriter() throws FileNotFoundException {
        if (exceptionPrintWriter == null){
            String logFileName     = curDir + "/log/" + getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + "exception_log.txt";// + String.format("%s%s", getCurDateTime(), "log.txt");
            exceptionPrintWriter = new PrintWriter(new File(logFileName));
        }
        return exceptionPrintWriter;
    }

    public static String getCurDir() {
        return curDir;
    }

    private static PrintWriter getLogPrintWriter() throws FileNotFoundException {
        if (logPrintWriter == null){
            String logFileName     = curDir + "/log/" + getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + "log.txt";// + String.format("%s%s", getCurDateTime(), "log.txt");
            logPrintWriter = new PrintWriter(new File(logFileName));
        }
        return logPrintWriter;
    }

    private static PrintWriter getLogDataPrintWriter() throws FileNotFoundException {
        if (logDataPrintWriter == null){
            String logFileName     = curDir + "/log/" + getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + "data_log.txt";// + String.format("%s%s", getCurDateTime(), "log.txt");
            logDataPrintWriter = new PrintWriter(new File(logFileName));
        }
        return logDataPrintWriter;
    }

    public static Boolean getUTF8() {
        return UTF8;
    }
}
