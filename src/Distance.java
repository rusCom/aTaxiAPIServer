import API.Booking;
import API.MainAPI;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static java.lang.Math.round;

public class Distance {
    private Database dataBase;

    Distance(Database dataBase) {
        this.dataBase = dataBase;
    }

    public JSONObject distanceRoutes(JSONArray routes, String isTest){
        Integer dist = 0;
        Integer duration = 0;
        String blunder = "0";
        if (isTest.equals("1"))blunder = "0.5";
        String routeString = "";

        String lLt = "", lLn = "";
        for (int itemID = 0; itemID < routes.length(); itemID++){
            JSONObject route = routes.getJSONObject(itemID);
            if (!route.has("note")){route.put("note", "");}
            if (!route.has("dsc")){route.put("dsc", "");}
            String tRouteString = route.getString("name") + "^" + route.getString("dsc") + "^" + route.getString("lt") + "^" + route.getString("ln") + "^" + route.getString("note") + "^";
            routeString += tRouteString + "|";
            if (itemID > 0){

                JSONObject tDistance = null;
                try {
                    tDistance = new JSONObject(MainAPI.MapDistanceGet(dataBase, lLt, lLn, route.getString("lt"), route.getString("ln"), blunder));
                    // System.out.println(tDistance);
                } catch (CacheException e) {
                    e.printStackTrace();
                }
                dist += Integer.valueOf(tDistance.getString("distance"));
            }
            lLt = route.getString("lt");
            lLn = route.getString("ln");
        }

        duration = 50;

        float speed = 50*1000/60/60;

        duration = round(dist/speed);


        return new JSONObject().put("distance", dist.toString()).put("duration", duration.toString()).put("routeString", routeString).put("speed", String.valueOf(speed));
    }

    public JSONObject DistanceGet(String blt, String bln, String elt, String eln) throws CacheException, IOException {
        JSONObject DBAnswer = new JSONObject(MainAPI.MapDistanceGet(dataBase, blt, bln, elt, eln));

        if (DBAnswer.has("status"))
            if (!DBAnswer.getString("status").equals("OK"))
                DBAnswer = DistanceMatrixGet(blt ,bln, elt,eln);
        return DBAnswer;

    }

    public JSONObject DistanceGet(JSONArray routes) throws CacheException, IOException {
        JSONObject tDistance;
        Integer distance = 0;

        String lLt = "", lLn = "";
        for (int itemID = 0; itemID < routes.length(); itemID++){
            JSONObject route = routes.getJSONObject(itemID);
            if (itemID > 0){
                tDistance = DistanceGet(lLt, lLn, route.getString("lt"), route.getString("ln"));
                distance += tDistance.getInt("distance");

            }
            lLt = route.getString("lt");
            lLn = route.getString("ln");
        }
        JSONObject result = new JSONObject();
        result.put("distance", distance);


        return result;
    }

    private JSONObject DistanceMatrixGet(String blt, String bln, String elt, String eln) throws CacheException {
        String urlString = "http://geo.toptaxi.org/distance?blt=" + blt + "&bln=" + bln + "&elt=" + elt + "&eln=" + eln;
        JSONObject respJSON = APIServer.httpGet(urlString);
        if (respJSON.getString("status").equals("OK")){
            MainAPI.MapDistanceSet(dataBase, blt, bln, elt, eln, respJSON.getJSONObject("result").getString("distance"), respJSON.getJSONObject("result").getString("status"));
        }
        return respJSON.getJSONObject("result");
    }

}
