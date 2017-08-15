package App;

import com.intersys.objects.Database;

import javax.servlet.http.HttpServletRequest;

public class AppServer {
    private Database dataBase;

    public DataBaseResponse response(String target, HttpServletRequest baseRequest){
        return new DataBaseResponse("500");
    }

    public void setDataBase(Database dataBase) {
        dataBase = dataBase;
    }

    public Database getDataBase() {
        return dataBase;
    }
}
