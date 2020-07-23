import API.Booking;
import API.Exchange;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

public class ExchangeAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        JSONObject auth = new JSONObject(Exchange.Auth(dataBase, param("partner"), param("dispatching")));
        for (String key : JSONObject.getNames(auth)) {
            authorization.put(key, String.valueOf(auth.get(key)));
        }
        String dataBaseAnswer = "403";

        System.out.println("@" + param("order") + "@");

        if (!param("organizationID").equals("0")){
            switch (target){
                case "/orders":dataBaseAnswer = Exchange.Orders(dataBase, param("organizationID"),  param("dispatchingID"), param("order", " "));break;
                default:
                    if (!param("dispatchingID").equals("0")){
                        switch (target){
                            default:
                                dataBaseAnswer = "404";
                                break;
                        }
                    }
                    break;
            }
        }

        response.setResponse(dataBaseAnswer);
        return response;
    }
}
