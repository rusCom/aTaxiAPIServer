import API.CKassa;
import com.intersys.objects.CacheException;
import org.apache.commons.codec.digest.DigestUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URLDecoder;

class CKassaAppServer extends AppServer {
    @Override
    public DataBaseResponse response(String target, HttpServletRequest baseRequest) {
        Document responseDocument = null;
        String signCode;
        String[] targets = target.split("/");
        //if (targets.length == 0)return new DataBaseResponse("400");
        if (targets.length > 0)
        {
            // ООО Сервис
            if (targets[1].equals("oooservice")){
                try {
                    return new DataBaseResponse("200",
                            CKassa.OOOService(
                                    getDataBase(),
                                    getParameter(baseRequest, "command"),
                                    getParameter(baseRequest, "txn_id"),
                                    getParameter(baseRequest, "account"),
                                    getParameter(baseRequest, "sum"),
                                    getParameter(baseRequest, "account1"),
                                    getParameter(baseRequest, "account2")
                            ));
                } catch (CacheException e) {
                    e.printStackTrace();
                }
            }

        }


        try {

            if (checkAddress(baseRequest.getRemoteAddr())){
                String Body = URLDecoder.decode(getBody(baseRequest).split("params=")[1], "UTF-8");
                //System.out.println("!!!Body = " + Body);
                if (Body.equals(""))return new DataBaseResponse("200");
                //getParamsString(Body);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new ByteArrayInputStream(Body.getBytes("utf-8")));
                Element requestElement = document.getDocumentElement();
                signCode = getElementValue(requestElement, "sign"); //requestElement.getElementsByTagName("sign").item(0).getTextContent();
                Element paramsElement = (Element)requestElement.getElementsByTagName("params").item(0);
                if (CheckSign(signCode, Body)){

                    String act = paramsElement.getElementsByTagName("act").item(0).getTextContent();
                    switch (act) {
                        case "1": {
                            String[] dataBaseResponse = CKassa.CheckPayment(getDataBase(),
                                    String.valueOf(APIServer.getPort()),
                                    getElementValue(paramsElement, "account"),
                                    getElementValue(paramsElement, "pay_amount"),
                                    getElementValue(paramsElement, "agent_code"),
                                    getElementValue(paramsElement, "serv_code"),
                                    getElementValue(paramsElement, "agent_date")).split("\\^");
                            responseDocument = responseDocument(signCode, dataBaseResponse);
                            break;
                        }
                        case "2": {
                            String[] dataBaseResponse = CKassa.SetPayment(getDataBase(),
                                    String.valueOf(APIServer.getPort()),
                                    getElementValue(paramsElement, "account"),
                                    getElementValue(paramsElement, "pay_amount"),
                                    getElementValue(paramsElement, "pay_id"),
                                    getElementValue(paramsElement, "pay_date"),
                                    getElementValue(paramsElement, "pay_type"),
                                    getElementValue(paramsElement, "agent_code"),
                                    getElementValue(paramsElement, "serv_code"),
                                    getElementValue(paramsElement, "agent_date")
                            ).split("\\^");
                            responseDocument = responseDocument(signCode, dataBaseResponse);
                            break;
                        }
                        case "4":
                            String[] dataBaseResponse = CKassa.GetPayment(getDataBase(),
                                    String.valueOf(APIServer.getPort()),
                                    getElementValue(paramsElement, "pay_id")
                            ).split("\\^");
                            responseDocument = responseDocument(signCode, dataBaseResponse);
                            break;
                        default:
                            System.out.println("act = " + act);
                            break;
                    }

                }
                else {
                    responseDocument = responseDocument(signCode, "13", "Неверная цифровая подпись");
                }
            }
            else {
                return new DataBaseResponse("403");
            }

            if (responseDocument != null){
                DOMSource domSource = new DOMSource(responseDocument);
                StringWriter writer = new StringWriter();
                StreamResult result = new StreamResult(writer);
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                transformer.transform(domSource, result);
                return new DataBaseResponse("200", writer.toString());
            }

        } catch (CacheException | ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
            return new DataBaseResponse("500");
        }

        return new DataBaseResponse("500");
    }

    private Boolean checkAddress(String address) throws CacheException {
        String[] remoteAddresses = CKassa.GetRemoteAddresses(getDataBase(), String.valueOf(APIServer.getPort())).split("\\^");
        for (String remoteAddress : remoteAddresses)
            if (remoteAddress.equals(address))
                return true;
        return false;
    }

