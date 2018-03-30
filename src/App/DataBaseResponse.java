package App;

import javax.servlet.http.HttpServletResponse;


public class DataBaseResponse {
    private String status, body;

    public DataBaseResponse(String status) {
        this.status = status;
        body = "";
    }

    public DataBaseResponse(String status, String body) {
        this.status = status;
        this.body = body;
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

    public String getBody() {
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