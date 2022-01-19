import ataxi.API.Taxsee;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;
import tools.DataBaseResponse;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

public class TaxseeAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        JSONObject auth = new JSONObject(Taxsee.Auth(dataBase, param("x-api-key")));
        for (String key : JSONObject.getNames(auth)) {
            authorization.put(key, String.valueOf(auth.get(key)));
        }
        String dataBaseAnswer = "401";

        if (!param("dispatchingID").equals("0")) {
            if (target.substring(0, 5).equals("/dev/")) {
                paramSet("test", "1");
                target = target.substring(4);
            } else {
                paramSet("test", "0");
            }

            switch (target) {
                case "/processing/createorupdate":
                    dataBaseAnswer = ProcessingCreateOrUpdate();
                    break;
                case "/processing/set_status":
                    dataBaseAnswer = Taxsee.ProcessingSetStatus(dataBase, param("order_id"), param("status"));
                    break;
                case "/processing/get":
                    dataBaseAnswer = Taxsee.ProcessingGet(dataBase, param("order_id"));
                    break;
                case "/processing/client_coord":
                    dataBaseAnswer = ProcessingClientCoord();
                    break;
                case "/owner/set_status":
                    dataBaseAnswer = OwnerSetStatus();
                    break;
                case "/owner/driver_coord":
                    dataBaseAnswer = OwnerDriverCoord();
                    break;
                case "/owner/get":
                    dataBaseAnswer = OwnerGet();
                    break;
                default:
                    dataBaseAnswer = "404";
            }
        }
        response.setResponse(dataBaseAnswer);
        return response;
    }

    private String OwnerGet() throws CacheException {
        String OrderJSON = Taxsee.OwnerGet(dataBase, param("order_id"));
        return "200^" + OrderJSON + "^";
    }

    private String OwnerDriverCoord() throws CacheException {
        StringBuilder data = new StringBuilder();
        data.append("order_id").append("^");                                // 1
        data.append(bodyField("latitude")).append("^");                     // 2
        data.append(bodyField("longitude")).append("^");                    // 3
        data.append(bodyField("address")).append("^");                      // 4

        return Taxsee.OwnerDriverCoord(dataBase, data.toString(), param("utf"));

    }

    private String OwnerSetStatus() throws CacheException {
        JSONObject driverInfo = bodyJSONObject("driver_info");
        JSONObject autoInfo = bodyJSONObject("auto_info");

        StringBuilder data = new StringBuilder();
        data.append(param("order_id")).append("^");                        //  1
        data.append(param("status")).append("^");                          //  2
        data.append(param("price")).append("^");                           //  3
        data.append(JSONGetString(driverInfo, "id")).append("^");           //  4
        data.append(JSONGetString(driverInfo, "name")).append("^");         //  5
        data.append(JSONGetString(driverInfo, "nick_name")).append("^");    //  6
        data.append(JSONGetString(driverInfo, "phone")).append("^");        //  7
        data.append(JSONGetString(autoInfo, "model")).append("^");          //  8
        data.append(JSONGetString(autoInfo, "color")).append("^");          //  9
        data.append(JSONGetString(autoInfo, "number")).append("^");         // 10
        return Taxsee.OwnerSetStatus(dataBase, data.toString(), param("utf"));
    }

    private String ProcessingCreateOrUpdate() throws CacheException {
        if (bodyField("id").equals("")) return "400^Поле id не установлено";
        if (bodyField("id_tariff_type").equals("")) return "400^Поле id_tariff_type не установлено";
        if (bodyField("phone").equals("")) return "400^Поле phone не установлено";
        if (bodyField("date_create").equals("")) return "400^Поле date_create не установлено";
        if (bodyField("edit_count").equals("")) return "400^Поле edit_count не установлено";
        if (bodyField("point_start").equals("")) return "400^Поле point_start не установлено";
        // if (bodyField("comment_start").equals(""))return "400^Поле comment_start не установлено";
        if (bodyField("price").equals("")) return "400^Поле price не установлено";
        if (bodyField("free_wait_time").equals("")) return "400^Поле free_wait_time не установлено";
        if (bodyField("need_time").equals("")) return "400^Поле need_time не установлено";
        if (bodyField("need_distance").equals("")) return "400^Поле need_distance не установлено";
        if (bodyField("need_distance").equals("")) return "400^Поле need_distance не установлено";

        JSONObject pointStart = bodyJSONObject("point_start");
        JSONArray routePoints = bodyJSONArray("route_points");
        JSONArray addPrices = bodyJSONArray("add_price");


        String Data = "";
        Data += bodyField("id") + "^";                       // 01. id
        Data += (routePoints.length() + 1) + "^";            // 02. routeCount
        Data += addPrices.length() + "^";                     // 03. addPriceCount
        Data += param("dispatchingID") + "^";         // 04. dispatchingID
        Data += bodyField("id_tariff_type") + "^";           // 05. idTariffType
        Data += bodyField("phone") + "^";                    // 06. phone
        Data += bodyField("date_create") + "^";              // 07. dateCreate
        Data += bodyField("date_start") + "^";               // 08. dateStart
        Data += bodyField("sum_noncash") + "^";              // 09. sumNoncash
        Data += bodyField("edit_count") + "^";               // 10. editCount
        Data += bodyField("comment_start") + "^";            // 11. commentStart
        Data += bodyField("comment_order") + "^";            // 12. commentOrder
        Data += bodyField("length") + "^";                   // 13. length
        Data += bodyField("empty_length") + "^";             // 14. emptyLength
        Data += bodyField("length_out") + "^";               // 15. lengthOut
        Data += bodyField("duration") + "^";                 // 16. duration
        Data += bodyField("price") + "^";                    // 17. price
        Data += bodyField("free_wait_time") + "^";           // 18. freeWaitTime
        Data += bodyField("need_time") + "^";                // 19. needTime
        Data += bodyField("need_distance") + "^";            // 20. needDistance
        Data += bodyField("time_calc") + "^";                // 21. timeCalc
        Data += bodyField("sum_add_prices_from_drv") + "^";  // 22. sumAddPricesFromDrv
        Data += bodyField("id_organization_order") + "^";    // 23. idOrganizationOrder
        Data += param("test") + "^";                   // 24. isTest
        Data += routePoints.toString() + "^";                // 25. jsonRoutePoints
        Data += addPrices.toString() + "^";                  // 26. jsonAddPrice
        Data += pointStart.toString() + "^";                 // 27. jsonPointStart

        StringBuilder Routes = new StringBuilder();

        String data = "^";
        String urlString;
        JSONObject response;


        Routes.append(JSONGetString(pointStart, "latitude")).append("^");
        Routes.append(JSONGetString(pointStart, "longitude")).append("^");
        Routes.append(JSONGetString(pointStart, "address")).append("^");
        Routes.append(geocode(pointStart)).append("|");

        for (int itemID = 0; itemID < routePoints.length(); itemID++) {
            JSONObject routePoint = routePoints.getJSONObject(itemID);
            Routes.append(JSONGetString(routePoint, "latitude")).append("^");
            Routes.append(JSONGetString(routePoint, "longitude")).append("^");
            Routes.append(JSONGetString(routePoint, "address")).append("^");
            Routes.append(geocode(routePoint)).append("|");

        }
        StringBuilder AddPrices = new StringBuilder();
        for (int itemID = 0; itemID < addPrices.length(); itemID++) {
            JSONObject addPrice = addPrices.getJSONObject(itemID);
            AddPrices.append(JSONGetString(addPrice, "id")).append("^");
            AddPrices.append(JSONGetString(addPrice, "name")).append("^");
            AddPrices.append(JSONGetString(addPrice, "number")).append("^|");
        }

        return Taxsee.ProcessingCreateOrUpdate(dataBase, Data, Routes.toString(), AddPrices.toString(), param("utf"));
    }


    private String geocodeEx(JSONObject routePoint) {
        String result = "^";
        if (JSONGetString(routePoint, "address").equals("") || JSONGetString(routePoint, "address").equalsIgnoreCase("Местоположение маркера")) {
            result = geocodeEx(routePoint);
        }
        return result;
    }


    private String geocode(JSONObject routePoint) {
        String result = "^";
        if (!JSONGetString(routePoint, "address").equals("Местоположение маркера")) {
            return result;
        }

        String urlString = "http://geo.toptaxi.org/taxsee_geocode?lt=" + JSONGetString(routePoint, "latitude")
                + "&ln=" + JSONGetString(routePoint, "longitude")
                + "&str=" + URLEncoder.encode(JSONGetString(routePoint, "address"));
        JSONObject response = APIServer.httpGet(urlString);
        if (response.has("status")) {
            if (response.getString("status").equals("OK")) {
                JSONObject resultJSON = response.getJSONObject("result");
                if (!JSONGetString(resultJSON, "result").equals("Уфа (Республика Башкортостан)")) {
                    result = JSONGetString(resultJSON, "name") + "^";
                    result += JSONGetString(resultJSON, "dsc") + "^";
                    result += JSONGetString(resultJSON, "result") + "^";
                    result += JSONGetString(resultJSON, "result_ufa") + "^";
                }

            }
        }

        if (result.equals("^")) {
            urlString = "http://geo.toptaxi.org/geocode?lt=" + JSONGetString(routePoint, "latitude")
                    + "&ln=" + JSONGetString(routePoint, "longitude");
            response = APIServer.httpGet(urlString);
            if (response.has("status")) {
                if (response.getString("status").equals("OK")) {
                    JSONObject resultJSON = response.getJSONObject("result");
                    result = JSONGetString(resultJSON, "name") + "^";
                    result += JSONGetString(resultJSON, "dsc") + "^";
                    result += JSONGetString(resultJSON, "name") + " (" + JSONGetString(resultJSON, "dsc") + ")" + "^";
                    result += JSONGetString(resultJSON, "name") + "^";

                }
            }
        }


        return result;
    }

    private String ProcessingClientCoord() throws CacheException {
        String Data = "";
        return Taxsee.ProcessingClientCoord(dataBase, param("order_id"), Data);
    }
}
