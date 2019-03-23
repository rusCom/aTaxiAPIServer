import com.intersys.objects.CacheException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class GEO2AppServer extends AppServer {

    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws CacheException, IOException {
        List<String> targets = getTargets(target);

        String DataBaseAnswer = "400^^";
        switch (targets.get(1)){
            case "distance":
                DataBaseAnswer = Distance(baseRequest);break;
        }
        return new DataBaseResponse(DataBaseAnswer);
    }

    private String Distance(HttpServletRequest baseRequest) throws CacheException, IOException {
        if (baseRequest.getMethod().toUpperCase().equals("GET")){
            if (getParameter(baseRequest, "blt").equals(" "))return "400^^";
            if (getParameter(baseRequest, "bln").equals(" "))return "400^^";
            if (getParameter(baseRequest, "elt").equals(" "))return "400^^";
            if (getParameter(baseRequest, "eln").equals(" "))return "400^^";
            return "200^"+getDistance().DistanceGet(getParameter(baseRequest, "blt"),
                    getParameter(baseRequest, "bln"),
                    getParameter(baseRequest, "elt"),
                    getParameter(baseRequest, "eln")
                    ).toString();

        }
        else if (baseRequest.getMethod().toUpperCase().equals("POST")){
            JSONObject data = new JSONObject(getBody(baseRequest));
            JSONArray route = data.getJSONArray("route");
            return "200^"+getDistance().DistanceGet(route);
        }
        return "400^^";
    }

}
