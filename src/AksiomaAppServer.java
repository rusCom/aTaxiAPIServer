import API.Aksioma;
import API.MobileAPP;
import App.AppServer;
import App.DataBaseResponse;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


class AksiomaAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        String[] targets = target.split("/");
        String DataBaseAnswer = "400^^";
        try {
            switch (targets[1]){
                case "language":DataBaseAnswer = language();break;
                case "login":
                    switch (baseRequest.getMethod()){
                        case "GET":DataBaseAnswer = loginGET(baseRequest);break;
                        case "POST":DataBaseAnswer = loginPOST(baseRequest);break;
                    }
                    break;
                case "faq":DataBaseAnswer = Aksioma.FAQ(APIServer.getDatabase(), baseRequest.getParameter("access_token"));break;
                case "class":DataBaseAnswer = Aksioma.Class(APIServer.getDatabase(), baseRequest.getParameter("access_token"));break;
                case "manual":
                    switch (targets[2]){
                        case "service":DataBaseAnswer = manualService(baseRequest);break;
                        case "status":DataBaseAnswer = Aksioma.ManualStatus(APIServer.getDatabase(), baseRequest.getParameter("access_token"));break;
                    }
                    break;
                case "user":
                    switch (targets[2]){
                        case "pay":DataBaseAnswer = Aksioma.UserPay(APIServer.getDatabase(), baseRequest.getParameter("access_token"));break;
                    }
                    break;

            }
        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }





        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");

        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else {
            JSONObject result = new JSONObject();
            result.put("code", Integer.valueOf(DataBaseAnswers[0]));
            result.put("limit", 100);
            result.put("offset", 0);
            if (DataBaseAnswers[1].indexOf("{") == 0)result.put("data", new JSONObject(DataBaseAnswers[1]));
            else if (DataBaseAnswers[1].indexOf("[") == 0)result.put("data", new JSONArray(DataBaseAnswers[1]));
            return new DataBaseResponse(DataBaseAnswers[0], result.toString());
        }
    }

    private String manualService(HttpServletRequest baseRequest){
        String DataBaseAnswer;
        try {
            String[] gps = baseRequest.getParameter("gps").split(",");
            DataBaseAnswer = Aksioma.ManualService(APIServer.getDatabase(), baseRequest.getParameter("access_token"), gps[0], gps[1], baseRequest.getParameter("tariff"));

        }  catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        return DataBaseAnswer;
    }

    private String loginPOST(HttpServletRequest baseRequest){
        String DataBaseAnswer;
        try {
            JSONObject data = new JSONObject(APIServer.getBody(baseRequest));
            System.out.println(data.toString());
            DataBaseAnswer = MobileAPP.ProfileRegistration(APIServer.getDatabase(), baseRequest.getParameter("api_key"), data.getString("phone"), data.getString("code"));
            String[] DataBaseAnswers = DataBaseAnswer.split("\\^");

            JSONObject result = new JSONObject();

            if (DataBaseAnswers[0].equals("200"))result.put("access_token", new JSONObject(DataBaseAnswers[1]).getString("token"));
            else result.put("message", DataBaseAnswers[1]);
            return DataBaseAnswers[0] + "^" + result.toString() + "^";
        } catch (IOException e) {
            e.printStackTrace();
            DataBaseAnswer = "400^^";
        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }
        return DataBaseAnswer;

    }

    private String loginGET(HttpServletRequest baseRequest) throws CacheException {
        String DataBaseAnswer = MobileAPP.ProfileLogin(APIServer.getDatabase(), baseRequest.getParameter("api_key"), baseRequest.getParameter("phone"));
        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        JSONObject result = new JSONObject();
        if (DataBaseAnswers[0].equals("200"))result.put("message", "На указанный Вами номер было отправлено СМС сообщение");
        else result.put("message", DataBaseAnswers[1]);
        result.put("debug", "Дебаг код 0000");
        return DataBaseAnswers[0] + "^" + result.toString() + "^";
    }

    private String userPay(){return "[{\"name\":\"bisys\",\"title\":\"CKASSA\"}]";}

    private String language(){
        return "200^{\"language\":[\"ru-RU\"]}^";
    }
}
