import API.MainAPI;
import com.intersys.objects.CacheException;

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

    private String OpersCalc(String calcString) throws UnsupportedEncodingException {
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
                // System.out.println(urlString);
                APIServer.httpGet(urlString);
            }

        }




        return "200^^";
    }
}
