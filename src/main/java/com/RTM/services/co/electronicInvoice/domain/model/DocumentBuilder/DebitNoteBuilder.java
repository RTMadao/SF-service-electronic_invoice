package com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.DianExtensions;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.AuthorizationProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareID;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareSecurityCode;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.DebitNote;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ElectronicDocument;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.KeyInfo.KeyInfo;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.Object;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedProperties;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.Cert;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.SigningCertificate;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Signature;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedInfo.SignedInfo;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.*;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DocumentCurrencyCode;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.UUID;
import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;
import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;
import com.RTM.services.co.electronicInvoice.persistence.Entity.SoftwareIdentifier;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DebitNoteBuilder implements DocumentBuilder{
    private DebitNote document;

    public DebitNoteBuilder() { this.reset(); }
    public void reset(){
        this.document = new DebitNote();
    }

    @Override
    public void setExtensions(InvoiceSource invoiceSource, InvoiceControl invoiceControl, SoftwareIdentifier softwareIdentifier, ID supplierPartyID, String documentID) {
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
    @Override
    public void setDocumentStaticParams(String UBLVersionID, String profileID){
        this.document.setUBLVersionID(UBLVersionID);
        this.document.setProfileID(profileID);
    }
    @Override
    public void setDocumentParams(ElectronicDocument electronicDocument){
        DebitNote currentDebitNote = (DebitNote) electronicDocument;
        this.document.setCustomizationID(currentDebitNote.getCustomizationID());
        this.document.setProfileExecutionID(currentDebitNote.getProfileExecutionID());
        this.document.setNote(currentDebitNote.getNote());
        this.document.setDiscrepancyResponse(currentDebitNote.getDiscrepancyResponse());
    }
    @Override
    public void setDocumentID(ElectronicDocument electronicDocument, String algorithm, SoftwareIdentifier softwareIdentifier, String issueDate){
        DebitNote currentDebitNote = (DebitNote) electronicDocument;
        this.document.setId(electronicDocument.getID());
        this.document.setCUDE(new UUID(currentDebitNote.getProfileExecutionID(),algorithm));
        this.document.getCUDE().setValue(
                currentDebitNote.getID(),
                issueDate,
                currentDebitNote.getLegalMonetaryTotal().getLineExtensionAmount().getPaidAmount(),
                currentDebitNote.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("01")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentDebitNote.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("04")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentDebitNote.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("03")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentDebitNote.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                currentDebitNote.getAccountingSupplierParty().getCompanyID().IDtoString(),
                currentDebitNote.getAccountingCustomerParty().getCompanyID().IDtoString(),
                softwareIdentifier.getSoftwarePin(),
                currentDebitNote.getProfileExecutionID()
        );
    }
    @Override
    public void setDocumentDateTime(ElectronicDocument electronicDocument, Date issueDateTime){
        DebitNote currentDebitNote = (DebitNote) electronicDocument;

        this.document.setIssueDate(DataFormatService.setDateFormat(issueDateTime));
        this.document.setIssueTime(DataFormatService.setTimeFormat(issueDateTime));
        if (currentDebitNote.getInvoicePeriod() != null) this.document.setInvoicePeriod(currentDebitNote.getInvoicePeriod());
    }
    @Override
    public void setPaymentAmount(ElectronicDocument document){
        DebitNote currentDebitNote = (DebitNote) document;

        this.document.setPrepaidPayment(currentDebitNote.getPrepaidPayment());
        this.document.setPaymentMeans(currentDebitNote.getPaymentMeans());
        this.document.setPaymentExchangeRate(currentDebitNote.getPaymentExchangeRate());
        this.document.setAllowanceCharges(currentDebitNote.getAllowanceCharges());
        this.document.setTaxTotal(currentDebitNote.getTaxTotal());
        this.document.setLegalMonetaryTotal(currentDebitNote.getLegalMonetaryTotal());

        this.setInvoiceCurrencyCode(currentDebitNote.getDocumentCurrencyCode().getValue());
    }
    @Override
    public void setInvoiceLine(ElectronicDocument document){
        DebitNote currentDebitNote = (DebitNote) document;
        this.document.setLineCountNumeric(currentDebitNote.getLineCountNumeric());
        this.document.setDebitNoteLines(currentDebitNote.getDebitNoteLines());
    }
    @Override
    public void setDocumentReference(ElectronicDocument electronicDocument){
        DebitNote currentDebitNote = (DebitNote) electronicDocument;

        this.document.setOrderReference(currentDebitNote.getOrderReference());
        this.document.setInvoiceReference(currentDebitNote.getInvoiceReference());
        this.document.setDespatchDocumentReference(currentDebitNote.getDespatchDocumentReference());
        this.document.setReceiptDocumentReference(currentDebitNote.getReceiptDocumentReference());
        this.document.setAdditionalDocumentReference(currentDebitNote.getAdditionalDocumentReference());
    }
    @Override
    public void setPartys(ElectronicDocument document){
        DebitNote currentDebitNote = (DebitNote) document;
        this.document.setAccountingSupplierParty(currentDebitNote.getAccountingSupplierParty());
        this.document.setAccountingCustomerParty(currentDebitNote.getAccountingCustomerParty());
        this.document.setTaxRepresentativeParty(currentDebitNote.getTaxRepresentativeParty());
    }
    @Override
    public void setDelivery(ElectronicDocument document){
        DebitNote currentDebitNote = (DebitNote) document;
        this.document.setDelivery(currentDebitNote.getDelivery());
        this.document.setDeliveryTerms(currentDebitNote.getDeliveryTerms());
    }
    @Override
    public void setQRCode(Date issueDate) {
        DianExtensions dianExtensions =  this.document.getUblExtensions().getUblExtensionDIAN().getExtensionContent().getDIANExtension();
        String UUID = this.document.getCUDE().getValue();
        dianExtensions.setQRCode(
                "NroFactura="+this.document.getID()+"\n"+
                "NitFacturador="+this.document.getAccountingSupplierParty().getCompanyID().IDtoString()+"\n"+
                "NitAdquiriente="+this.document.getAccountingCustomerParty().getCompanyID().IDtoString()+"\n"+
                "FechaFactura="+DataFormatService.setDateFormat(issueDate)+"\n"+
                "ValorTotalFactura="+this.document.getLegalMonetaryTotal().getPayableAmount()+"\n"+
                "CUFE="+UUID+"\n"+
                "URL=https://catalogo-vpfe-hab.dian.gov.co/Document/FindDocument?documentKey="+UUID
        );
    }
    @Override
    public void setSignature(String document, List<Certificate> certificates) {
        String UUID = this.document.getCUDE().getValue();
        Signature signature = this.document.getUblExtensions().getUblExtensionSignature().getExtensionContent().getExtensions();
        signature.setKeyInfo(new KeyInfo(certificates.stream().filter(cert -> cert.getEntity().equals("supplier")).collect(Collectors.toList()).get(0).getCertificate()));
        signature.setObject(new Object(new Date(),UUID));
        signature.getObject().getQualifyingProperties().setSigningCertificate(this.getCertificate(certificates));
        signature.getObject().getQualifyingProperties().setTarget(UUID);
        signature.setSignedInfo(new SignedInfo(UUID));
        signature.setSignatureValue(document);
    }
    @Override
    public void setSignatureReference(String rootNode, String keyInfo, String signedPropertiesNode){
        Signature signature = this.document.getUblExtensions().getUblExtensionSignature().getExtensionContent().getExtensions();
        signature.setReferenceToDigest(rootNode);
        signature.setReferenceKeyInfoToDigest(keyInfo);
        signature.setReferenceKeySignedPropertiesToDigest(signedPropertiesNode);
    }
    @Override
    public String getDocumentType() {
        return "92";
    }
    @Override
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
    public void setInvoiceCurrencyCode(String currencyCode){
        this.document.setDocumentCurrencyCode(new DocumentCurrencyCode(currencyCode));
        this.document.getLegalMonetaryTotal().setCurrencyCode(currencyCode);
        this.document.getDebitNoteLines().forEach(line -> line.setCurrencyCode(currencyCode));
        if(this.document.getPrepaidPayment() != null )this.document.getPrepaidPayment().forEach(prepaidPayment -> prepaidPayment.getPaidAmount().setCurrencyID(currencyCode));
        if(this.document.getAllowanceCharges() != null )this.document.getAllowanceCharges().forEach(allowanceCharge -> allowanceCharge.setCurrencyCode(currencyCode));
        if(this.document.getTaxTotal() != null )this.document.getTaxTotal().forEach(taxTotal -> taxTotal.setCurrencyCode(currencyCode));
    }

    @Override
    public DebitNote getDocument(){
        return this.document;
    }
}
