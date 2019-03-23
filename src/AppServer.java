import API.BaseAPI;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppServer extends HttpServlet {
    private Database dataBase;
    private JSONObject appSettings = null;
    private String SeverType;
    private Distance distance;
    private DataBaseResponse staticPreferences;
    private ServletFileUpload uploader = null;

    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws CacheException, IOException {
        return new DataBaseResponse("500");
    }



    List<String> getTargets(String target){
        List<String> list = new ArrayList<>(Arrays.asList(target.split("/")));
        if (list.size() == 2){list.add("default");}
        return list;
    }

    void setDataBase(Database dataBase) {
        this.dataBase = dataBase;
    }

    private String getSeverType() {
        return SeverType;
    }

    void setSeverType(String severType) {
        SeverType = severType;
    }

    public Database getDataBase() {
        return dataBase;
    }

    JSONObject getAppSettings() {
        if (appSettings == null){
            try {
                appSettings = new JSONObject(BaseAPI.AppServerSettings(getDataBase(), getSeverType()));
            } catch (CacheException e) {
                e.printStackTrace();
            }
        }
        return appSettings;
    }



    public DataBaseResponse Preferences(HttpServletRequest baseRequest) throws CacheException {

        if (getAppSettings().getString("StaticPreferences").equals("1")){
            if (staticPreferences == null){
                staticPreferences = new DataBaseResponse(BaseAPI.Preferences(getDataBase(), "static", getSeverType()));
            }
            return staticPreferences;
        }
        return new DataBaseResponse(BaseAPI.Preferences(getDataBase(), getParameter(baseRequest, "key"), getSeverType()));
    }

    DataBaseResponse ProfileRegistration(HttpServletRequest baseRequest) throws CacheException {
        String DataBaseAnswer = BaseAPI.ProfileRegistration(getDataBase(),
                getParameter(baseRequest, "key"),
                getParameter(baseRequest, "phone"),
                getParameter(baseRequest, "code"),
                getSeverType());
        return new DataBaseResponse(DataBaseAnswer);
    }



    DataBaseResponse Profile(HttpServletRequest baseRequest) throws CacheException, IOException {
        String DataBaseAnswer = "400";

        if (baseRequest.getMethod().toUpperCase().equals("GET")){
            DataBaseAnswer = BaseAPI.ProfileGet(getDataBase(), getParameter(baseRequest, "token"),
                    getParameter(baseRequest, "fb_token"),
                    getParameter(baseRequest, "lt"),
                    getParameter(baseRequest, "ln"),
                    getSeverType());
        }
        else if (baseRequest.getMethod().toUpperCase().equals("POST")){
            JSONObject data = new JSONObject(getBody(baseRequest));
            StringBuilder UpdateSQLString = new StringBuilder();
            for (String key : JSONObject.getNames(data))
            {
                if (!data.get(key).equals("")){
                    UpdateSQLString.append("**").append(key).append("** = '").append(data.get(key)).append("',");
                }
            }

            //System.out.println(UpdateSQLString);

            DataBaseAnswer = BaseAPI.ProfileSet(
                    getDataBase(),
                    getParameter(baseRequest, "token"),
                    getParameter(baseRequest, "lt"),
                    getParameter(baseRequest, "ln"),
                    data.toString(),
                    UpdateSQLString.toString(),
                    getSeverType(),
                    APIServer.getUTF8());

            /*

            DataBaseAnswer = BaseAPI.ProfileSet(getDataBase(),
                    getParameter(baseRequest, "token"),
                    getParameter(baseRequest, "lt"),
                    getParameter(baseRequest, "ln"),
                    data.toString(),
                    UpdateSQLString.toString(),
                    getSeverType());
                    */
        }


        return new DataBaseResponse(DataBaseAnswer);
    }

    String getBody(HttpServletRequest request) throws IOException {

        String body;
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

    public static String getParameter(HttpServletRequest baseRequest, String name){
        String result = " ";
        if (baseRequest.getParameter(name) != null)result = baseRequest.getParameter(name);
        return result;
    }

    Distance getDistance() {
        if (distance == null){
            distance = new Distance(APIServer.getGoogleMatrixAPIKey(), getDataBase());
        }
        return distance;
    }

    ServletFileUpload getUploader() {
        if (uploader == null){
            JSONObject settings = getAppSettings();
            DiskFileItemFactory fileFactory = new DiskFileItemFactory();
            fileFactory.setRepository(new File(settings.getString("tmp_file_path")));
            this.uploader = new ServletFileUpload(fileFactory);
        }
        return uploader;
    }

    // convert from UTF-8 -> internal Java String format
    public static String convertFromUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("CP1251"), StandardCharsets.UTF_8);
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }
}
