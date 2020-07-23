import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;

public class DataBaseResponse {
    private String status = "", body = "", file = null;
    private Integer version = 1;
    JSONObject authorization;
    JSONObject respBody;

    public DataBaseResponse(String DataBaseAnswer) {
        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        status = DataBaseAnswers[0];
        if (DataBaseAnswers.length > 1){
            body = DataBaseAnswers[1];
        }
        if (DataBaseAnswers.length > 2){
            file = DataBaseAnswers[2];
        }
    }

    public String getRespBody() {
        if (respBody == null){return "";}
        return respBody.toString();
    }

    public String getAuthorization() {
        if (authorization == null){
            return "{}";
        }
        return authorization.toString();
    }

    public DataBaseResponse(String status, String body) {
        this.status = status;
        this.body = body;
    }

    public void setResponse(String DataBaseAnswer){
        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        status = DataBaseAnswers[0];
        if (DataBaseAnswers.length > 1){
            body = DataBaseAnswers[1];
        }
        if (DataBaseAnswers.length > 2){
            file = DataBaseAnswers[2];
        }
    }

    public DataBaseResponse(String status, JSONObject authorization) {
        this.status = status;
        this.authorization = authorization;
    }



    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFile() {
        return file;
    }

    public int getStatus() {
        //System.out.println("getStatus status = " + status);
        if(status.equals("200"))return HttpServletResponse.SC_OK;
        if(status.equals("400"))return HttpServletResponse.SC_BAD_REQUEST;
        if(status.equals("401"))return HttpServletResponse.SC_UNAUTHORIZED;
        if(status.equals("403"))return HttpServletResponse.SC_FORBIDDEN;
        if(status.equals("404"))return HttpServletResponse.SC_NOT_FOUND;

        return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    }

    public String getStatusCode() {
        return status;
    }

    public String getStatusName(){
        if(status.equals("200"))return "OK";
        if(status.equals("400"))return "BAD_REQUEST";
        if(status.equals("401"))return "UNAUTHORIZED";
        if(status.equals("403"))return "FORBIDDEN";
        if(status.equals("404"))return "NOT_FOUND";

        return "NTERNAL_SERVER_ERROR";
    }

    public String getBody(String response) {
        if (response.equals("json")){
            if (body.equals("0"))return null;
            if (body.equals(""))return null;
            if (body.equals("{}"))return null;
            return body;
        }
        if (body.equals("") || body.equals("0")){
            switch (getStatus()){
                case HttpServletResponse.SC_OK:body = "200 OK";break;
                case HttpServletResponse.SC_BAD_REQUEST:body = "400 Bad Request";break;
                case HttpServletResponse.SC_UNAUTHORIZED:body = "401 Unauthorized";break;
                case HttpServletResponse.SC_FORBIDDEN:body = "403 Forbidden";break;
                case HttpServletResponse.SC_NOT_FOUND:body = "404 Not Found";break;
                case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:body = "500 Internal Server Error";break;
            }
        }
        return body;
    }
}
