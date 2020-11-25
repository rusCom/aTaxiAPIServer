import API.GEO2;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.json.JSONArray;
import org.json.JSONObject;

public class GEO {
    private Database dataBase;

    GEO(Database dataBase) {
        this.dataBase = dataBase;
    }


    public JSONObject distanceRoutes(JSONArray routes, String blunder, String google_key) {
        int dist = 0;
        int duration = 0;
        StringBuilder routeString = new StringBuilder();


        String lLt = "", lLn = "";
        for (int itemID = 0; itemID < routes.length(); itemID++) {
            JSONObject route = routes.getJSONObject(itemID);
            if (!route.has("note")) {
                route.put("note", "");
            }
            if (!route.has("dsc")) {
                route.put("dsc", "");
            }
            String tRouteString = route.getString("name").replace("\"", "") + "^" + route.getString("dsc").replace("\"", "") + "^" + route.getString("lt") + "^" + route.getString("ln") + "^";
            if (route.has("note")){tRouteString += route.getString("note").replace("\"", "") + "^";}
            else {tRouteString += "^";}
            if (route.has("place_id")){tRouteString += route.getString("place_id") + "^";}
            else {tRouteString += "^";}

            routeString.append(tRouteString).append("|");
            if (itemID > 0) {

                JSONObject tDistance = null;
                try {
                    tDistance = distanceDB(lLt, lLn, route.getString("lt"), route.getString("ln"), blunder, google_key);

                    if (google_key != null && !google_key.equals("")) { // если задан ключ, то просчиываем все расстояние, которые могут понадобиться
                        JSONObject distanceToCalc = new JSONObject(GEO2.DistanceDataToCalc(dataBase, route.getString("lt"), route.getString("ln")));
                        // APIServer.consoleLog(this, "distanceRoutes", distanceToCalc);
                        JSONArray distancesToCalc =distanceToCalc.getJSONArray("res");

                        for (int itemID2 = 0; itemID2 < distancesToCalc.length(); itemID2++) {
                            distanceToCalc = distancesToCalc.getJSONObject(itemID2);
                            // APIServer.consoleLog(this, "distanceRoutes", distanceToCalc);
                            if (distanceToCalc.getString("status").equals("calc")){
                                distanceDB(distanceToCalc.getString("blt"), distanceToCalc.getString("bln"), distanceToCalc.getString("elt"), distanceToCalc.getString("eln"), "0", google_key);
                            }
                        }

                    }
                } catch (CacheException e) {
                    e.printStackTrace();
                }
                dist += Integer.parseInt(tDistance.getString("distance"));
                duration += Integer.parseInt(tDistance.getString("duration"));
            }
            lLt = route.getString("lt");
            lLn = route.getString("ln");
        }

        return new JSONObject().put("distance", Integer.toString(dist)).put("duration", Integer.toString(duration)).put("routeString", routeString.toString());
    }


    private JSONObject distanceDB(String blt, String bln, String elt, String eln, String blunder, String google_key) throws CacheException {
        JSONObject DBAnswer = new JSONObject(GEO2.DistanceGet(dataBase, blt, bln, elt, eln, blunder));
        // APIServer.consoleLog(this, "distanceDB", "google_key = " + google_key);
        // APIServer.consoleLog(this, "distanceDB", DBAnswer);

        if (DBAnswer.getString("status").equals("calc") && google_key != null && !google_key.equals("")) {
            String urlString = "http://geo.toptaxi.org/distance?blt=" + DBAnswer.getString("blt") + "&bln=" + DBAnswer.getString("bln") + "&elt=" + DBAnswer.getString("elt") + "&eln=" + DBAnswer.getString("eln") + "&key=" + google_key;
            JSONObject respJSON = APIServer.httpGet(urlString);
            // APIServer.consoleLog(this, "distanceDB", urlString);
            // APIServer.consoleLog(this, "distanceDB", respJSON.getJSONObject("result"));
            if (respJSON.getString("status").equals("OK")) {
                JSONObject result = respJSON.getJSONObject("result");
                DBAnswer = new JSONObject(GEO2.DistanceSet(dataBase, blt, bln, elt, eln, AppServer.JSONGetString(result,"distance"), AppServer.JSONGetString(result, "duration"), result.getString("status")));
            }
        }
        return DBAnswer;
    }

}
