
import App.AppServer;
import App.DataBaseResponse;
import User.GEO;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class GEOAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        String[] targets = target.split("/");
        if (targets.length == 0)return new DataBaseResponse("400");
        String DataBaseAnswer = "400^^";


        //System.out.println(target + ";" + baseRequest);

        try {
            switch (targets[1]){
                case "set_android_cache_data":DataBaseAnswer = setAndroidAppCacheData(baseRequest);break;
                case "set_android_location_point":DataBaseAnswer = setAndroidLocationPoint(baseRequest);break;
                case "set_android_house_search":DataBaseAnswer = setAndroidAppHouseSearch(baseRequest);break;
                case "set_google_distance":DataBaseAnswer = setGoogleDistance(baseRequest);break;
                case "get_android_cache_data":
                    DataBaseAnswer = GEO.GetAndroidAppSearch(APIServer.getDatabase(), baseRequest.getParameter("search").trim(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));
                    System.out.println("!!! get_android_cache_data " + DataBaseAnswer);
                    break;
                case "get_android_house_search":DataBaseAnswer = GEO.GetAndroidAppHouseSearch(APIServer.getDatabase(), baseRequest.getParameter("search").trim(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));break;
                case "get_android_location_point":DataBaseAnswer = GEO.GetLocationPoint(APIServer.getDatabase(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));break;
                case "get_distance":DataBaseAnswer = GEO.GetDistance(APIServer.getDatabase(), baseRequest.getParameter("blt"), baseRequest.getParameter("bln"), baseRequest.getParameter("elt"), baseRequest.getParameter("eln"));break;
            }

        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }



    private String setGoogleDistance(HttpServletRequest baseRequest){
        try {
            JSONObject data = new JSONObject(APIServer.getBody(baseRequest));
            GEO.SetDistance(APIServer.getDatabase(), data.getString("blt"), data.getString("bln"), data.getString("elt"), data.getString("eln"), data.getString("dst"));
        } catch (IOException | CacheException e) {
            e.printStackTrace();
        }
        return "200^^";
    }


    private String setAndroidLocationPoint(HttpServletRequest baseRequest) throws CacheException {
        try {
            JSONObject data = new JSONObject(APIServer.getBody(baseRequest));
            JSONObject place = data.getJSONObject("point");
            String ObjectID = GEO.SetObjectsFromGoogle(APIServer.getDatabase(), place.getString("place_id"), place.getString("name"), place.getString("description"), place.getString("latitude"), place.getString("longitude"), place.getString("place_type"), place.getString("place_types"));
            GEO.SetLocationPoint(APIServer.getDatabase(), data.getString("latitude"), data.getString("longitude"), ObjectID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "200^^";
    }

    private String setAndroidAppHouseSearch(HttpServletRequest baseRequest) throws CacheException {
        try {
            String PlacesID = "", PlaceID = "";
            JSONObject data = new JSONObject(APIServer.getBody(baseRequest));
            JSONArray places = data.getJSONArray("places");
            for (int itemID = 0; itemID < places.length(); itemID ++){
                JSONObject place = places.getJSONObject(itemID);
                PlaceID = GEO.SetObjectsFromGoogle(APIServer.getDatabase(), place.getString("place_id"), place.getString("name"), place.getString("description"), place.getString("latitude"), place.getString("longitude"), place.getString("place_type"), place.getString("place_types"));
                PlacesID += PlaceID + "|";
            }
            if (!PlacesID.equals(""))GEO.SetAndroidAppHouseSearch(APIServer.getDatabase(), data.getString("search_string").trim(), data.getString("latitude"), data.getString("longitude"), PlacesID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "200^^";
    }



    private String setAndroidAppCacheData(HttpServletRequest baseRequest) throws CacheException {
        try {
            String PlacesID = "", PlaceID = "";
            JSONObject data = new JSONObject(APIServer.getBody(baseRequest));
            JSONArray places = data.getJSONArray("places");
            for (int itemID = 0; itemID < places.length(); itemID ++){
                JSONObject place = places.getJSONObject(itemID);
                PlaceID = GEO.SetObjectsFromGoogle(APIServer.getDatabase(), place.getString("place_id"), place.getString("name"), place.getString("description"), place.getString("latitude"), place.getString("longitude"), place.getString("place_type"), place.getString("place_types"));
                PlacesID += PlaceID + "|";
            }
            if (!PlacesID.equals(""))GEO.SetAndroidAppSearch(APIServer.getDatabase(), data.getString("search_string").trim(), data.getString("latitude"), data.getString("longitude"), PlacesID);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "200^^";
    }
}
