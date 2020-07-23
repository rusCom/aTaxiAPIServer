
import API.Booking;
import API.MobileAPP;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


class MobileAppServer extends AppServer {
    private static PrintWriter logCalcPrintWriter;
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest)  {

        String[] targets = target.split("/");
        String DataBaseAnswer = "400^^";

        try {
            switch (targets[1]){
                case "profile":
                    switch (targets[2]){
                        case "login":DataBaseAnswer = MobileAPP.ProfileLogin(getDataBase(), baseRequest.getParameter("key"), baseRequest.getParameter("phone"), baseRequest.getParameter("type"));break;
                        case "registration":DataBaseAnswer = MobileAPP.ProfileRegistration(getDataBase(), baseRequest.getParameter("key"), baseRequest.getParameter("phone"), baseRequest.getParameter("code"));break;
                        case "get":DataBaseAnswer = MobileAPP.ProfileGet(getDataBase(), baseRequest.getParameter("token"));break;
                        case "check_phone":DataBaseAnswer = MobileAPP.ProfileCheckPhone(getDataBase(), baseRequest.getParameter("token"), baseRequest.getParameter("phone"));break;
                        case "check_phone_code":DataBaseAnswer = MobileAPP.ProfileCheckPhoneCode(getDataBase(), baseRequest.getParameter("token"), baseRequest.getParameter("phone"), baseRequest.getParameter("code"));break;
                        case "set":DataBaseAnswer = ProfileSet(baseRequest);
                    }
                    break; // case "profile"
                case "preferences":
                    DataBaseAnswer = MobileAPP.Preferences(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "lt"), getParameter(baseRequest, "ln"), getParameter(baseRequest, "profile"), getParameter(baseRequest, "data"));
                    break;
                case "data":
                    DataBaseAnswer = MobileAPP.Data(getDataBase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"),baseRequest.getParameter("ln"));
                    break; // case "data"
                case "orders":
                    switch (targets[2]){
                        case "calc": DataBaseAnswer = OrdersCalc(baseRequest);break;
                        case "add": DataBaseAnswer = OrdersAdd(baseRequest);break;
                        case "deny": DataBaseAnswer = MobileAPP.OrdersDeny(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "reason"), getParameter(baseRequest, "lt"), getParameter(baseRequest, "ln"));break;
                        case "history": DataBaseAnswer = MobileAPP.OrdersHistory(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "guid"));break;
                        case "feedback": DataBaseAnswer = MobileAPP.OrdersFeedback(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "guid"), getParameter(baseRequest, "rating"), getParameter(baseRequest, "note"));break;

                    }
                    break; // case "orders"
                case "sravnitaxi":
                    switch (targets[2]){
                        case "estimate":DataBaseAnswer = SravnitaxiEstimate(baseRequest);break;
                        case "manifest":DataBaseAnswer = MobileAPP.SravnitaxiManifest(getDataBase(), getParameter(baseRequest, "token"));break;
                        case "history":DataBaseAnswer = MobileAPP.SravnitaxiHistory(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "from"), getParameter(baseRequest, "to"));break;

                    }
                    break; //case "sravnitaxi":
            }
        } catch (CacheException | IOException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        return new DataBaseResponse(DataBaseAnswer);


    }

    private String SravnitaxiEstimate(HttpServletRequest baseRequest) throws CacheException, IOException {
        String DataBaseAnswer = "400";
        String token = getParameter(baseRequest, "token");
        if (token.trim().equals("")){return "400^incorrect dispatching token^";}
        String from = getParameter(baseRequest, "from");
        if (from.trim().equals("")){return "400^incorrect from location^";}
        String to = getParameter(baseRequest, "to");
        if (to.trim().equals("")){return "400^incorrect to location^";}
        String blt = from.split(",")[0];
        String bln = from.split(",")[1];
        String elt = to.split(",")[0];
        String eln = to.split(",")[1];
        JSONObject distance = getDistance().DistanceGet(blt, bln, elt, eln);
        //System.out.println(distance);
        if (distance.getString("result").equals("OK")){
            DataBaseAnswer = MobileAPP.SravnitaxiEstimate(getDataBase(), token, blt, bln, elt, eln, String.valueOf(distance.getInt("distance")));
            if (DataBaseAnswer.split("\\^")[0].equals("200")){
                JSONObject databaseResult = new JSONObject(DataBaseAnswer.split("\\^")[1]);
                System.out.println(databaseResult.toString());
                JSONObject result = new JSONObject();
                result.put("price", databaseResult.getJSONObject("calc").getString("price_rounded"));
                result.put("currency", "RUR");
                DataBaseAnswer = "200^" + result.toString() + "^";
            }
        }
        else {DataBaseAnswer = "500";}
        return DataBaseAnswer;
    }


    private String OrdersAdd(HttpServletRequest baseRequest) throws CacheException {
        String price = "";
        if (baseRequest.getParameter("price") != null)price = baseRequest.getParameter("price");
        int isTest = 0;
        if (APIServer.getIsTest())isTest = 1;
        return MobileAPP.OrdersAdd(getDataBase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"),baseRequest.getParameter("ln"), "0", baseRequest.getParameter("note"), price, isTest);
    }



    private String OrdersCalc(HttpServletRequest baseRequest) throws IOException, CacheException {
        String DataBaseAnswer;
        JSONObject result = new JSONObject(), data, wish, databaseResult = new JSONObject();
        JSONArray routes;
        String RouteString = "", DataString = "", WishString = "", distance = "0";

            data = new JSONObject(getBody(baseRequest));
            if (data.has("date"))DataString += data.getString("date") + "^";
            else {DataString += "^";}
            routes = data.getJSONArray("route");
            // System.out.println(data);
            if (data.has("distance")){
                if (String.valueOf(data.get("distance")).equals("0")){distance = String.valueOf(getDistance().DistanceGet(routes).get("distance"));}
                else if (String.valueOf(data.get("distance")).equals("")){distance = String.valueOf(getDistance().DistanceGet(routes).get("distance"));}
                else {distance = String.valueOf(data.get("distance"));}
            }
            else {
                distance = String.valueOf(getDistance().DistanceGet(routes).get("distance"));
            }

            for (int itemID = 0; itemID < routes.length(); itemID++){
                JSONObject route = routes.getJSONObject(itemID);
                RouteString += route.getString("address") + "^";
                if (route.has("note"))RouteString += route.getString("note") + "^";
                else RouteString += "^";
                RouteString += route.getString("lt") + "^";
                RouteString += route.getString("ln") + "^";
                if (route.has("dsc"))RouteString += route.getString("dsc") + "^";
                else RouteString += "^";
                RouteString += "***";
            }



            DataString += data.getString("category") + "^";
            DataString += distance + "^";
            DataString += "0^";
            DataString += data.getString("pay") + "^";

            wish = data.getJSONObject("wish");
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


            DataString += routes.length() + "^";





            DataBaseAnswer = MobileAPP.OrdersCalc(getDataBase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"), baseRequest.getParameter("ln"), DataString, WishString, RouteString);
            if (DataBaseAnswer.split("\\^")[0].equals("200")){
                databaseResult = new JSONObject(DataBaseAnswer.split("\\^")[1]);
                //System.out.println(databaseResult.toString());
                result = new JSONObject();
                result.put("uid", databaseResult.getString("calc_uid"));
                result.put("distance", databaseResult.getJSONObject("order").getString("distance"));
                result.put("price", databaseResult.getJSONObject("calc").getString("price_rounded"));
                if (databaseResult.getJSONObject("order").has("duration"))result.put("duration", databaseResult.getJSONObject("order").getString("duration"));
                //result.append("uid", databaseResult.getString("calc_uid"));
                DataBaseAnswer = "200^" + result.toString() + "^";
            }





        StringBuilder logText = new StringBuilder();
        logText.append("date").append("\t").append("= ").append(APIServer.getCurDateTime()).append("\n");
        logText.append("token").append("\t").append("= ").append(baseRequest.getParameter("token")).append("\n");
        logText.append("data").append("\t").append("= ").append(data.toString()).append("\n");
        logText.append("routes").append("\t").append("= ").append(routes.toString()).append("\n");
        logText.append("dist").append("\t").append("= ").append(distance.toString()).append("\n");
        logText.append("wish").append("\t").append("= ").append(wish.toString()).append("\n");
        logText.append("DataS").append("\t").append("= ").append(DataString).append("\n");
        logText.append("WishS").append("\t").append("= ").append(WishString).append("\n");
        logText.append("RouteS").append("\t").append("= ").append(RouteString).append("\n");


        logText.append("dbRes").append("\t").append("= ").append(databaseResult.toString()).append("\n");
        logText.append("result").append("\t").append("= ").append(result.toString()).append("\n");
        logText.append("********************************************************").append("\n");

        if (getAppSettings().getString("log_view").equals("console")){
            System.out.println(logText);
        }
        else if (getAppSettings().getString("log_view").equals("file")){
            getlogCalcPrintWriter().println(logText);
            getlogCalcPrintWriter().flush();
        }


        return DataBaseAnswer;
    }

    @Override
    public DataBaseResponse Preferences(HttpServletRequest baseRequest) throws CacheException {
        String DataBaseAnswer;
        String profile = "0";
        if ((baseRequest.getParameter("profile") != null) && (baseRequest.getParameter("profile").equals("true")))profile = "1";
        String data = "0";
        if ((baseRequest.getParameter("data") != null) && (baseRequest.getParameter("data").equals("true")))data = "1";
        try {
            DataBaseAnswer = MobileAPP.Preferences(getDataBase(), baseRequest.getParameter("token"), baseRequest.getParameter("lt"),baseRequest.getParameter("ln"), profile, data);
        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }
        return new DataBaseResponse(DataBaseAnswer);
    }

    private String ProfileSet(HttpServletRequest baseRequest){
        String DataBaseAnswer;
        try {
            JSONObject data = new JSONObject(getBody(baseRequest));
            String name = data.getString("name");
            String email = data.getString("email");
            DataBaseAnswer = MobileAPP.ProfileSet(getDataBase(), baseRequest.getParameter("token"), name, email);
        } catch (IOException | CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }
        return DataBaseAnswer;
    }

    private static PrintWriter getlogCalcPrintWriter() throws FileNotFoundException {
        if (logCalcPrintWriter == null){
            String logFileName     = APIServer.getCurDir() + "/log/" + APIServer.getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + "calc_log.txt";// + String.format("%s%s", getCurDateTime(), "log.txt");
            logCalcPrintWriter = new PrintWriter(new File(logFileName));
        }
        return logCalcPrintWriter;
    }


}
