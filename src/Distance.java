import API.GEO;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Distance {
    private String googleMatrixAPIKey;
    private Database dataBase;

    Distance(String googleMatrixAPIKey, Database dataBase) {
        this.googleMatrixAPIKey = googleMatrixAPIKey;
        this.dataBase = dataBase;
    }

    public JSONObject DistanceGet(String blt, String bln, String elt, String eln) throws CacheException, IOException {
        JSONObject DBAnswer = new JSONObject(GEO.DistanceGet(dataBase, "", blt, bln, elt, eln));

        if (DBAnswer.has("result"))
            if (DBAnswer.getString("result").equals("not found"))
                DistanceGetGoogleMatrix(blt+","+bln, elt + ","+eln);
        DBAnswer = new JSONObject(GEO.DistanceGet(dataBase, "",blt, bln, elt, eln));
        return DBAnswer;

    }

    public JSONObject DistanceGet(JSONArray routes) throws CacheException, IOException {
        JSONObject tDistance;
        Integer distance = 0, duration = 0;

        String lLt = "", lLn = "";
        for (int itemID = 0; itemID < routes.length(); itemID++){
            JSONObject route = routes.getJSONObject(itemID);
            if (itemID > 0){
                tDistance = DistanceGet(lLt, lLn, route.getString("lt"), route.getString("ln"));
                distance += tDistance.getInt("distance");
                duration += tDistance.getInt("duration");

            }
            lLt = route.getString("lt");
            lLn = route.getString("ln");
        }
        JSONObject result = new JSONObject();
        result.put("distance", distance);
        result.put("duration", duration);

        return result;
    }


    private void DistanceGetGoogleMatrix(String origin, String destination) throws IOException, CacheException {
        String urlString = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination + "&key=" + googleMatrixAPIKey;

        String distance = "0";
        String duration = "0";


        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        InputStream inputStream = conn.getInputStream();
        String resp = IOUtils.toString(inputStream, "UTF-8");
        JSONObject respJSON = new JSONObject(resp);
        System.out.println(respJSON.toString());
        if (respJSON.has("status"))
            if (respJSON.getString("status").equals("OK")){
                if (respJSON.has("rows")){
                    JSONObject row = respJSON.getJSONArray("rows").getJSONObject(0);
                    if (row.has("elements")){
                        JSONObject elements = row.getJSONArray("elements").getJSONObject(0);
                        if (elements.has("status"))
                            if (elements.getString("status").equals("OK")){
                                //System.out.println(elements.toString());
                                distance = String.valueOf(elements.getJSONObject("distance").get("value"));
                                duration = String.valueOf(elements.getJSONObject("duration").get("value"));

                                //distance = elements.getJSONObject("distance");
                            } // if (elements.getString("status").equals("OK")){


                    } // if (row.has("elements")){
                } //if (respJSON.has("rows")){
            } //if (respJSON.getString("status").equals("OK")){
        //GEO.SetDistance(dataBase, search[1], search[2], search[3], search[4], distance);
        GEO.DistanceSet(dataBase,
                "",
                origin.split(",")[0],
                origin.split(",")[1],
                destination.split(",")[0],
                destination.split(",")[1],
                distance,
                duration);
    }
}
