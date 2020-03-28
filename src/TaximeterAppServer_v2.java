import API.Taximeter2;
import com.intersys.objects.CacheException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.json.JSONObject;

import java.util.Timer;

import static org.apache.commons.codec.binary.Base64.decodeBase64;

public class TaximeterAppServer_v2 extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws CacheException {
        JSONObject auth;
        try{
            String authorization = baseRequest.getHeader("authorization").split(" ")[1];
            // System.out.println(authorization);
            byte[] result = decodeBase64(authorization);
            auth = new JSONObject(new String(result));
        }
        catch (Exception e){
            auth = new JSONObject();
            auth.put("token", getParameter(baseRequest, "token"));
        }

        System.out.println(auth);

        if (!auth.getString("token").equals("")){
            String lt = "", ln = "", device = "", device_id = "";
            if (auth.has("lt")){
                if (auth.get("lt") instanceof String){
                    lt = auth.getString("lt");
                }
                else if (auth.get("lt") instanceof Double){
                    lt = String.valueOf(auth.getDouble("lt"));
                }
            }
            if (auth.has("ln")){
                if (auth.get("ln") instanceof String){
                    ln = auth.getString("ln");
                }
                else if (auth.get("ln") instanceof Double){
                    ln = String.valueOf(auth.getDouble("ln"));
                }
            }
            if (auth.has("device_id"))device_id = auth.getString("device_id");

            Taximeter2.SetData(getDataBase(), auth.getString("token"), lt, ln, device_id);
        }






        String DataBaseAnswer = "404^^";
        switch (target){
            case "/profile/auth":DataBaseAnswer = Taximeter2.ProfileAuth(getDataBase(), auth.getString("token"), auth.getString("version"));break;
            case "/profile/login":DataBaseAnswer = Taximeter2.ProfileLogin(getDataBase(), getParameter(baseRequest, "phone"));break;
            case "/profile/registration":DataBaseAnswer = Taximeter2.ProfileRegistration(getDataBase(), getParameter(baseRequest, "phone"), getParameter(baseRequest, "code"));break;
            case "/profile/preferences":DataBaseAnswer = Taximeter2.ProfilePreferences(getDataBase(), auth.getString("token"));break;
            case "/profile/push":DataBaseAnswer = Taximeter2.ProfilePush(getDataBase(), auth.getString("token"), getParameter(baseRequest, "push_token"));break;
            case "/profile/free":DataBaseAnswer = Taximeter2.ProfileFree(getDataBase(), auth.getString("token"));break;
            case "/profile/busy":DataBaseAnswer = Taximeter2.ProfileBusy(getDataBase(), auth.getString("token"));break;
            case "/data":DataBaseAnswer = Taximeter2.Data(getDataBase(), auth.getString("token"));break;


        }
        /*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }


}
