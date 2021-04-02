import API.Taxsee;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

public class TaxseeAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        JSONObject auth = new JSONObject(Taxsee.Auth(dataBase, param("X-API-KEY")));
        for (String key : JSONObject.getNames(auth)) {
            authorization.put(key, String.valueOf(auth.get(key)));
        }
        String dataBaseAnswer = "403";

        if (!param("dispatchingID").equals("0")){

            if (target.substring(0, 5).equals("/dev/")){
                paramSet("test", "1");
                target = target.substring(4);
            }
            else {paramSet("test", "0");}



            System.out.println(target);
        }
        response.setResponse(dataBaseAnswer);
        return response;
    }
}
