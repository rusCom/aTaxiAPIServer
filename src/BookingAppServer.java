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
        String dataBaseAnswer = "404";

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
                            case "/orders/note":
                                dataBaseAnswer = Booking.OrdersNote(dataBase, param("clientID"), param("uid"), param("nite"), UTF);
                                break;
                            case "/orders/history":
                                dataBaseAnswer = Booking.OrdersHistory(dataBase, param("clientID"), param("uid"));
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

    String orders() throws CacheException{
        if (bodyField("uid").equals(""))return "400^Поле UID не установлено";
        return "200";

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
        // APIServer.consoleLog(this, "ordersAdd", data);


        return Booking.OrdersAdd(dataBase, data, UTF);
    }

    String ordersCalc() throws CacheException {
        String data = "";
        JSONObject distance     = getGEO().distanceRoutes(bodyJSONArray("route"), "0", Booking.GoogleKey(dataBase, param("dispatchingID")));
        JSONObject wishes       = bodyJSONObject("wishes");
        JSONObject babySeats    = JSONGetObject(wishes, "baby_seats");

        // APIServer.consoleLog(this, "ordersCalc", distance);
        data += param("deviceId") + "^";                               // 1
        data += param("dispatchingID") + "^";                          // 2
        data += param("clientID") + "^";                               // 3
        data += distance.getString("distance") + "^";                    // 4
        data += distance.getString("duration") + "^";                    // 5
        data += bodyJSONArray("route").length() + "^";                  // 6
        data += "^"; //  7
        data += "^"; //  8
        data += "^"; //  9
        data += "^"; // 10


        data += JSONGetString(wishes, "work_date") + "^";               // 11
        data += JSONGetString(wishes, "driver_note") + "^";             // 12
        data += JSONGetString(wishes, "pet_transportation") + "^";      // 13
        data += JSONGetString(wishes, "non_smoking_salon") + "^";       // 14
        data += JSONGetString(wishes, "conditioner") + "^";             // 15
        data += JSONGetString(babySeats, "0010") + "^";                 // 16
        data += JSONGetString(babySeats, "0918") + "^";                 // 17
        data += JSONGetString(babySeats, "1525") + "^";                 // 18
        data += JSONGetString(babySeats, "2236") + "^";                 // 19
        data += JSONGetString(wishes, "smoking_salon") + "^";           // 20
        data += JSONGetString(wishes, "receipt") + "^";                 // 21
        data += JSONGetString(wishes, "baggage") + "^";                 // 22


        // APIServer.consoleLog(this, "ordersCalc", wishes);
        // APIServer.consoleLog(this, "ordersCalc", babySeats);
        // APIServer.consoleLog(this, "ordersCalc", data);

        sendGEOStatistics(bodyJSONArray("route"));

        return Booking.OrdersCalc(dataBase, data, distance.getString("routeString"), UTF);
    }

    public static void sendGEOStatistics(final JSONArray orderRoute){
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
