import API.MainAPI;
import com.intersys.objects.CacheException;

import javax.servlet.http.HttpServletRequest;


public class MainAPIAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws CacheException {
        String DataBaseAnswer = "404";

        switch (target){
            case "/asterisk/incoming_call":
                    DataBaseAnswer = MainAPI.AsteriskIncomingCall(getDataBase(), getParameter(baseRequest, "uid"), getParameter(baseRequest, "trunk"), getParameter(baseRequest, "phone"));
                break;
            case "/asterisk/action":DataBaseAnswer= MainAPI.AsteriskAction(getDataBase(), getParameter(baseRequest, "action"), getParameter(baseRequest, "uid"), getParameter(baseRequest, "trunk"), getParameter(baseRequest, "phone"), getParameter(baseRequest, "param"));
                break;
            case "/driver/covidreference":DataBaseAnswer = MainAPI.DriverCovidReference(getDataBase(), getParameter(baseRequest, "token"));
                break;
        }
        return new DataBaseResponse(DataBaseAnswer);
    }
}
