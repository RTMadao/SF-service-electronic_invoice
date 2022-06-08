package com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder;

import com.RTM.services.co.electronicInvoice.domain.model.Attachment.Attachment;
import com.RTM.services.co.electronicInvoice.domain.model.Attachment.ParentDocumentLineReference;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.AttachedDocument;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ElectronicDocument;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedProperties;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.Cert;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.SigningCertificate;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Signature;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.*;
import com.RTM.services.co.electronicInvoice.domain.model.party.AttachedDocumentParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;
import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;
import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;

import java.util.Date;
import java.util.List;

public class AttachedDocumentBuilder{
    private AttachedDocument document;

    public AttachedDocumentBuilder() { this.reset(); }
    public void reset(){
        this.document = new AttachedDocument();
    }
    public AttachedDocumentBuilder setBuilder(AttachedDocument attachedDocument){
        this.document = attachedDocument;
        return this;
    }

    public void setExtensions() {
        Signature signature = new Signature();
        this.document.setUblExtensionSignature(new UBLExtensionSignature(new ExtensionContentSignature(signature)));
    }
    public void setDocumentStaticParams(String UBLVersionID, String profileID){
        this.document.setUBLVersionID(UBLVersionID);
        this.document.setProfileID(profileID);
    }
    public void setDocumentParams(ElectronicDocument document){
        this.document.setCustomizationID("Documentos adjuntos");
        this.document.setProfileExecutionID(document.getProfileExecutionID());
    }
    public void setDocumentID(String ID, String parentDocumentID){
        this.document.setID(ID);
        this.document.setParentDocumentID(parentDocumentID);
    }
    public void setDocumentDateTime(Date issueDateTime){
        this.document.setIssueDate(DataFormatService.setDateFormat(issueDateTime));
        this.document.setIssueTime(DataFormatService.setTimeFormat(issueDateTime));
    }
    public void setPartys(ElectronicDocument document){
        this.document.setSenderParty(new AttachedDocumentParty(document.getAccountingSupplierParty().getPartyToAttachedDocumentParty()));
        this.document.setReceiverParty(new AttachedDocumentParty(document.getAccountingCustomerParty().getPartyToAttachedDocumentParty()));
    }
    public void setAttachment(String document){
        this.document.setAttachment(new Attachment(document));
    }
    public void setParentDocumentLineReference(String ID, String UUID, String issueDate, String applicationResponseDocument, String responseCode){
        ParentDocumentLineReference lineReference = new ParentDocumentLineReference(Integer.toString(this.document.getParentDocumentLineReference().size()+1));
        lineReference.setDocumentReference(ID,UUID,issueDate);
        lineReference.setResponseAttachment(applicationResponseDocument);
        lineReference.setResultOfVerification(responseCode, new Date());

        this.document.addParentDocumentLineReference(lineReference);
    }
    public void setSignature(ElectronicDocument document) {
        Signature signature = document.getUblExtensions().getUblExtensionSignature().getExtensionContent().getExtensions();
        this.document.getUblExtensionSignature().getExtensionContent().setSignature(signature);

    }
    public void setSignatureReference(String rootNode, String keyInfo, String signedPropertiesNode){
        Signature signature = this.document.getUblExtensionSignature().getExtensionContent().getExtensions();
        signature.setReferenceToDigest(rootNode);
        signature.setReferenceKeyInfoToDigest(keyInfo);
        signature.setReferenceKeySignedPropertiesToDigest(signedPropertiesNode);
    }
    public String getDocumentType() {
        return "01";
    }
    public SignedProperties getSignedProperties(){
        return this.document.getUblExtensionSignature().getExtensionContent().getExtensions().getSignedProperties();
    }
    public SigningCertificate getCertificate(List<Certificate> certificates){
        SigningCertificate certificateContainer = new SigningCertificate();
        certificates.forEach(certificate -> {
            if (certificate.getEntity().equals("supplier")) certificateContainer.setCertificate(new Cert(certificate.getIssuerName(), certificate.getSerialNumber(), certificate.getCertificate()));
            else if (certificate.getEntity().equals("issuer")) certificateContainer.setIssuingCertificate(new Cert(certificate.getIssuerName(), certificate.getSerialNumber(), certificate.getCertificate()));
            else certificateContainer.setRootCertificate(new Cert(certificate.getIssuerName(), certificate.getSerialNumber(), certificate.getCertificate()));
        });
        return certificateContainer;
    }

    public AttachedDocument getDocument(){
        return this.document;
    }
}
