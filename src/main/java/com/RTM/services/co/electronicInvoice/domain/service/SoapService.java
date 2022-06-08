package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.domain.model.soapExange.GetStatusClient;
import com.RTM.services.co.electronicInvoice.domain.model.soapExange.GetStatusZipClient;
import com.RTM.services.co.electronicInvoice.domain.model.soapExange.SendBillAsyncClient;
import com.RTM.services.co.electronicInvoice.domain.model.soapExange.SendBillSyncClient;
import com.RTM.services.co.electronicInvoice.wsdl.*;
import com.RTM.services.co.electronicInvoice.wsdl.DianResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoapService {
    @Autowired
    private SendBillSyncClient sendBillSyncClient;
    @Autowired
    private SendBillAsyncClient sendBillAsyncClient;
    @Autowired
    private GetStatusClient getStatusClient;
    @Autowired
    private GetStatusZipClient getStatusZipClient;

    public byte[] validateDocument(String fileName, byte[] contentFile){
        ObjectFactory factory = new ObjectFactory();
        SendBillSyncResponse response = sendBillSyncClient.validateDocument(fileName,contentFile);
        return response.getSendBillSyncResult().getValue().getXmlBase64Bytes().getValue();
    }
    public String validateDocuments(String fileName, byte[] contentFile){
        ObjectFactory factory = new ObjectFactory();
        SendBillAsyncResponse response = sendBillAsyncClient.validateDocument(fileName,contentFile);
        return response.getSendBillAsyncResult().getValue().getZipKey().getValue();
    }
    public byte[] getDocumentStatus(String trackID){
        ObjectFactory factory = new ObjectFactory();
        GetStatusResponse response = getStatusClient.getDocumentStatus(trackID);
        return response.getGetStatusResult().getValue().getXmlBase64Bytes().getValue();
    }
    public List<DianResponse> getZipDocumentStatus(String trackID){
        ObjectFactory factory = new ObjectFactory();
        GetStatusZipResponse response = getStatusZipClient.getDocumentStatus(trackID);
        return response.getGetStatusZipResult().getValue().getDianResponse();
    }
}
