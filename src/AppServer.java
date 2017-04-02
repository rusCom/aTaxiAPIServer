import com.intersys.objects.Database;

import javax.servlet.http.HttpServletRequest;

class AppServer {
    private Database dataBase;

    public DataBaseResponse response(String target, HttpServletRequest baseRequest){
        return new DataBaseResponse("500");
    }

    void setDataBase(Database dataBase) {
        dataBase = dataBase;
    }

    public Database getDataBase() {
        return dataBase;
    }
}
