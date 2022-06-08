package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.InvoiceDocumentReference;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.DocumentResponse;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.LineReference;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.LineResponse;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.Response;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ApplicationResponse;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ElectronicDocument;
import com.RTM.services.co.electronicInvoice.domain.model.util.StaticParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DianResponse {
    @Autowired
    private ElectronicDocumentService electronicDocumentService;
    @Autowired
    StaticParameter staticParameter;

    public ApplicationResponse getApplicationResponse(ElectronicDocument document){
        DocumentResponse response = new DocumentResponse(
                new Response("02","Documento Validado por la DIAN"),
                new InvoiceDocumentReference(document.getID(), document.getCUDE().getValue(), document.getIssueDate()),
                new LineResponse(new LineReference(1),new ArrayList<>())
        );
        return electronicDocumentService.generateApplicationResponse(document,staticParameter.getDIANPartyData(),document.getAccountingCustomerParty().getPartyToAttachedDocumentParty(),response);
    }
    public ApplicationResponse getApplicationResponseRejected(ElectronicDocument document){
        DocumentResponse response = new DocumentResponse(
                new Response("04","Documento Rechazado por la DIAN"),
                new InvoiceDocumentReference(document.getID(), document.getCUDE().getValue(), document.getIssueDate()),
                new LineResponse(new LineReference(1),new ArrayList<>())
        );
        return electronicDocumentService.generateApplicationResponse(document,staticParameter.getDIANPartyData(),document.getAccountingCustomerParty().getPartyToAttachedDocumentParty(),response);
    }
}