    private String getElementValue(Element element, String elementName){
        String result = "";
        NodeList nodeList = element.getElementsByTagName(elementName);
        if (nodeList != null){
            Node node = nodeList.item(0);
            if (node != null){
                result = node.getTextContent();
            }
        }


        return result;
    }

    private Document responseDocument(String sign, String[] params) throws ParserConfigurationException, CacheException {
        String result = "", resultText = "", clientName = "", account = "", regID = "", regDate = "";
        if ((params[0] != null) && (!params[0].equals(""))){result       = params[0];}

        if ((params.length > 1) && (params[1] != null) && (!params[1].equals(""))){resultText   = params[1];}
        if ((params.length > 2) && (params[2] != null) && (!params[2].equals(""))){clientName   = params[2];}
        if ((params.length > 3) && (params[3] != null) && (!params[3].equals(""))){account      = params[3];}
        if ((params.length > 4) && (params[4] != null) && (!params[4].equals(""))){regID        = params[4];}
        if ((params.length > 5) && (params[5] != null) && (!params[5].equals(""))){regDate      = params[5];}
        return responseDocument(sign, result, resultText,  clientName, account, regID, regDate);
    }

    private Document responseDocument(String sign, String errorCode, String errorText) throws ParserConfigurationException, CacheException {
        return responseDocument(sign, errorCode, errorText, "","", "", "");
    }


    private Document responseDocument(String sign, String errorCode, String errorText, String clientName, String account, String reg_id, String reg_date) throws ParserConfigurationException, CacheException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        // root elements
        Document doc = docBuilder.newDocument();
        Element responseElement = doc.createElement("response");
        doc.appendChild(responseElement);



        Element paramsElement = doc.createElement("params");
        Element errCodeElement = doc.createElement("err_code");
        errCodeElement.appendChild(doc.createTextNode(errorCode));
        paramsElement.appendChild(errCodeElement);
        if (!errorText.equals("")){
            Element errTextElement = doc.createElement("err_text");
            errTextElement.appendChild(doc.createTextNode(errorText));
            paramsElement.appendChild(errTextElement);
        }


        if (!clientName.equals("")){
            Element clientNameElement = doc.createElement("client_name");
            clientNameElement.appendChild(doc.createTextNode(clientName));
            paramsElement.appendChild(clientNameElement);

        }

        if (!account.equals("")){
            Element accountElement = doc.createElement("account");
            accountElement.appendChild(doc.createTextNode(account));
            paramsElement.appendChild(accountElement);
        }

        if (!reg_id.equals("")){
            Element regIDElement = doc.createElement("reg_id");
            regIDElement.appendChild(doc.createTextNode(reg_id));
            paramsElement.appendChild(regIDElement);
        }

        if (!reg_date.equals("")){
            Element regDateElement = doc.createElement("reg_date");
            regDateElement.appendChild(doc.createTextNode(reg_date));
            paramsElement.appendChild(regDateElement);
        }

        responseElement.appendChild(paramsElement);

        if (!errorCode.equals("10") && !errorCode.equals("13")) {
            Element signElement = doc.createElement("sign");
            signElement.appendChild(doc.createTextNode(getSign(paramsElement, sign)));
            responseElement.appendChild(signElement);
        }


        return doc;

    }

    private Boolean CheckSign(String Sign, String body) throws CacheException {
        String params = body.split("<params>")[1].split("</params>")[0];
        String password = CKassa.GetPassword(getDataBase(), String.valueOf(APIServer.getPort()));
        String md5 = DigestUtils.md5Hex(params + password).toUpperCase();
        Sign = Sign.toUpperCase();
        System.out.println("CheckSign params   = " + params);
        System.out.println("CheckSign password = " + password);
        System.out.println("CheckSign md5      = " + md5);
        System.out.println("CheckSign Sign     = " + Sign);
        return md5.equals(Sign);
    }

    private static String extractTextChildren(Element parentNode) {
        NodeList childNodes = parentNode.getChildNodes();
        String result = "";
        Element elementary;
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE){
                elementary = (Element) childNodes.item(i);
                result += "<" + elementary.getTagName() + ">" + elementary.getTextContent() + "</" + elementary.getTagName() +">";
            }
        }
        return result;
    }

    private String getSign(Element paramsElement, String sign) throws CacheException {
        String params = extractTextChildren(paramsElement);
        String password = CKassa.GetPassword(getDataBase(), String.valueOf(APIServer.getPort()));
        return DigestUtils.md5Hex(params + sign + password).toUpperCase();
    }

}
