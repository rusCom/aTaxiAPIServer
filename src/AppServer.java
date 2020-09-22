import API.BaseAPI;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.codec.binary.Base64.decodeBase64;

public class AppServer extends HttpServlet {
    protected Database dataBase;
    private JSONObject appSettings = null;
    String SeverType, body = "", target;
    private Distance distance;
    private GEO geo;
    private DataBaseResponse staticPreferences;
    private ServletFileUpload uploader = null;
    private Boolean IsTest;
    String UTF = "false";
    JSONObject authorization;
    HttpServletRequest baseRequest;
    DataBaseResponse response;
    JSONObject bodyData;
    boolean consolePrint = false;


    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        this.target = target;
        this.baseRequest = baseRequest;
        authorization = new JSONObject();
        if (baseRequest.getHeader("authorization") != null) {
            String[] authHeader = baseRequest.getHeader("authorization").split(" ");
            // System.out.println(authHeader[1]);
            if (authHeader[0].equals("Bearer")) {
                byte[] result = decodeBase64(authHeader[1]);
                authorization = new JSONObject(new String(result));
                if (authorization.has("test")) {
                    if (authorization.get("test") instanceof String) {
                        if (authorization.getString("test").equals("true")) {
                            authorization.put("test", "1");
                        } else if (authorization.getString("test").equals("false")) {
                            authorization.put("test", "0");
                        }
                    } else if (authorization.get("test") instanceof Boolean) {
                        if (authorization.getBoolean("test")) authorization.put("test", "1");
                        else authorization.put("test", "0");
                    } else {
                        authorization.put("test", String.valueOf(authorization.get("test")));
                    } // if (authorization.get("test") instanceof String) {


                } else {
                    authorization.put("test", "0");
                }

                if (authorization.has("lt")) {
                    if (authorization.get("lt") instanceof String) {
                    } else {
                        authorization.put("lt", String.valueOf(authorization.getDouble("lt")));
                    }
                } // if (authorization.has("lt"))
                if (authorization.has("ln")) {
                    if (authorization.get("ln") instanceof String) {
                    } else {
                        authorization.put("ln", String.valueOf(authorization.getDouble("ln")));
                    }
                } // if (authorization.has("ln"))
            }
        }


        if (authorization == null) {
            authorization = new JSONObject();
            if (baseRequest.getParameter("token") != null) {
                authorization.put("token", baseRequest.getParameter("token"));
            } else {
                authorization.put("token", "");
            }
        }

        // System.out.println(authorization.toString());

        response = new DataBaseResponse("500", authorization);
        return response;
    }

    String bodyField(String field, String def) {
        String res = bodyField(field);
        if (res.equals("")) return def;
        return res;
    }

    JSONArray bodyJSONArray(String field) {
        if (response.respBody == null) {
            response.respBody = body();
        }
        if (response.respBody.has(field)) {
            return response.respBody.getJSONArray(field);
        }
        return new JSONArray();
    }

    String bodyField(String field) {
        if (response.respBody == null) {
            response.respBody = body();
        }
        if (response.respBody.has(field)) {
            return response.respBody.getString(field);
        }
        return "";
    }

    JSONObject body() {
        String body;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = baseRequest.getInputStream();
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
            try {
                throw ex;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    try {
                        throw ex;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        body = stringBuilder.toString();
        // System.out.println(body);
        JSONObject res = new JSONObject(body);
        return res;
    }

    String param(String name) {
        String result = "";
        if (baseRequest.getParameter(name) != null) result = baseRequest.getParameter(name);
        else if (authorization.has(name)) result = authorization.getString(name);
        return result;
    }

    String param(String name, String defaultValue) {
        String result = param(name);
        if (result.equals("")) result = defaultValue;
        return result;
    }


    List<String> getTargets(String target) {
        List<String> list = new ArrayList<>(Arrays.asList(target.split("/")));
        if (list.size() == 2) {
            list.add("default");
        }
        return list;
    }

    void setDataBase(Database dataBase) {
        this.dataBase = dataBase;
    }

    public void setTest(Boolean test) {
        IsTest = test;
    }

    String isTest() {
        if (IsTest) return "1";
        return "0";
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
        if (appSettings == null) {
            try {
                appSettings = new JSONObject(BaseAPI.AppServerSettings(getDataBase(), getSeverType()));
            } catch (CacheException e) {
                e.printStackTrace();
            }
        }
        return appSettings;
    }

    String getSetting(String param) {
        if (getAppSettings().equals(param)) return getAppSettings().getString(param);
        return "";
    }

    public DataBaseResponse Preferences(HttpServletRequest baseRequest) throws CacheException {

        if (getAppSettings().getString("StaticPreferences").equals("1")) {
            if (staticPreferences == null) {
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

    DataBaseResponse LogError(HttpServletRequest baseRequest) throws IOException {
        String DataBaseAnswer = "200";
        String urlString = "http://crm.toptaxi.org/log/error?project=aTaxiCache&api=" + getSeverType()
                + "&request=" + getParameter(baseRequest, "request").replaceAll("\\s+", "")
                + "&application=" + getParameter(baseRequest, "application").replaceAll("\\s+", "")
                + "&response=" + getParameter(baseRequest, "response").replaceAll("\\s+", "")
                + "&error=" + getParameter(baseRequest, "error").replaceAll("\\s+", "");
        getHTML(urlString);


        return new DataBaseResponse("200^OK");
    }

    String getHTML(String urlToRead) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }


    DataBaseResponse Profile(HttpServletRequest baseRequest) throws CacheException, IOException {
        String DataBaseAnswer = "400";

        if (baseRequest.getMethod().toUpperCase().equals("GET")) {
            DataBaseAnswer = BaseAPI.ProfileGet(getDataBase(), getParameter(baseRequest, "token"),
                    getParameter(baseRequest, "fb_token"),
                    getParameter(baseRequest, "lt"),
                    getParameter(baseRequest, "ln"),
                    getSeverType());
        } else if (baseRequest.getMethod().toUpperCase().equals("POST")) {
            JSONObject data = new JSONObject(getBody(baseRequest));
            StringBuilder UpdateSQLString = new StringBuilder();
            for (String key : JSONObject.getNames(data)) {
                if (!data.get(key).equals("")) {
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

    public static String getParameter(HttpServletRequest baseRequest, String name) {
        String result = " ";
        if (baseRequest.getParameter(name) != null) result = baseRequest.getParameter(name);
        return result;
    }

    public static String getParameter(HttpServletRequest baseRequest, String name, String defaultValue) {
        String result = getParameter(baseRequest, name);
        if (result.equals(" ")) result = defaultValue;
        return result;
    }

    Distance getDistance() {
        if (distance == null) {
            distance = new Distance(getDataBase());
        }
        return distance;
    }

    GEO getGEO() {
        if (geo == null) {
            geo = new GEO(getDataBase());
        }
        return geo;
    }

    ServletFileUpload getUploader() {
        if (uploader == null) {
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
