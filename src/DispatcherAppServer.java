import API.Dispatcher;
import App.AppServer;
import App.DataBaseResponse;
import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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
                case "order":DataBaseAnswer = Dispatcher.OrderGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), APIServer.getParameter(baseRequest, "id"), APIServer.getParameter(baseRequest, "phone"));break;
                case "drivers":DataBaseAnswer = Dispatcher.DriversGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), APIServer.getParameter(baseRequest, "city"));break;

                case "data":DataBaseAnswer = data(baseRequest);break;
                case "client":
                    switch (targets[2]){
                        case "card":
                            DataBaseAnswer = Dispatcher.ClientCardGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), APIServer.getParameter(baseRequest,"card"));break;
                        default:
                            DataBaseAnswer = Dispatcher.ClientGet(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), APIServer.getParameter(baseRequest,"card"), APIServer.getParameter(baseRequest, "phone"));
                            break;

                    }
                    break;


            }

        }catch (Exception e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }

    private  String data(HttpServletRequest baseRequest) throws CacheException {
        JSONObject data = new JSONObject();
        ArrayList<JSONArray> resultsArray = new ArrayList<>();
        JSONArray tResults;
        String lastID = "0";
        try {
            do {
                tResults = new JSONArray(Dispatcher.DataCurOrders(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), lastID));
                resultsArray.add(tResults);
                if (tResults.length() > 0){
                    JSONObject lastObject = tResults.getJSONObject(tResults.length() - 1);
                    lastID = lastObject.getString("ID");
                }
            }while (tResults.length() > 0);
        }catch (CacheException e) {
            e.printStackTrace();
        }
        JSONArray curOrders = APIServer.getMergeJsonArrays(resultsArray);


        resultsArray.clear();
        lastID = "0";
        try {
            do {
                tResults = new JSONArray(Dispatcher.DataDoneOrders(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), lastID));
                resultsArray.add(tResults);
                if (tResults.length() > 0){
                    JSONObject lastObject = tResults.getJSONObject(tResults.length() - 1);
                    lastID = lastObject.getString("ID");
                }
            }while (tResults.length() > 0);
        }catch (CacheException e) {
            e.printStackTrace();
        }
        JSONArray doneOrders = APIServer.getMergeJsonArrays(resultsArray);

        resultsArray.clear();
        lastID = "0";
        try {
            do {
                tResults = new JSONArray(Dispatcher.DataPriorOrders(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), lastID));
                resultsArray.add(tResults);
                if (tResults.length() > 0){
                    JSONObject lastObject = tResults.getJSONObject(tResults.length() - 1);
                    lastID = lastObject.getString("ID");
                }
            }while (tResults.length() > 0);
        }catch (CacheException e) {
            e.printStackTrace();
        }
        JSONArray priorOrders = APIServer.getMergeJsonArrays(resultsArray);

        resultsArray.clear();
        lastID = "0";
        try {
            do {
                tResults = new JSONArray(Dispatcher.DataDrivers(APIServer.getDatabase(), APIServer.getParameter(baseRequest, "token"), lastID));
                resultsArray.add(tResults);
                if (tResults.length() > 0){
                    JSONObject lastObject = tResults.getJSONObject(tResults.length() - 1);
                    lastID = lastObject.getString("ID");
                }
            }while (tResults.length() > 0);
        }catch (CacheException e) {
            e.printStackTrace();
        }
        JSONArray drivers = APIServer.getMergeJsonArrays(resultsArray);


        data.put("cur_orders", curOrders);
        data.put("done_orders", doneOrders);
        data.put("prior_orders", priorOrders);
        data.put("drivers", drivers);

        return "200^" + data.toString() + "^";
    }
}