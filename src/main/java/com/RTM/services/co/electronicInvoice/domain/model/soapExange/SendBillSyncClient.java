package com.RTM.services.co.electronicInvoice.domain.model.soapExange;

import com.RTM.services.co.electronicInvoice.wsdl.ObjectFactory;
import com.RTM.services.co.electronicInvoice.wsdl.SendBillSync;
import com.RTM.services.co.electronicInvoice.wsdl.SendBillSyncResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SendBillSyncClient extends WebServiceGatewaySupport {
    public SendBillSyncResponse validateDocument(String fileName, byte[] contentFile){
        ObjectFactory factory = new ObjectFactory();
        SendBillSync request = new SendBillSync();

        request.setFileName(factory.createSendBillAsyncFileName(fileName));
        request.setContentFile(factory.createSendBillAsyncContentFile(contentFile));

        SendBillSyncResponse response = (SendBillSyncResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl",request);
        return response;
    }
}
