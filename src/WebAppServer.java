import API.WebAPP;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class WebAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        String[] targets = target.split("/");
        String DataBaseAnswer = "400^^";

        try {
            switch (targets[1]){
                case "preferences":DataBaseAnswer = WebAPP.Preferences(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "token"), getParameter(baseRequest, "lt"),getParameter(baseRequest, "ln"),getParameter(baseRequest, "city"));break;
                case "profile":
                    switch (targets[2]){
                        case "login":DataBaseAnswer = WebAPP.ProfileLogin(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "phone"), getParameter(baseRequest, "type"));break;
                        case "registration":DataBaseAnswer = WebAPP.ProfileRegistration(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "phone"), getParameter(baseRequest, "code"));break;
                        case "get":DataBaseAnswer = WebAPP.ProfileGet(getDataBase(), getParameter(baseRequest, "token"));break;
                    }
                    break; //case "profile":
                case "data":DataBaseAnswer = WebAPP.Data(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "token"), getParameter(baseRequest, "city"));break;
                case "orders":
                    switch (targets[2]){
                        case "calc":DataBaseAnswer = OrdersCalc(baseRequest);break;
                        case "add":DataBaseAnswer = WebAPP.OrdersAdd(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "calc"), getParameter(baseRequest, "note"), getParameter(baseRequest, "price"), getParameter(baseRequest, "test"));break;
                        case "deny":DataBaseAnswer = WebAPP.OrdersDeny(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "reason"));break;
                    }
                    break; // case "orders":

            }

        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }


        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");

        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }

    private String OrdersCalc(HttpServletRequest baseRequest){
        String DataBaseAnswer;
        try {
            JSONObject data = new JSONObject(getBody(baseRequest));
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

            System.out.println("routes" + routes.toString());



            DataBaseAnswer = WebAPP.OrdersCalc(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "token"), DataString, WishString, RouteString);
            System.out.println("!!!" + DataBaseAnswer);
            if (DataBaseAnswer.split("\\^")[0].equals("200")){
                JSONObject databaseResult = new JSONObject(DataBaseAnswer.split("\\^")[1]);
                System.out.println(databaseResult.toString());
                JSONObject result = new JSONObject();
                result.put("uid", databaseResult.getString("calc_uid"));
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
}
