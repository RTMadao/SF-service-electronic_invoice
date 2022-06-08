package com.RTM.services.co.electronicInvoice.domain.model.soapExange;

import com.RTM.services.co.electronicInvoice.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SendBillAsyncClient extends WebServiceGatewaySupport {
    public SendBillAsyncResponse validateDocument(String fileName, byte[] contentFile){
        ObjectFactory factory = new ObjectFactory();
        SendBillAsync request = new SendBillAsync();

        request.setFileName(factory.createSendBillAsyncFileName(fileName));
        request.setContentFile(factory.createSendBillAsyncContentFile(contentFile));

        SendBillAsyncResponse response = (SendBillAsyncResponse) getWebServiceTemplate().marshalSendAndReceive("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl",request);
        return response;
    }
}
