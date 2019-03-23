import API.TaximeterRegistration;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.util.List;
import java.util.UUID;

public class TaximeterRegistrationAppServer extends AppServer {


    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        List<String> targets = getTargets(target);
        String DataBaseAnswer = "400^^";

        try {
            switch (targets.get(1)){
                case "profile":
                    switch (targets.get(2)){
                        case "login":DataBaseAnswer = TaximeterRegistration.ProfileLogin(getDataBase(), getParameter(baseRequest, "key"), getParameter(baseRequest, "phone"));break;
                        case "document":DataBaseAnswer = ProfileDocument(baseRequest);break;
                    }
                    break; // case "profile"
                case "send_order":DataBaseAnswer = TaximeterRegistration.SendOrder(getDataBase(), getParameter(baseRequest, "token"));break;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            DataBaseAnswer = "500^^";
        }

        return new DataBaseResponse(DataBaseAnswer);
    }

    private String ProfileDocument(HttpServletRequest baseRequest) throws Exception {
        String DataBaseAnswer = TaximeterRegistration.ProfelDocumentGet(getDataBase(), getParameter(baseRequest, "token"), getParameter(baseRequest, "type"));
        String[] DataBaseAnswers = DataBaseAnswer.split("\\^");
        if (DataBaseAnswers[0].equals("200")){
            switch (baseRequest.getMethod().toUpperCase()) {
                case "GET":
                    //System.out.println("!!!!" + getFileExtension("DriverLicense.Reverse5869945910499383318.jpg"));
                    //System.out.println("!!!!" + getFileExtension("DriverLicensee5869945910499383318.jpg"));
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
        return index == -1? null : mystr.substring(index);
    }

}
