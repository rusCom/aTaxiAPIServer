import ataxi.API.Booking;
import ataxi.API.CRM;
import com.intersys.objects.CacheException;
import org.json.JSONObject;
import tools.DataBaseResponse;
import tools.MainUtils;

import javax.servlet.http.HttpServletRequest;

public class CRMAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        JSONObject auth = new JSONObject(CRM.Auth(dataBase, param("token")));
        for (String key : JSONObject.getNames(auth)) {
            authorization.put(key, String.valueOf(auth.get(key)));
        }
        String dataBaseAnswer = "401";

        if (target.equals("/profile/registration")) {
            dataBaseAnswer = CRM.ProfileRegistration(dataBase, param("phone"), param("code"));

        } // if (param("userID").equals("0"))
        else {
            switch (target) {
                case "/profile/auth":
                    dataBaseAnswer = CRM.ProfileAuth(dataBase, param("userID"));
                    break;
                case "/call/incoming":
                    dataBaseAnswer = CRM.CallIncoming(dataBase, param("userID"), param("phone"), param("trunk"));
                    break;
                case "/orders/calc":
                    dataBaseAnswer = ordersCalc();
                    break;
                case "/data":
                    dataBaseAnswer = CRM.Data(dataBase, param("userID"));
                    break;
                default:
                    dataBaseAnswer = "404";
                    break;
            }
        }
        response.setResponse(dataBaseAnswer);
        return response;
    }

    String ordersCalc() throws CacheException {
        String data = "";
        JSONObject distance = getGEO().distanceRoutes(bodyJSONArray("route"), "0", Booking.GoogleKey(dataBase, param("dispatchingID")));
        JSONObject wishes = bodyJSONObject("wishes");
        JSONObject babySeats = JSONGetObject(wishes, "baby_seats");

        data += param("userID") + "^";                                 // 1
        data += bodyField("trunk") + "^";                                   // 2
        data += bodyField("client_id") + "^";                                // 3
        data += distance.getString("distance") + "^";                    // 4
        data += distance.getString("duration") + "^";                    // 5
        data += bodyJSONArray("route").length() + "^";                  // 6
        data += bodyField("client_phone") + "^";                            // 7
        data += "^"; //  8
        data += "^"; //  9
        data += "^"; // 10


        data += MainUtils.JSONGetString(wishes, "work_date") + "^";               // 11
        data += MainUtils.JSONGetString(wishes, "driver_note") + "^";             // 12
        data += MainUtils.JSONGetString(wishes, "pet_transportation") + "^";      // 13
        data += MainUtils.JSONGetString(wishes, "non_smoking_salon") + "^";       // 14
        data += MainUtils.JSONGetString(wishes, "conditioner") + "^";             // 15
        data += MainUtils.JSONGetString(babySeats, "0010") + "^";                 // 16
        data += MainUtils.JSONGetString(babySeats, "0918") + "^";                 // 17
        data += MainUtils.JSONGetString(babySeats, "1525") + "^";                 // 18
        data += MainUtils.JSONGetString(babySeats, "2236") + "^";                 // 19

        BookingAppServer.sendGEOStatistics(bodyJSONArray("route"));

        return CRM.OrdersCalc(dataBase, data, distance.getString("routeString"), UTF);
    }
}
