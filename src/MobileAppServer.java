
import API.MobileAPP;
import App.AppServer;
import App.DataBaseResponse;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


class MobileAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {

        String[] targets = target.split("/");
        String DataBaseAnswer = "400^^";

        try {
            switch (targets[1]){
                case "profile":
                    switch (targets[2]){
                        case "login":DataBaseAnswer = MobileAPP.ProfileLogin(APIServer.getDatabase(), baseRequest.getParameter("key"), baseRequest.getParameter("phone"));break;
                        case "registration":DataBaseAnswer = MobileAPP.ProfileRegistration(APIServer.getDatabase(), baseRequest.getParameter("key"), baseRequest.getParameter("phone"), baseRequest.getParameter("code"));break;
                        case "get":DataBaseAnswer = MobileAPP.ProfileGet(APIServer.getDatabase(), baseRequest.getParameter("token"));break;
                        case "check_phone":DataBaseAnswer = MobileAPP.ProfileCheckPhone(APIServer.getDatabase(), baseRequest.getParameter("token"), baseRequest.getParameter("phone"));break;
                        case "check_phone_code":DataBaseAnswer = MobileAPP.ProfileCheckPhoneCode(APIServer.getDatabase(), baseRequest.getParameter("token"), baseRequest.getParameter("phone"), baseRequest.getParameter("code"));break;
                        case "set":DataBaseAnswer = ProfileSet(baseRequest);
                    }
                    break; // case "profile"
                case "data":
                    DataBaseAnswer = MobileAPP.Data(APIServer.getDatabase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"),baseRequest.getParameter("ln"));
                    break; // case "data"
                case "preferences":
                    DataBaseAnswer = Preferences(baseRequest);
                    break; // case "preferences"
                case "orders":
                    switch (targets[2]){
                        case "calc": DataBaseAnswer = OrdersCalc(baseRequest);break;
                        case "add": DataBaseAnswer = OrdersAdd(baseRequest);break;
                        case "deny": DataBaseAnswer = OrdersDeny(baseRequest);break;
                        case "history": DataBaseAnswer = OrdersHistory(baseRequest);break;
                        case "feedback": DataBaseAnswer = OrdersFeedback(baseRequest);break;

                    }
                    break; // case "orders"
            }
        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");

        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }

    private String OrdersFeedback(HttpServletRequest baseRequest) throws CacheException{
        if (baseRequest.getParameter("token") == null)return "400^^";
        if (baseRequest.getParameter("guid") == null)return "400^^";
        if (baseRequest.getParameter("rating") == null)return "400^^";
        String note = "";
        if (baseRequest.getParameter("note") != null)note = baseRequest.getParameter("note");
        return MobileAPP.OrdersFeedback(APIServer.getDatabase(), baseRequest.getParameter("token"), baseRequest.getParameter("guid"), baseRequest.getParameter("rating"), note);

    }

    private String OrdersHistory(HttpServletRequest baseRequest) throws CacheException{
        String guid = "";
        if (baseRequest.getParameter("token") == null)return "400^^";
        if (baseRequest.getParameter("guid") != null)guid = baseRequest.getParameter("guid");
        return MobileAPP.OrdersHistory(APIServer.getDatabase(), baseRequest.getParameter("token"), guid);
    }

    private String OrdersDeny(HttpServletRequest baseRequest) throws CacheException {
        String reason = "";
        if (baseRequest.getParameter("reason") != null)reason = baseRequest.getParameter("reason");
        return MobileAPP.OrdersDeny(APIServer.getDatabase(), baseRequest.getParameter("token"), reason, baseRequest.getParameter("lt"), baseRequest.getParameter("ln"));
    }


    private String OrdersAdd(HttpServletRequest baseRequest) throws CacheException {
        String price = "";
        if (baseRequest.getParameter("price") != null)price = baseRequest.getParameter("price");
        return MobileAPP.OrdersAdd(APIServer.getDatabase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"),baseRequest.getParameter("ln"), "0", baseRequest.getParameter("note"), price);
    }



    private String OrdersCalc(HttpServletRequest baseRequest){
        String DataBaseAnswer;
        try {
            JSONObject data = new JSONObject(APIServer.getBody(baseRequest));
            String DataString = "";
            if (data.has("date"))DataString += data.getString("date") + "^";
            else {DataString += "^";}

            DataString += data.getString("category") + "^";
            DataString += String.valueOf(data.get("distance")) + "^";
            DataString += String.valueOf(data.get("duration")) + "^";
            DataString += data.getString("pay") + "^";

            JSONObject wish = data.getJSONObject("wish");
            String WishString = "";
            if (wish.has("value_addition"))WishString += wish.getString("value_addition") + "^";
            else {WishString += "0^";}
            if (wish.has("check") && (wish.getBoolean("check")))WishString += "1^";
            else {WishString += "0^";}
            if (wish.has("conditioner") && (wish.getBoolean("conditioner")))WishString += "1^";
            else {WishString += "0^";}
            if (wish.has("smoke") && (wish.getBoolean("smoke")))WishString += "1^";
            else {WishString += "0^";}
            if (wish.has("no_smoke") && (wish.getBoolean("no_smoke")))WishString += "1^";
            else {WishString += "0^";}
            if (wish.has("children") && (wish.getBoolean("children")))WishString += "1^";
            else {WishString += "0^";}

            JSONArray routes = data.getJSONArray("route");
            DataString += routes.length() + "^";
            String RouteString = "";
            for (int itemID = 0; itemID < routes.length(); itemID++){
                JSONObject route = routes.getJSONObject(itemID);
                RouteString += route.getString("address") + "^";
                if (route.has("note"))RouteString += route.getString("note") + "^";
                else RouteString += "^";
                RouteString += route.getString("lt") + "^";
                RouteString += route.getString("ln") + "^";
                RouteString += route.getString("dsc") + "^";
                RouteString += "***";
            }



            DataBaseAnswer = MobileAPP.OrdersCalc(APIServer.getDatabase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"), baseRequest.getParameter("ln"), DataString, WishString, RouteString);
            if (DataBaseAnswer.split("\\^")[0].equals("200")){
                JSONObject databaseResult = new JSONObject(DataBaseAnswer.split("\\^")[1]);
                System.out.println(databaseResult.toString());
                JSONObject result = new JSONObject();
                result.put("uid", databaseResult.getString("calc_uid"));
                result.put("distance", databaseResult.getJSONObject("order").getString("distance"));
                result.put("price", databaseResult.getJSONObject("calc").getString("price_rounded"));
                if (databaseResult.getJSONObject("order").has("duration"))result.put("duration", databaseResult.getJSONObject("order").getString("duration"));
                //result.append("uid", databaseResult.getString("calc_uid"));

                DataBaseAnswer = "200^" + result.toString() + "^";
            }





        } catch (IOException e) {
            e.printStackTrace();
            DataBaseAnswer = "400^^";
        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }
        return DataBaseAnswer;
    }

    private String Preferences(HttpServletRequest baseRequest){
        String DataBaseAnswer;
        String profile = "0";
        if ((baseRequest.getParameter("profile") != null) && (baseRequest.getParameter("profile").equals("true")))profile = "1";
        String data = "0";
        if ((baseRequest.getParameter("data") != null) && (baseRequest.getParameter("data").equals("true")))data = "1";
        try {
            DataBaseAnswer = MobileAPP.Preferences(APIServer.getDatabase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"),baseRequest.getParameter("ln"), profile, data);
        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }
        return DataBaseAnswer;
    }

    private String ProfileSet(HttpServletRequest baseRequest){
        String DataBaseAnswer;
        try {
            JSONObject data = new JSONObject(APIServer.getBody(baseRequest));
            String name = data.getString("name");
            String email = data.getString("email");
            DataBaseAnswer = MobileAPP.ProfileSet(APIServer.getDatabase(), baseRequest.getParameter("token"), name, email);
        } catch (IOException | CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }
        return DataBaseAnswer;
    }


}
