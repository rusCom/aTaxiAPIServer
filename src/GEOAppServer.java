
import App.AppServer;
import App.DataBaseResponse;
import User.GEO;
import com.intersys.objects.CacheException;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;

class GEOAppServer extends AppServer {
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
                    break;
                case "get_android_house_search":DataBaseAnswer = GEO.GetAndroidAppHouseSearch(APIServer.getDatabase(), baseRequest.getParameter("search").trim(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));break;
                case "get_android_location_point":DataBaseAnswer = GEO.GetLocationPoint(APIServer.getDatabase(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));break;
                case "get_distance":DataBaseAnswer = GEO.GetDistance(APIServer.getDatabase(), baseRequest.getParameter("blt"), baseRequest.getParameter("bln"), baseRequest.getParameter("elt"), baseRequest.getParameter("eln"));break;
                case "geo_autocomplete":DataBaseAnswer = GEO.GEOAutocomplete(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "city"), APIServer.getParameter(baseRequest, "text"));break;
                case "geo_houses":DataBaseAnswer = GEO.GEOHouses(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "street"));break;
                case "distance":
                    switch (targets[2]){
                        case "get":DataBaseAnswer = DistanceGet(baseRequest);break;
                        case "set":DataBaseAnswer = GEO.DistanceSet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"),
                                APIServer.getParameter(baseRequest, "blt"), APIServer.getParameter(baseRequest, "bln"),
                                APIServer.getParameter(baseRequest, "elt"), APIServer.getParameter(baseRequest, "eln"),
                                APIServer.getParameter(baseRequest, "distance"), APIServer.getParameter(baseRequest, "duration")
                            );break;
                    }
                    break;
                case "places":
                    switch (targets[2]){
                        case "autocomplete":DataBaseAnswer = GEO.PlacesAutoComplete(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "city"), APIServer.getParameter(baseRequest, "text"), APIServer.getParameter(baseRequest, "lt"), APIServer.getParameter(baseRequest, "ln"));break;
                        case "houses":DataBaseAnswer = GEO.PlacesHouses(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "street"));break;
                        case "popular":DataBaseAnswer = GEO.PlacesPopular(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "city"));break;
                        case "google":DataBaseAnswer = GooglePlaces(baseRequest);break;
                    }
                    break;
                case "geocode":DataBaseAnswer = Geocode(baseRequest);break;
                case "dispatcher":DataBaseAnswer = DispatcherData(baseRequest);break;
                case "edit":
                    switch (targets[2]){
                        case "airports":DataBaseAnswer = EditAirports(baseRequest);break;

                    }
                    break;

                //case "autocomplete":
            }

        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }


    private String EditAirports(HttpServletRequest baseRequest){
        String DataBaseAnswer = "500^";
        try {
            DataBaseAnswer = GEO.EditAirports(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), "");
        } catch (CacheException e) {
            e.printStackTrace();
        }
        return DataBaseAnswer;
    }


    private String GooglePlaces(HttpServletRequest baseRequest){
        String DataBaseAnswer = "500^";
        String key = APIServer.getParameter(baseRequest, "key");
        String text = APIServer.getParameter(baseRequest, "text");
        String lt = APIServer.getParameter(baseRequest, "lt");
        String ln = APIServer.getParameter(baseRequest, "ln");

        try {
            String resp = GEO.PlacesGoogleGet(APIServer.getDatabase(), key, text, lt, ln);
            //System.out.println(resp);
            if (resp.equals("404")){
                String place_id = "", main_text = "", secondary_text = "", type = "";
                JSONObject prediction, structured_formatting;
                JSONArray types;
                String urlString = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + URLEncoder.encode(text, "UTF-8") + "&location=" + lt + "," + ln + "&radius=500&types=geocode|establishment&language=ru-RU&key=" + APIServer.getGooglePlacesAPIKey();
                System.out.println(urlString);
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setDoOutput(true);
                InputStream inputStream = conn.getInputStream();
                resp = IOUtils.toString(inputStream, "UTF-8");
                JSONObject respJSON = new JSONObject(resp);
                JSONArray result = new JSONArray();
                if (respJSON.has("status")) {
                    if (respJSON.getString("status").equals("OK"))
                        if (respJSON.has("predictions")){
                            JSONArray predictions = respJSON.getJSONArray("predictions");
                            for (int itemID = 0; itemID < predictions.length(); itemID++){
                                prediction = predictions.getJSONObject(itemID);
                                if (prediction.has("place_id"))place_id = prediction.getString("place_id");
                                if (prediction.has("structured_formatting")){
                                    structured_formatting = prediction.getJSONObject("structured_formatting");
                                    if (structured_formatting.has("main_text"))main_text = structured_formatting.getString("main_text");
                                    if (structured_formatting.has("secondary_text"))secondary_text = structured_formatting.getString("secondary_text");
                                }
                                if (prediction.has("types")){
                                    types = prediction.getJSONArray("types");
                                    if (types.length() > 0){
                                        type = types.getString(0);
                                    }
                                }
                                if ((!place_id.equals("")) && (!main_text.equals("")) && (!secondary_text.equals("")) && (!type.equals(""))){
                                    String data = GEO.ObjectsSetGoogle(APIServer.getDatabase(), key, place_id, main_text, secondary_text, "","",type);
                                    if (!data.equals("")){
                                        JSONObject d = new JSONObject(data);
                                        result.put(d);
                                    }
                                }

                            } // for (int itemID = 0; itemID < predictions.length(); itemID++){
                        }

                        GEO.PlacesGoogleSet(APIServer.getDatabase(), key, text, lt, ln, result.toString());
                        //System.out.println("save cash");

                }

                resp = result.toString();
            }

            DataBaseAnswer = "200^"+resp+"^";
        } catch (IOException | CacheException e) {
            e.printStackTrace();
        }


        return DataBaseAnswer;
    }

    private String DispatcherData(HttpServletRequest baseRequest){

        String DataBaseAnswer;
        String lastID = "0";
        ArrayList<JSONArray> resultsArray = new ArrayList<>();
        JSONArray tResults;
        try {
            do {
                String t = GEO.Dispathcer(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "city"), lastID);
                System.out.println(t);
                tResults = new JSONArray(GEO.Dispathcer(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "city"), lastID));
                resultsArray.add(tResults);
                System.out.println(tResults.length());
                if (tResults.length() > 0){
                    JSONObject lastObject = tResults.getJSONObject(tResults.length() - 1);
                    //System.out.println("!!!" + lastObject.toString());
                    lastID = lastObject.getString("uid");
                    System.out.println("!!!" + lastID);
                }

            }while (tResults.length() > 0);
        }catch (CacheException e) {
            e.printStackTrace();
        }

        JSONArray result = getMergeJsonArrays(resultsArray);
        DataBaseAnswer = "200^" + result.toString() + "^";

        return DataBaseAnswer;
    }

    private JSONArray getMergeJsonArrays(ArrayList<JSONArray> jsonArrays) throws JSONException
    {
        JSONArray MergedJsonArrays= new JSONArray();
        for(JSONArray tmpArray:jsonArrays)
        {
            for(int i=0;i<tmpArray.length();i++)
            {
                MergedJsonArrays.put(tmpArray.get(i));
            }
        }
        return MergedJsonArrays;
    }

    private String Geocode(HttpServletRequest baseRequest){
        String DataBaseAnswer = "500^^";
        try {
            DataBaseAnswer = GEO.GeocodeGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "lt"), APIServer.getParameter(baseRequest, "ln"));
            if (DataBaseAnswer.equals("404")){
                YandexGeoCoder(APIServer.getParameter(baseRequest, "lt"), APIServer.getParameter(baseRequest, "ln"));
            }
            DataBaseAnswer = GEO.GeocodeGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "lt"), APIServer.getParameter(baseRequest, "ln"));
            //System.out.println(DataBaseAnswer);
        } catch (CacheException e) {
            e.printStackTrace();
        }
        return DataBaseAnswer;
    }

    private String YandexGeoCoder(String lt, String ln){
        String urlString = "https://geocode-maps.yandex.ru/1.x/?geocode=" + ln + "," + lt + "&format=json";
        //urlString = "http://maps.googleapis.com/maps/api/distancematrix/json?origins=54.75291,15.997114&destinations=54.734062,55.931861";
        //System.out.println(urlString);
        String resultText = "404";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream, "UTF-8");
            JSONObject respJSON = new JSONObject(resp);
            //System.out.println(respJSON);
            JSONArray objects = respJSON.getJSONObject("response").getJSONObject("GeoObjectCollection").getJSONArray("featureMember");
            for (int itemID = 0; itemID < objects.length(); itemID++){
                JSONObject object = objects.getJSONObject(itemID).getJSONObject("GeoObject");
                String Name = object.getString("name");
                String Description = "";
                if (object.has("description")){Description = object.getString("description");}
                String Latitude = object.getJSONObject("Point").getString("pos").split(" ")[1];
                String Longitude = object.getJSONObject("Point").getString("pos").split(" ")[0];
                JSONObject data = object.getJSONObject("metaDataProperty").getJSONObject("GeocoderMetaData");
                String Kind = data.getString("kind");
                String Text = data.getString("text");
                String Data = Name + "|" + Description + "|" + Latitude + "|" + Longitude + "|" + Kind + "|" + Text + "|";
                //System.out.println(Data);
                GEO.SetYandexObject(APIServer.getDatabase(), Data);
                if (itemID == 0){resultText = Text;}

            }
            if (!resultText.equals("")){
                GEO.GeocodeSet(APIServer.getDatabase(), "", lt, ln, resultText);
            }

            //GEO.SetForYandexSearchOper(dataBase, ClassID, resultText);
        } catch (IOException | CacheException e) {
            e.printStackTrace();
        }
        return resultText;
    }

    private String DistanceGet(HttpServletRequest baseRequest){
        if (baseRequest.getMethod().toUpperCase().equals("GET")){
            if (APIServer.getParameter(baseRequest, "blt").equals(" "))return "400^^";
            if (APIServer.getParameter(baseRequest, "bln").equals(" "))return "400^^";
            if (APIServer.getParameter(baseRequest, "elt").equals(" "))return "400^^";
            if (APIServer.getParameter(baseRequest, "eln").equals(" "))return "400^^";
            try {
                Integer Distance = Integer.valueOf(GEO.DistanceGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"), APIServer.getParameter(baseRequest, "blt"), APIServer.getParameter(baseRequest, "bln"), APIServer.getParameter(baseRequest, "elt"), APIServer.getParameter(baseRequest, "eln")));
                if (Distance == -1){
                    Distance = Integer.valueOf(GoogleDistanceMatrix(APIServer.getParameter(baseRequest, "blt"), APIServer.getParameter(baseRequest, "bln"), APIServer.getParameter(baseRequest, "elt"), APIServer.getParameter(baseRequest, "eln")));
                }
                JSONObject answer = new JSONObject();
                answer.put("response", "OK");
                answer.put("distance", Distance);
                answer.put("duration", 1);
                return "200^" + answer.toString() + "^";
            } catch (Exception e) {
                e.printStackTrace();
                return "500^^";
            }
        }
        else if (baseRequest.getMethod().toUpperCase().equals("POST")){
            try {
                Integer distance = 0, tDistance;
                JSONObject data = new JSONObject(APIServer.getBody(baseRequest));

                JSONArray route = data.getJSONArray("route");
                for (int itemID = 1; itemID < route.length(); itemID++){
                    JSONObject l_item = route.getJSONObject(itemID - 1);
                    JSONObject c_item = route.getJSONObject(itemID);
                    tDistance = Integer.valueOf(GEO.DistanceGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "key"),
                            String.valueOf(l_item.get("lt")), String.valueOf(l_item.get("ln")),
                            String.valueOf(c_item.get("lt")), String.valueOf(c_item.get("ln"))
                            ));
                    if (tDistance == -1){
                        tDistance = Integer.valueOf(GoogleDistanceMatrix(
                                String.valueOf(l_item.get("lt")), String.valueOf(l_item.get("ln")),
                                String.valueOf(c_item.get("lt")), String.valueOf(c_item.get("ln"))
                            ));
                    }
                    distance += tDistance;

                }
                JSONObject answer = new JSONObject();
                answer.put("response", "OK");
                answer.put("distance", distance);
                return "200^" + answer.toString() + "^";
            } catch (Exception e) {
                e.printStackTrace();
                return  "500^^";
            }
        }


        return "400^^";
    }

    private String GoogleDistanceMatrix(String blt, String bln, String elt, String eln) throws IOException, CacheException {
        String urlString = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + blt + "," + bln + "&destinations=" + elt + "," + eln + "&key=" + APIServer.getGoogleMatrixAPIKey();

        String distance = "0";
        String duration = "0";


            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream, "UTF-8");
            JSONObject respJSON = new JSONObject(resp);
            //System.out.println(respJSON.toString());
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
            GEO.DistanceSet(APIServer.getDatabase(), "", blt, bln, elt, eln, distance, duration);


        return distance;
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
            String PlacesID = "", PlaceID;
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
            String PlacesID = "", PlaceID;
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
