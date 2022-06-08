package com.RTM.services.co.electronicInvoice.domain.model.soapExange;

import com.RTM.services.co.electronicInvoice.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class GetStatusClient extends WebServiceGatewaySupport {
    public GetStatusResponse getDocumentStatus(String trackID){
        ObjectFactory factory = new ObjectFactory();
        GetStatus request = new GetStatus();

        request.setTrackId(factory.createGetStatusTrackId(trackID));

        GetStatusResponse response = (GetStatusResponse) getWebServiceTemplate().marshalSendAndReceive("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl",request);
        return response;
    }
}
