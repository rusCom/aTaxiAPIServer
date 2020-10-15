import API.TaximeterRegistration;

import javax.servlet.http.HttpServletRequest;

import com.intersys.objects.CacheException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class TaximeterRegistrationAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) throws Exception {
        super.response(target, baseRequest);
        JSONObject auth = new JSONObject(TaximeterRegistration.Auth(dataBase, param("key"), param("token"), param("promo"), param("lt"), param("ln")));
        for (String key : JSONObject.getNames(auth)) {
            authorization.put(key, String.valueOf(auth.get(key)));
        }
        String dataBaseAnswer = "403";

        if (!param("organizationID").equals("0")) {
            switch (target) {
                case "/preferences":
                    dataBaseAnswer = TaximeterRegistration.Preferences(dataBase, param("organizationID"));
                    break;
                case "/profile":
                    if (baseRequest.getMethod().toUpperCase().equals("POST")) {
                        ProfilePOST();
                    }
                    dataBaseAnswer = TaximeterRegistration.ProfileGet103(dataBase, param("driverID"));
                    break;
                case "/profile/login":
                    dataBaseAnswer = TaximeterRegistration.ProfileLogin103(dataBase, param("phone"), param("userID"), param("friendID"));
                    break;
                case "/profile/registration":
                    dataBaseAnswer = TaximeterRegistration.ProfileRegistration103(dataBase, param("phone"), param("code"));
                    break;
                case "/profile/document":
                    dataBaseAnswer = ProfileDocument(baseRequest);
                    break;
                case "/profile/check":
                    dataBaseAnswer = ProfileCheck(baseRequest);
                    break;
                case "/send_order":
                    dataBaseAnswer = TaximeterRegistration.SendOrder(dataBase, param("token"));
                    break;
                default:
                    dataBaseAnswer = "404";
                    break;
            }
        }

        response.setResponse(dataBaseAnswer);
        return response;
    }

    private String ProfileCheck(HttpServletRequest baseRequest) throws CacheException {
        String checkData = "";
        checkData += bodyField("passport_number", "_") + "|";            // 1
        checkData += bodyField("driver_license_number", "_") + "|";      // 2
        checkData += bodyField("gov_number", "_") + "|";                 // 3

        return TaximeterRegistration.ProfileCheck(dataBase, param("driverID"), checkData);
    }

    private void ProfilePOST() throws CacheException {
        String setData = "";

        setData += bodyField("fio") + "|";                              // 1
        setData += bodyField("passport_number") + "|";                  // 2
        setData += bodyField("driver_license_number") + "|";            // 3
        setData += bodyField("car") + "|";                              // 4
        setData += bodyField("color") + "|";                            // 5
        setData += bodyField("gov_number") + "|";                       // 6
        setData += bodyField("car_year") + "|";                         // 7

        TaximeterRegistration.ProfileSet103(dataBase, param("driverID"), setData);

    }

    private String ProfileDocument(HttpServletRequest baseRequest) throws Exception {
        String DataBaseAnswer = TaximeterRegistration.ProfelDocumentGet(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "type"));
        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers[0].equals("200")) {
            switch (baseRequest.getMethod().toUpperCase()) {
                case "GET":
                    if (DataBaseAnswers.length == 1) {
                        DataBaseAnswer = "404";
                    } else {
                        DataBaseAnswer = "200^^" + getAppSettings().getString("file_path") + DataBaseAnswers[1];
                    }
                    break;
                case "POST":
                    DataBaseAnswer = "400^Not find file in body^";
                    if (ServletFileUpload.isMultipartContent(baseRequest)) {
                        List<FileItem> fileItemsList = getUploader().parseRequest(baseRequest);
                        for (FileItem fileItem : fileItemsList) {
                            if (!fileItem.isFormField()) {
                                if (fileItem.getContentType().split("/")[0].equals("image")) {
                                    String FileName;
                                    if (DataBaseAnswers.length > 1) {
                                        FileName = FilenameUtils.getBaseName(DataBaseAnswers[1]);
                                    } else {
                                        FileName = UUID.randomUUID().toString();
                                    }
                                    FileName += getFileExtension(fileItem.getName());
                                    File file = new File(getAppSettings().getString("file_path") + FileName);
                                    fileItem.write(file);
                                    TaximeterRegistration.ProfelDocumentSet(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "type"), FileName);
                                    DataBaseAnswer = "200^";

                                } else {
                                    DataBaseAnswer = "400^Sending file not image^";
                                }

                            } // if (!fileItem.isFormField()){
                        } // while(fileItemsIterator.hasNext()){

                    } // if (ServletFileUpload.isMultipartContent(baseRequest)){
                    else {
                        DataBaseAnswer = "400^Content type is not multipart/form-data^";
                    }

                    break;
                default:
                    DataBaseAnswer = "400^";
                    break;
            }


        }

        return DataBaseAnswer;
    }

    private String getFileExtension(String mystr) {
        int index = mystr.lastIndexOf('.');
        return index == -1 ? null : mystr.substring(index);
    }

}
