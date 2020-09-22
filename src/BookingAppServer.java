import API.Booking;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

public class BookingAppServer extends AppServer {

    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        JSONObject auth = new JSONObject(Booking.Auth(dataBase, param("dispatching"), param("token"), param("lt"), param("ln")));
        for (String key : JSONObject.getNames(auth)) {
            authorization.put(key, String.valueOf(auth.get(key)));
        }
        String dataBaseAnswer = "403";

        if (!param("dispatchingID").equals("0")) {
            switch (target) {
                case "/profile/auth":
                    dataBaseAnswer = Booking.ProfileAuth(dataBase, param("dispatchingID"), param("clientID"), param("cityID"));
                    break;
                case "/profile/login":
                    dataBaseAnswer = Booking.ProfileLogin(dataBase, param("dispatchingID"), param("phone"), param("type", "sms"), param("test"));
                    break;
                case "/profile/registration":
                    dataBaseAnswer = Booking.ProfileRegistration(dataBase, param("dispatchingID"), param("phone"), param("code"));
                    break;
                default:
                    if (!param("clientID").equals("0")) {
                        Booking.SetData(dataBase, param("clientID"), param("lt"), param("ln"));
                        switch (target) {
                            case "/data":
                                dataBaseAnswer = Booking.Data(dataBase, param("clientID"));
                                break;
                            case "/orders/pickup":
                                dataBaseAnswer = Booking.OrdersPickUp(dataBase, param("dispatchingID"), param("lt"), param("ln"));
                                break;
                            case "/orders/calc":
                                dataBaseAnswer = ordersCalc();
                                break;
                            case "/orders/add":
                                dataBaseAnswer = ordersAdd();
                                break;
                            case "/orders/deny":
                                dataBaseAnswer = Booking.OrdersDeny(dataBase, param("token"), param("uid"), param("reason"), UTF);
                                break;
                            default:
                                dataBaseAnswer = "404";
                                break;
                        }
                    }
                    break;
            }
        }

        response.setResponse(dataBaseAnswer);
        return response;
    }

    String ordersAdd() throws CacheException {
        if (bodyField("uid").equals(""))return "400^Поле UID не установлено";
        if (bodyField("payment").equals(""))return "400^Поле payment не установлено";
        if (bodyField("tariff").equals(""))return "400^Поле tariff не установлено";

        String data = "";
        data += bodyField("uid") + "^";                // 1
        data += param("deviceId") + "^";         // 2
        data += bodyField("payment") + "^";             // 3
        data += bodyField("tariff") + "^";              // 4
        data += bodyField("price") + "^";               // 5
        data += bodyField("orderNote") + "^";           // 6
        data += bodyField("routeNote") + "^";           // 7
        data += param("test") + "^";             // 8
        APIServer.consoleLog(this, "ordersAdd", data);


        return Booking.OrdersAdd(dataBase, data, UTF);
    }

    String ordersCalc() throws CacheException {
        String data = "";
        JSONObject distance = getGEO().distanceRoutes(bodyJSONArray("route"), "0", Booking.GoogleKey(dataBase, param("dispatchingID")));

        APIServer.consoleLog(this, "ordersCalc", distance);
        data += param("deviceId") + "^";                        // 1
        data += param("dispatchingID") + "^";                   // 2
        data += param("clientID") + "^";                        // 3
        data += distance.getString("distance") + "^";             // 4
        data += distance.getString("duration") + "^";             // 5
        data += bodyJSONArray("route").length() + "^";           // 6
        data += bodyField("work_date", "") + "^";           // 7
        data += bodyField("payment", "cash") + "^";         // 8

        sendGEOStatistics(bodyJSONArray("route"));

        return Booking.OrdersCalc(dataBase, data, distance.getString("routeString"), UTF);
    }

    private void sendGEOStatistics(final JSONArray orderRoute){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < orderRoute.length(); i++) {
                    JSONObject routePoint = orderRoute.getJSONObject(i);
                    if (routePoint.has("place_id")){
                        String urlString = "http://geo.toptaxi.org/check?place_id=" + routePoint.getString("place_id");
                        APIServer.httpGet(urlString);
                        // APIServer.consoleLog(this, "sendGEOStatistics", urlString);
                    }
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
