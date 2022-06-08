package com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.DianExtensions;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.AuthorizationProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareID;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareSecurityCode;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.DocumentResponse;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.*;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.KeyInfo.KeyInfo;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.Object;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedProperties;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.Cert;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.SigningCertificate;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Signature;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedInfo.SignedInfo;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.*;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.UUID;
import com.RTM.services.co.electronicInvoice.domain.model.party.AttachedDocumentParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;
import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;
import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;
import com.RTM.services.co.electronicInvoice.persistence.Entity.SoftwareIdentifier;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationResponseBuilder{
    private ApplicationResponse document;

    public ApplicationResponseBuilder() { this.reset(); }
    public void reset(){
        this.document = new ApplicationResponse();
    }

    public void setExtensions(InvoiceSource invoiceSource, SoftwareIdentifier softwareIdentifier, ID supplierPartyID, String documentID) {
        DianExtensions dianExtensions = new DianExtensions();
        Signature signature = new Signature();

        dianExtensions.setInvoiceSource(invoiceSource);
        dianExtensions.setSoftwareProvider(new SoftwareProvider(supplierPartyID,new SoftwareID(softwareIdentifier.getSoftwareId())));
        dianExtensions.setSoftwareSecurityCode(new SoftwareSecurityCode(softwareIdentifier.getSoftwareSecurityCode(documentID)));
        dianExtensions.setAuthorizationProvider(new AuthorizationProvider());

        this.document.setUblExtensions(new UBLExtensions(
                new UBLExtensionDIAN(new ExtensionContentDIAN(dianExtensions)),
                new UBLExtensionSignature(new ExtensionContentSignature(signature))
        ));
    }
    public void setDocumentStaticParams(String UBLVersionID, String profileID){
        this.document.setUBLVersionID(UBLVersionID);
        this.document.setProfileID(profileID);
    }
    public void setDocumentParams(ElectronicDocument document, String note){
        this.document.setCustomizationID(document.getCustomizationID());
        this.document.setProfileExecutionID(document.getProfileExecutionID());
        this.document.setNote(note);
    }
    public void setDocumentID(String ID,  String algorithm, String issueDate, String referenceDocumentID, SoftwareIdentifier softwareIdentifier){
        this.document.setId(ID);
        this.document.setCUFE(new UUID(this.document.getCustomizationID(),algorithm));
        this.document.getCUFE().setValue(
                this.document.getID(),
                issueDate,
                this.document.getSenderParty().getCompanyID().IDtoString(),
                this.document.getReceiverParty().getCompanyID().IDtoString(),
                "response code",
                referenceDocumentID,
                softwareIdentifier.getSoftwarePin()
        );
    }
    public void setDocumentDateTime(Date issueDateTime){
        this.document.setIssueDate(DataFormatService.setDateFormat(issueDateTime));
        this.document.setIssueTime(DataFormatService.setTimeFormat(issueDateTime));
    }
    public void setPartys(PartyTaxScheme senderParty, PartyTaxScheme reciberParty){
        this.document.setSenderParty(new AttachedDocumentParty(senderParty));
        this.document.setReceiverParty(new AttachedDocumentParty(reciberParty));
    }
    public void setSignature(String document, List<Certificate> certificates) {
        String UUID = this.document.getCUFE().getValue();
        Signature signature = this.document.getUblExtensions().getUblExtensionSignature().getExtensionContent().getExtensions();
        signature.setKeyInfo(new KeyInfo(certificates.stream().filter(cert -> cert.getEntity().equals("supplier")).collect(Collectors.toList()).get(0).getCertificate()));
        signature.setObject(new Object(new Date(),UUID));
        signature.getObject().getQualifyingProperties().setSigningCertificate(this.getCertificate(certificates));
        signature.getObject().getQualifyingProperties().setTarget(UUID);
        signature.setSignedInfo(new SignedInfo(UUID));
        signature.setSignatureValue(document);
    }
    public void setSignatureReference(String rootNode, String keyInfo, String signedPropertiesNode){
        Signature signature = this.document.getUblExtensions().getUblExtensionSignature().getExtensionContent().getExtensions();
        signature.setReferenceToDigest(rootNode);
        signature.setReferenceKeyInfoToDigest(keyInfo);
        signature.setReferenceKeySignedPropertiesToDigest(signedPropertiesNode);
    }
    public void setDocumentResponse(DocumentResponse documentResponse){
        this.document.setDocumentResponse(documentResponse);
    }
    public String getDocumentType() {
        return "01";
    }
    public SignedProperties getSignedProperties(){
        return this.document.getUblExtensions().getUblExtensionSignature().getExtensionContent().getExtensions().getSignedProperties();
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
    public ApplicationResponse getDocument(){
        return this.document;
    }
}
