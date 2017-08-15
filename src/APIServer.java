import App.AppServer;
import App.DataBaseResponse;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.intersys.objects.CacheDatabase;
import com.intersys.objects.Database;
import org.eclipse.jetty.util.ssl.SslContextFactory;


import static java.lang.Thread.sleep;

public class APIServer extends AbstractHandler{
    private static Database dataBase;
    private static String SeverType;
    private static AppServer appServer;
    private static Boolean LogView = false, LogViewData = false;
    private static Integer Port;

    static Database getDatabase(){
        return dataBase;
    }


    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException
    {
        DataBaseResponse dataBaseResponse = appServer.response(target, request);

        if (LogView){
            if (target.equals("/data")){
                if (LogViewData){
                    System.out.println("date = " + getCurDateTime());
                    System.out.println("target = " + target);
                    System.out.println("method = " + request.getMethod());
                    System.out.println("params = " + request.getParameterMap().toString());
                    System.out.println("status = " + dataBaseResponse.getStatus());
                    System.out.println("body = " + dataBaseResponse.getBody());
                    System.out.println("********************************************************");

                }
            }
            else {
                System.out.println("date = " + getCurDateTime());
                System.out.println("target = " + target);
                System.out.println("method = " + request.getMethod());
                System.out.println("params = " + request.getParameterMap().toString());
                System.out.println("status = " + dataBaseResponse.getStatus());
                System.out.println("body = " + dataBaseResponse.getBody());
                System.out.println("********************************************************");

            }

        }




        response.setContentType("text/html;charset=utf-8");
        response.setStatus(dataBaseResponse.getStatus());
        response.setHeader("Server", "aTaxi." + SeverType);
        baseRequest.setHandled(true);
        response.getWriter().println(dataBaseResponse.getBody());


    }

    public static void main(String[] args) throws Exception
    {
        // Читаем настройки из файла
        Properties properties = new Properties();
        String curDir = new File("").getAbsolutePath();
        FileInputStream fis = new FileInputStream(curDir + "/server.properties");
        properties.load(fis);

        String dataBaseURL  = "jdbc:Cache://"+properties.getProperty("db.address")+":"+properties.getProperty("db.port")+"/"+properties.getProperty("db.namespace");
        String dataBaseUser = properties.getProperty("db.username");
        String dataBasePwd  = properties.getProperty("db.password");

        Port     = Integer.parseInt(properties.getProperty("server.port"));
        SeverType    = properties.getProperty("server.type");
        Boolean HTTPS = Boolean.parseBoolean(properties.getProperty("server.https"));

        LogView     = Boolean.parseBoolean(properties.getProperty("log.view"));
        LogViewData = Boolean.parseBoolean(properties.getProperty("log.view_data"));



        System.out.println(getCurDateTime() + "Properties loaded");

        System.out.println(getCurDateTime() + "Connecting to DataBase " + dataBaseURL);
        dataBase = CacheDatabase.getDatabase(dataBaseURL, dataBaseUser, dataBasePwd);
        System.out.println(getCurDateTime() + "Connecting to DataBase " + dataBaseURL + " success");

        switch (SeverType) {
            case "mobile_app":
                appServer = new MobileAppServer();
                break;
            case "geo":
                appServer = new GEOAppServer();
                break;
            case "phone_gateway":
                appServer = new PhoneGatewayAppServer();
                break;
            case "aksioma":
                appServer = new AksiomaAppServer();
                break;
            case "ckassa":
                appServer = new CKassaAppServer();
                break;
        }

        appServer.setDataBase(dataBase);

        System.out.println(getCurDateTime() + "Start server at port " + String.valueOf(Port));
        Server server = new Server();
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
            server.addConnector(connector);
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
        System.out.println(getCurDateTime() + "Started server at port " + String.valueOf(Port) + " success");
        server.join();
    }

    public static Integer getPort() {
        return Port;
    }

    static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    private static String getCurDateTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " ";
    }
}
