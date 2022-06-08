package com.RTM.services.co.electronicInvoice.domain.model.soapExange;

import com.RTM.services.co.electronicInvoice.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class GetStatusZipClient extends WebServiceGatewaySupport {
    public GetStatusZipResponse getDocumentStatus(String trackID){
        ObjectFactory factory = new ObjectFactory();
        GetStatusZip request = new GetStatusZip();

        request.setTrackId(factory.createGetStatusZipTrackId(trackID));

        GetStatusZipResponse response = (GetStatusZipResponse) getWebServiceTemplate().marshalSendAndReceive("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl",request);
        return response;
    }
}
