import API.GEO2;
import API.MainAPI;
import com.intersys.objects.CacheException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class MainAPIAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        String DataBaseAnswer = "404";

        switch (target){
            case "/asterisk/incoming_call":
                    DataBaseAnswer = MainAPI.AsteriskIncomingCall(getDataBase(), getParameter(baseRequest, "uid"), getParameter(baseRequest, "trunk"), getParameter(baseRequest, "phone"));
                break;
            case "/asterisk/action":DataBaseAnswer= MainAPI.AsteriskAction(getDataBase(), getParameter(baseRequest, "action"), getParameter(baseRequest, "uid"), getParameter(baseRequest, "trunk"), getParameter(baseRequest, "phone"), getParameter(baseRequest, "param"));
                break;
            case "/driver/covidreference":DataBaseAnswer = MainAPI.DriverCovidReference(getDataBase(), getParameter(baseRequest, "token"));
                break;
            case "/opers/calc":DataBaseAnswer = OpersCalc(param("calc"));break;
        }
        return new DataBaseResponse(DataBaseAnswer);
    }

    private String OpersCalc(String calcString) throws UnsupportedEncodingException, CacheException {
        String[] calcData = calcString.split("\\|");
        String[] actions;
        // System.out.println(calcData);
        // System.out.println(calcData[6]);
        // System.out.println(calcData.length);
        int actionsCount = calcData.length - 6;
        // System.out.println(actionsCount);

        for (int itemID = 6; itemID < calcData.length; itemID = itemID + 5){
            // System.out.println(calcData[itemID]);
            // System.out.println(calcData[itemID + 2]);
            if (calcData[itemID].equals("1") || calcData[itemID].equals("28")){
                String str = calcData[itemID + 2].split(" - ")[0];
                String urlString = "http://geo.toptaxi.org/geocode?lt=54.765375&ln=56.047584&name=" + URLEncoder.encode(str, "UTF-8");
                JSONObject response = APIServer.httpGet(urlString);
                if (response.has("status")){
                    if (response.getString("status").equals("OK")){
                        JSONObject result = response.getJSONObject("result");
                        String data = result.getString("name") + "|";
                        data += result.getString("dsc") + "|";
                        data += result.getString("lt") + "|";
                        data += result.getString("ln") + "|";
                        GEO2.SetGeoCode(dataBase, str, result.getString("place_id"), data);
                    }
                }

                if (str.contains("БОРИСОГЛЕБСКОГО")){
                    str = str.replace("БОРИСОГЛЕБСКОГО", "БОРИСОГЛЕБСКАЯ");
                    urlString = "http://geo.toptaxi.org/geocode?lt=54.765375&ln=56.047584&name=" + URLEncoder.encode(str, "UTF-8");
                    APIServer.httpGet(urlString);
                }
                if (str.contains("(ФРУНЗЕ)")){
                    str = str.replace(" (ФРУНЗЕ)", "");
                    urlString = "http://geo.toptaxi.org/geocode?lt=54.765375&ln=56.047584&name=" + URLEncoder.encode(str, "UTF-8");
                    APIServer.httpGet(urlString);
                }
            }

        }
        return "200^^";
    }


}
