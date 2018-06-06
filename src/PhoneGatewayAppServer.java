import API.PhoneGatway;
import App.AppServer;
import App.DataBaseResponse;
import com.intersys.objects.CacheException;

import javax.servlet.http.HttpServletRequest;

public class PhoneGatewayAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        String[] targets = target.split("/");
        if (targets.length == 0)return new DataBaseResponse("400");
        String DataBaseAnswer = "400^^";

        try {
            switch (targets[1]){
                case "data":DataBaseAnswer = PhoneGatway.GetMessages(APIServer.getDatabase(), baseRequest.getParameter("trunk"));break;
                case "set_sending":DataBaseAnswer = PhoneGatway.SetSending(APIServer.getDatabase(), targets[2]);break;
                case "set_sended":DataBaseAnswer = PhoneGatway.SetSended(APIServer.getDatabase(), targets[2]);break;
                case "set_delivered":DataBaseAnswer = PhoneGatway.SetDelivered(APIServer.getDatabase(), targets[2]);break;
                case "incoming_call":DataBaseAnswer = PhoneGatway.IncomingCall(APIServer.getDatabase(), baseRequest.getParameter("phone"));break;
                case "incoming_sms":DataBaseAnswer = PhoneGatway.IncomingSMS(APIServer.getDatabase(), baseRequest.getParameter("phone"), baseRequest.getParameter("text"));break;
                case "adwords_compaign":DataBaseAnswer = PhoneGatway.AdwordsCompaign(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "customer_id"), APIServer.getParameter(baseRequest, "city_id"));break;

            }
        }catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }



        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }

}
