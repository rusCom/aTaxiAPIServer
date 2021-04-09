import API.Taxsee;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

public class TaxseeAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        JSONObject auth = new JSONObject(Taxsee.Auth(dataBase, param("x-api-key")));
        for (String key : JSONObject.getNames(auth)) {
            authorization.put(key, String.valueOf(auth.get(key)));
        }
        String dataBaseAnswer = "401";

        if (!param("dispatchingID").equals("0")){
            if (target.substring(0, 5).equals("/dev/")){
                paramSet("test", "1");
                target = target.substring(4);
            }
            else {paramSet("test", "0");}

            switch (target){
                case "/processing/createorupdate":dataBaseAnswer = ProcessingCreateOrUpdate();break;
                case "/processing/set_status": dataBaseAnswer = Taxsee.ProcessingSetStatus(dataBase, param("order_id"), param("status"));break;
                case "/processing/get": dataBaseAnswer = Taxsee.ProcessingGet(dataBase, param("order_id"));break;
                case "/processing/client_coord": dataBaseAnswer = ProcessingClientCoord();break;
                default:dataBaseAnswer = "404";
            }
        }
        response.setResponse(dataBaseAnswer);
        return response;
    }

    private String ProcessingCreateOrUpdate() throws CacheException {
        if (bodyField("id").equals(""))return "400^Поле id не установлено";
        if (bodyField("id_tariff_type").equals(""))return "400^Поле id_tariff_type не установлено";
        if (bodyField("phone").equals(""))return "400^Поле phone не установлено";
        if (bodyField("date_create").equals(""))return "400^Поле date_create не установлено";
        if (bodyField("edit_count").equals(""))return "400^Поле edit_count не установлено";
        if (bodyField("point_start").equals(""))return "400^Поле point_start не установлено";
        if (bodyField("comment_start").equals(""))return "400^Поле comment_start не установлено";
        if (bodyField("price").equals(""))return "400^Поле price не установлено";
        if (bodyField("free_wait_time").equals(""))return "400^Поле free_wait_time не установлено";
        if (bodyField("need_time").equals(""))return "400^Поле need_time не установлено";
        if (bodyField("need_distance").equals(""))return "400^Поле need_distance не установлено";
        if (bodyField("need_distance").equals(""))return "400^Поле need_distance не установлено";

        JSONObject pointStart = bodyJSONObject("point_start");
        JSONArray routePoints = bodyJSONArray("route_points");
        JSONArray addPrices = bodyJSONArray("add_price");


        String Data = "";
        Data += bodyField("id") +"^";                       // 01. id
        Data += (routePoints.length() + 1) +"^";            // 02. routeCount
        Data += addPrices.length() +"^";                     // 03. addPriceCount
        Data += param("dispatchingID") +"^";         // 04. dispatchingID
        Data += bodyField("id_tariff_type") +"^";           // 05. idTariffType
        Data += bodyField("phone") +"^";                    // 06. phone
        Data += bodyField("date_create") +"^";              // 07. dateCreate
        Data += bodyField("date_start") +"^";               // 08. dateStart
        Data += bodyField("sum_noncash") +"^";              // 09. sumNoncash
        Data += bodyField("edit_count") +"^";               // 10. editCount
        Data += bodyField("comment_start") +"^";            // 11. commentStart
        Data += bodyField("comment_order") +"^";            // 12. commentOrder
        Data += bodyField("length") +"^";                   // 13. length
        Data += bodyField("empty_length") +"^";             // 14. emptyLength
        Data += bodyField("length_out") +"^";               // 15. lengthOut
        Data += bodyField("duration") +"^";                 // 16. duration
        Data += bodyField("price") +"^";                    // 17. price
        Data += bodyField("free_wait_time") +"^";           // 18. freeWaitTime
        Data += bodyField("need_time") +"^";                // 19. needTime
        Data += bodyField("need_distance") +"^";            // 20. needDistance
        Data += bodyField("time_calc") +"^";                // 21. timeCalc
        Data += bodyField("sum_add_prices_from_drv") +"^";  // 22. sumAddPricesFromDrv
        Data += bodyField("id_organization_order") +"^";    // 23. idOrganizationOrder
        Data += param("test") +"^";                  // 24. isTest
        Data += routePoints.toString() +"^";                // 25. jsonRoutePoints
        Data += addPrices.toString() +"^";                  // 26. jsonAddPrice
        Data += pointStart.toString() +"^";                 // 27. jsonPointStart

        String Routes = "";
        Routes += JSONGetString(pointStart,"latitude") + "^";
        Routes += JSONGetString(pointStart,"longitude") + "^";
        Routes += JSONGetString(pointStart,"address") + "^|";
        for (int itemID = 0; itemID < routePoints.length(); itemID++) {
            JSONObject routePoint = routePoints.getJSONObject(itemID);
            Routes += JSONGetString(routePoint,"latitude") + "^";
            Routes += JSONGetString(routePoint,"longitude") + "^";
            Routes += JSONGetString(routePoint,"address") + "^|";
        }
        String AddPrices = "";
        for (int itemID = 0; itemID < addPrices.length(); itemID++) {
            JSONObject addPrice = addPrices.getJSONObject(itemID);
            AddPrices += JSONGetString(addPrice, "id") + "^";
            AddPrices += JSONGetString(addPrice, "name") + "^";
            AddPrices += JSONGetString(addPrice, "number") + "^|";
        }



        return Taxsee.ProcessingCreateOrUpdate(dataBase, Data, Routes, AddPrices, param("utf"));
    }

    private String ProcessingClientCoord() throws CacheException {
        String Data = "";
        return Taxsee.ProcessingClientCoord(dataBase, param("order_id"), Data);
    }
}
