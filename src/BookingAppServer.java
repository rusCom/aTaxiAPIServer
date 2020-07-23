import API.Booking;
import com.intersys.objects.CacheException;
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

    String ordersCalc() throws CacheException {
        String data = "";
        System.out.println(bodyJSONArray("route"));
        JSONObject distance = getDistance().distanceRoutes(bodyJSONArray("route"), param("test"));
        // System.out.println(distance);
        data += param("deviceId") + "^";                        // 1
        data += param("dispatchingID") + "^";                   // 2
        data += param("clientID") + "^";                        // 3
        data += distance.getString("distance") + "^";             // 4
        data += distance.getString("duration") + "^";             // 5
        data += bodyJSONArray("route").length() + "^";           // 6
        data += bodyField("date", "") + "^";                // 7
        data += bodyField("payment", "cash") + "^";         // 8

        // System.out.println(data);
        // System.out.println(distance.getString("routeString"));
        return Booking.OrdersCalc(dataBase, data, distance.getString("routeString"));
    }
}
