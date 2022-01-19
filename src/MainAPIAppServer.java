import ataxi.API.GEO2;
import ataxi.API.MainAPI;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;
import tools.DataBaseResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class MainAPIAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        String DataBaseAnswer = "404";

        switch (target) {
            case "/asterisk/incoming_call":
                DataBaseAnswer = MainAPI.AsteriskIncomingCall(getDataBase(), getParameter(baseRequest, "uid"), getParameter(baseRequest, "trunk"), getParameter(baseRequest, "phone"));
                break;
            case "/asterisk/action":
                DataBaseAnswer = MainAPI.AsteriskAction(getDataBase(), getParameter(baseRequest, "action"), getParameter(baseRequest, "uid"), getParameter(baseRequest, "trunk"), getParameter(baseRequest, "phone"), getParameter(baseRequest, "param"), getParameter(baseRequest, "param2"));
                break;
            case "/asterisk/queue":
                DataBaseAnswer = MainAPI.AsteriskQueue(getDataBase(), getParameter(baseRequest, "uid"), getParameter(baseRequest, "trunk"), getParameter(baseRequest, "phone"), getParameter(baseRequest, "queue"), getParameter(baseRequest, "count"));
                break;
            case "/driver/covidreference":
                DataBaseAnswer = MainAPI.DriverCovidReference(getDataBase(), getParameter(baseRequest, "token"));
                break;
            case "/opers/calc":
                DataBaseAnswer = OpersCalc(param("calc"));
                break;
        }
        return new DataBaseResponse(DataBaseAnswer);
    }

    private String OpersCalc(String calcString) throws UnsupportedEncodingException, CacheException {
        String[] calcData = calcString.split("\\|");

        JSONArray route = new JSONArray();
        JSONArray distances = new JSONArray();

        for (int itemID = 6; itemID < calcData.length; itemID = itemID + 5) { // Разбираем actions
            if (calcData[itemID].equals("1") || calcData[itemID].equals("28")) { // Если точка маршрута
                String str = calcData[itemID + 2].split(" - ")[0];
                String urlString = "http://geo.toptaxi.org/geocode?lt=54.765375&ln=56.047584&name=" + URLEncoder.encode(str, "UTF-8");
                JSONObject response = APIServer.httpGet(urlString);
                if (response.has("status")) {
                    if (response.getString("status").equals("OK")) {
                        JSONObject routePoint = response.getJSONObject("result");
                        String data = JSONGetString(routePoint, "name") + "|";
                        data += JSONGetString(routePoint, "dsc") + "|";
                        data += JSONGetString(routePoint, "lt") + "|";
                        data += JSONGetString(routePoint, "ln") + "|";
                        GEO2.SetGeoCode(dataBase, str, routePoint.getString("place_id"), data);
                        if (calcData[itemID + 2].split(" - ").length > 1) {
                            routePoint.put("note", calcData[itemID + 2].split(" - ")[1]);
                        }
                        route.put(routePoint);
                        GEO2.DistanceDataToCalc(dataBase, JSONGetString(routePoint, "lt"), JSONGetString(routePoint, "ln"));
                       // System.out.println(GEO2.DistanceDataToCalc(dataBase, JSONGetString(routePoint, "lt"), JSONGetString(routePoint, "ln")));
                        if (route.length() > 1) {
                            JSONObject lastRoutePoint = route.getJSONObject(route.length() - 2);
                            JSONObject distance = getGEO().distanceGet(
                                    JSONGetString(lastRoutePoint, "lt"),
                                    JSONGetString(lastRoutePoint, "ln"),
                                    JSONGetString(routePoint, "lt"),
                                    JSONGetString(routePoint, "ln"),
                                    "0", "");
                            if (JSONGetString(distance, "status").equals("calc")) {
                                GEO2.SetDistanceForCalc(dataBase, JSONGetString(distance, "uid"), distance.toString());
                            }
                            distances.put(distance);
                        }
                    } // if (response.getString("status").equals("OK")) {
                    else {
                        GEO2.SetGeoCodeNotFound(dataBase, calcData[itemID + 2]);
                    }
                } // if (response.has("status")) {


            } // Если точка маршрут
        } // Разбираем actions

        // System.out.println(route.toString());

        JSONObject result = new JSONObject();
        result.append("route", route);
        result.append("distance", distances);

        return "200^" + result + "^";
    }


}
