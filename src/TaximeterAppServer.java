import API.Taximeter;
import com.intersys.objects.CacheException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class TaximeterAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        String[] targets = target.split("/");
        if (targets.length == 0)return new DataBaseResponse("400");
        String DataBaseAnswer = "400^^";

        try {

           if (target.split("=")[0].equals("/gettype")){
                Map<String, String> params = parseParams(baseRequest.getRequestURI());
                DataBaseAnswer = Taximeter.DataType(getDataBase(), params.get("token"), params.get("type"), params.get("data"));
            }
            else if (target.split("=")[0].equals("/get")){
                Map<String, String> params = parseParams(baseRequest.getRequestURI());
                DataBaseAnswer = Taximeter.Data(getDataBase(), params.get("token"), params.get("location"));
            }

            switch (targets[1]){
                case "orders":{
                    switch (targets[2]){
                        case "check":DataBaseAnswer = Taximeter.OrdersCheck(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "order_id"));break;
                    }
                }break;

            }

        } catch (CacheException e) {
            e.printStackTrace();
            DataBaseAnswer = "500^^";
        }


        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers.length == 1)return new DataBaseResponse(DataBaseAnswers[0]);
        else return new DataBaseResponse(DataBaseAnswers[0], DataBaseAnswers[1]);
    }

    // Парсит параметры команды
    Map<String, String> parseParams(String URI){
        Map<String, String> result = new HashMap<String, String>();
        String[] s = URI.split("\\&");
        for (int i=1; i<s.length; i++){
            //System.out.println(s[i]);
            String value = "";
            if (s[i].split("=").length > 1){
                value = s[i].split("=")[1];
            }
            result.put(s[i].split("=")[0], value);

        }

        return result;
    }
}
