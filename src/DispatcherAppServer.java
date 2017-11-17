import API.Dispatcher;
import App.AppServer;
import App.DataBaseResponse;

import javax.servlet.http.HttpServletRequest;

public class DispatcherAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        String[] targets = target.split("/");
        if (targets.length == 0)return new DataBaseResponse("400");
        String DataBaseAnswer = "400^";

        try {
            switch (targets[1]){
                case "profile":
                    switch (targets[2]){
                        case "login":DataBaseAnswer = Dispatcher.ProfileLogin(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "phone"), APIServer.getParameter(baseRequest, "psw"));break;

                    }
                    break;
                case "preferences":DataBaseAnswer = Dispatcher.PreferensesGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"));break;
                case "orders":DataBaseAnswer = Dispatcher.OrdersGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), APIServer.getParameter(baseRequest, "city"));break;
                case "order":DataBaseAnswer = Dispatcher.OrderGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), APIServer.getParameter(baseRequest, "uid"));break;
                case "drivers":DataBaseAnswer = Dispatcher.DriversGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), APIServer.getParameter(baseRequest, "city"));break;

            }

        }catch (Exception e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }
}
