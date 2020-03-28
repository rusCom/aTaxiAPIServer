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
        String dataBaseAnswer;


        if (!param("dispatchingID").equals("0")) {
            switch (target) {
                case "/profile/login":
                    dataBaseAnswer = Booking.ProfileLogin(dataBase, param("dispatchingID"), param("phone"), param("type", "sms"), param("test"));
                    break;
                case "/profile/registration":
                    dataBaseAnswer = Booking.ProfileRegistration(dataBase, param("dispatchingID"), param("phone"), param("code"));
                    break;

                case "/orders/pickup":
                    dataBaseAnswer = Booking.OrdersPickUp(dataBase, param("dispatchingID"), param("lt"), param("ln"));
                    break;
                case "/orders/calc":
                    dataBaseAnswer = ordersCalc();
                    break;
                default:
                    if (!param("clientID").equals("0")) {
                        Booking.SetData(dataBase, param("clientID"), param("lt"), param("ln"));
                        switch (target) {
                            case "/profile/auth":
                                dataBaseAnswer = Booking.ProfileAuth(dataBase, param("dispatchingID"), param("clientID"), param("cityID"));
                                break;
                            case "/data":
                                dataBaseAnswer = Booking.Data(dataBase, param("clientID"));
                                break;
                            default:
                                dataBaseAnswer = "404";
                                break;
                        }
                    } else {
                        dataBaseAnswer = "403";
                    }
                    break;
            }
        } else {
            dataBaseAnswer = "403";
        }

        response.setResponse(dataBaseAnswer);
        return response;
    }

    String ordersCalc() throws CacheException {
        JSONObject body = body();
        String data = "";
        if (!body.has("date")) {body.put("date", "");}
        if (!body.has("payment")) {body.put("payment", "cash");}
        if (body.getString("payment").equals("")) {body.put("payment", "cash");}

        JSONObject distance = getDistance().distanceRoutes(body.getJSONArray("route"), param("test"));
        data += param("deviceId") + "^";                        // 1
        data += param("dispatchingID") + "^";                   // 2
        data += param("clientID") + "^";                        // 3
        data += distance.getString("distance") + "^";             // 4
        data += body.getJSONArray("route").length() + "^";        // 5
        data += body.getString("date") + "^";                     // 6
        data += body.getString("payment") + "^";                  // 7

        // System.out.println(data);
        // System.out.println(distance.getString("routeString"));
        return Booking.OrdersCalc(dataBase, data, distance.getString("routeString"));
    }
}
