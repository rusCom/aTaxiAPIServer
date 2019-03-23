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
                    DataBaseAnswer = GEO.GetAndroidAppSearch(getDataBase(), baseRequest.getParameter("search").trim(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));
                    break;
                case "get_android_house_search":DataBaseAnswer = GEO.GetAndroidAppHouseSearch(getDataBase(), baseRequest.getParameter("search").trim(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));break;
                case "get_android_location_point":DataBaseAnswer = GEO.GetLocationPoint(getDataBase(), baseRequest.getParameter("latitude"), baseRequest.getParameter("longitude"));break;
                case "get_distance":DataBaseAnswer = GEO.GetDistance(getDataBase(), baseRequest.getParameter("blt"), baseRequest.getParameter("bln"), baseRequest.getParameter("elt"), baseRequest.getParameter("eln"));break;
                case "geo_autocomplete":DataBaseAnswer = GEO.GEOAutocomplete(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "city"), getParameter(baseRequest, "text"));break;
                case "geo_houses":DataBaseAnswer = GEO.GEOHouses(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "street"));break;
                case "distance":
                    switch (targets[2]){
                        case "get":DataBaseAnswer = DistanceGet(baseRequest);break;
                        case "set":DataBaseAnswer = GEO.DistanceSet(getDataBase(), getParameter(baseRequest, "key"),
                                getParameter(baseRequest, "blt"), getParameter(baseRequest, "bln"),
                                getParameter(baseRequest, "elt"), getParameter(baseRequest, "eln"),
                                getParameter(baseRequest, "distance"), getParameter(baseRequest, "duration")
                            );break;
                    }
                    break;
                case "places":
                    switch (targets[2]){
                        case "autocomplete":DataBaseAnswer = GEO.PlacesAutoComplete(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "city"), getParameter(baseRequest, "text"), getParameter(baseRequest, "lt"), getParameter(baseRequest, "ln"));break;
                        case "houses":DataBaseAnswer = GEO.PlacesHouses(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "street"));break;
                        case "popular":DataBaseAnswer = GEO.PlacesPopular(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "city"));break;
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
            DataBaseAnswer = GEO.EditAirports(getDataBase(), getParameter(baseRequest, "key"), "");
        } catch (CacheException e) {
            e.printStackTrace();
        }
        return DataBaseAnswer;
    }


    private String GooglePlaces(HttpServletRequest baseRequest){
        String DataBaseAnswer = "500^";
        String urlString = "";
        String method = getParameter(baseRequest, "method");
        String key = getParameter(baseRequest, "key");
        String text = getParameter(baseRequest, "text");
        String lt = getParameter(baseRequest, "lt");
        String ln = getParameter(baseRequest, "ln");
        String placeid = getParameter(baseRequest, "placeid");

        if (method.equals("details")) text = placeid;

        if (text.equals(" ")) text = "!";

        try {
            String resp = GEO.PlacesGoogleGet(getDataBase(), key, method, text, lt, ln);
            //System.out.println(resp);
            if (resp.equals("404")){
                System.out.println(method);

                if (method.equals("details")){
                    urlString = "https://maps.googleapis.com/maps/api/place/details/json?key=" + APIServer.getGooglePlacesAPIKey() + "&language=ru-RU&placeid="+placeid;
                }
                if (method.equals("airports")){
                    urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?key=" + APIServer.getGooglePlacesAPIKey() + "&location=" + lt + "," + ln + "&language=ru-RU&type=airport&radius=50000";
                }

                if (method.equals("train_station")){
                    urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?key=" + APIServer.getGooglePlacesAPIKey() + "&location=" + lt + "," + ln + "&language=ru-RU&type=train_station&radius=50000";
                }

                if (method.equals("geocode")){
                    urlString = "https://maps.googleapis.com/maps/api/geocode/json?key=" + APIServer.getGooglePlacesAPIKey() + "&latlng=" + lt + "," + ln + "&language=ru-RU";
                }


                if (method.equals("autocomplete")){
                    urlString = "https://maps.googleapis.com/maps/api/place/autocomplete/json?key=" + APIServer.getGooglePlacesAPIKey() + "&location=" + lt + "," + ln + "&language=ru-RU&radius=50000&input=" + URLEncoder.encode(text, "UTF-8") + "&components=country:ru&strictbounds&types=geocode|establishment";

                }

                if (!urlString.equals("")){
                    System.out.println(urlString);
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setDoOutput(true);
                    InputStream inputStream = conn.getInputStream();
                    resp = IOUtils.toString(inputStream, "UTF-8");
                    GEO.PlacesGoogleSet(getDataBase(), key, method, text, lt, ln, resp);
                    System.out.println("set to database");
                }



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
                String t = GEO.Dispathcer(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "city"), lastID);
                System.out.println(t);
                tResults = new JSONArray(GEO.Dispathcer(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "city"), lastID));
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
            DataBaseAnswer = GEO.GeocodeGet(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "lt"), getParameter(baseRequest, "ln"));
            if (DataBaseAnswer.equals("404")){
                YandexGeoCoder(getParameter(baseRequest, "lt"), getParameter(baseRequest, "ln"));
            }
            DataBaseAnswer = GEO.GeocodeGet(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "lt"), getParameter(baseRequest, "ln"));
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
                GEO.SetYandexObject(getDataBase(), Data);
                if (itemID == 0){resultText = Text;}

            }
            if (!resultText.equals("")){
                GEO.GeocodeSet(getDataBase(), "", lt, ln, resultText);
            }

            //GEO.SetForYandexSearchOper(dataBase, ClassID, resultText);
        } catch (IOException | CacheException e) {
            e.printStackTrace();
        }
        return resultText;
    }

    private String DistanceGet(HttpServletRequest baseRequest){
        if (baseRequest.getMethod().toUpperCase().equals("GET")){
            if (getParameter(baseRequest, "blt").equals(" "))return "400^^";
            if (getParameter(baseRequest, "bln").equals(" "))return "400^^";
            if (getParameter(baseRequest, "elt").equals(" "))return "400^^";
            if (getParameter(baseRequest, "eln").equals(" "))return "400^^";
            try {
                Integer Distance = Integer.valueOf(GEO.DistanceGet(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "blt"), getParameter(baseRequest, "bln"), getParameter(baseRequest, "elt"), getParameter(baseRequest, "eln")));
                if (Distance == -1){
                    Distance = Integer.valueOf(GoogleDistanceMatrix(getParameter(baseRequest, "blt"), getParameter(baseRequest, "bln"), getParameter(baseRequest, "elt"), getParameter(baseRequest, "eln")));
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
                JSONObject data = new JSONObject(getBody(baseRequest));

                JSONArray route = data.getJSONArray("route");
                for (int itemID = 1; itemID < route.length(); itemID++){
                    JSONObject l_item = route.getJSONObject(itemID - 1);
                    JSONObject c_item = route.getJSONObject(itemID);
                    tDistance = Integer.valueOf(GEO.DistanceGet(getDataBase(), getParameter(baseRequest, "key"),
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
            GEO.DistanceSet(getDataBase(), "", blt, bln, elt, eln, distance, duration);


        return distance;
    }





    private String setGoogleDistance(HttpServletRequest baseRequest){
        try {
            JSONObject data = new JSONObject(getBody(baseRequest));
            GEO.SetDistance(getDataBase(), data.getString("blt"), data.getString("bln"), data.getString("elt"), data.getString("eln"), data.getString("dst"));
        } catch (IOException | CacheException e) {
            e.printStackTrace();
        }
        return "200^^";
    }


    private String setAndroidLocationPoint(HttpServletRequest baseRequest) throws CacheException {
        try {
            JSONObject data = new JSONObject(getBody(baseRequest));
            JSONObject place = data.getJSONObject("point");
            String ObjectID = GEO.SetObjectsFromGoogle(getDataBase(), place.getString("place_id"), place.getString("name"), place.getString("description"), place.getString("latitude"), place.getString("longitude"), place.getString("place_type"), place.getString("place_types"));
            GEO.SetLocationPoint(getDataBase(), data.getString("latitude"), data.getString("longitude"), ObjectID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "200^^";
    }

    private String setAndroidAppHouseSearch(HttpServletRequest baseRequest) throws CacheException {
        try {
            String PlacesID = "", PlaceID;
            JSONObject data = new JSONObject(getBody(baseRequest));
            JSONArray places = data.getJSONArray("places");
            for (int itemID = 0; itemID < places.length(); itemID ++){
                JSONObject place = places.getJSONObject(itemID);
                PlaceID = GEO.SetObjectsFromGoogle(getDataBase(), place.getString("place_id"), place.getString("name"), place.getString("description"), place.getString("latitude"), place.getString("longitude"), place.getString("place_type"), place.getString("place_types"));
                PlacesID += PlaceID + "|";
            }
            if (!PlacesID.equals(""))GEO.SetAndroidAppHouseSearch(getDataBase(), data.getString("search_string").trim(), data.getString("latitude"), data.getString("longitude"), PlacesID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "200^^";
    }



    private String setAndroidAppCacheData(HttpServletRequest baseRequest) throws CacheException {
        try {
            String PlacesID = "", PlaceID;
            JSONObject data = new JSONObject(getBody(baseRequest));
            JSONArray places = data.getJSONArray("places");
            for (int itemID = 0; itemID < places.length(); itemID ++){
                JSONObject place = places.getJSONObject(itemID);
                PlaceID = GEO.SetObjectsFromGoogle(getDataBase(), place.getString("place_id"), place.getString("name"), place.getString("description"), place.getString("latitude"), place.getString("longitude"), place.getString("place_type"), place.getString("place_types"));
                PlacesID += PlaceID + "|";
            }
            if (!PlacesID.equals(""))GEO.SetAndroidAppSearch(getDataBase(), data.getString("search_string").trim(), data.getString("latitude"), data.getString("longitude"), PlacesID);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "200^^";
    }
}
