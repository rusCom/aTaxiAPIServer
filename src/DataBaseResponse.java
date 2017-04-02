import javax.servlet.http.HttpServletResponse;

class DataBaseResponse {
    private String status, body;

    DataBaseResponse(String status) {
        this.status = status;
        body = "";
    }

    DataBaseResponse(String status, String body) {
        this.status = status;
        this.body = body;
    }

    int getStatus() {
        //System.out.println("getStatus status = " + status);
        if(status.equals("200"))return HttpServletResponse.SC_OK;
        if(status.equals("400"))return HttpServletResponse.SC_BAD_REQUEST;
        if(status.equals("401"))return HttpServletResponse.SC_UNAUTHORIZED;
        if(status.equals("403"))return HttpServletResponse.SC_FORBIDDEN;

        return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
    }

    String getBody() {
        if (body.equals("") || body.equals("0")){
            switch (getStatus()){
                case HttpServletResponse.SC_OK:body = "<b>200 OK</b>";break;
                case HttpServletResponse.SC_BAD_REQUEST:body = "<b>400 Bad Request</b>";break;
                case HttpServletResponse.SC_UNAUTHORIZED:body = "<b>401 Unauthorized</b>";break;
                case HttpServletResponse.SC_FORBIDDEN:body = "<b>403 Forbidden</b>";break;
                case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:body = "<b>500 Internal Server Error</b>";break;
            }
        }
        return body;
    }
}
