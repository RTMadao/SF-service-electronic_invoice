package com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.*;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.AuthorizationProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareID;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareSecurityCode;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ElectronicDocument;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.Invoice;
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

public class InvoiceBuilder implements  DocumentBuilder{

    private Invoice document;

    public InvoiceBuilder(){
        this.reset();
    }
    public void reset(){
        this.document = new Invoice();
    }

    @Override
    public void setExtensions(InvoiceSource invoiceSource, InvoiceControl invoiceControl, SoftwareIdentifier softwareIdentifier, ID supplierPartyID, String documentID) {
        DianExtensions dianExtensions = new DianExtensions();
        Signature signature = new Signature();

        dianExtensions.setInvoiceSource(invoiceSource);
        dianExtensions.setInvoiceControl(invoiceControl);
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
        Invoice currentInvoice = (Invoice) electronicDocument;
        this.document.setCustomizationID(currentInvoice.getCustomizationID());
        this.document.setProfileExecutionID(currentInvoice.getProfileExecutionID());
        this.document.setInvoiceTypeCode(currentInvoice.getInvoiceTypeCode());
        this.document.setNote(currentInvoice.getNote());
    }
    @Override
    public void setDocumentID(ElectronicDocument electronicDocument, String algorithm, SoftwareIdentifier softwareIdentifier, String issueDate){
        Invoice currentInvoice = (Invoice) electronicDocument;
        this.document.setId(electronicDocument.getID());
        this.document.setCUDE(new UUID(currentInvoice.getProfileExecutionID(),algorithm));
        this.document.getCUDE().setValue(
                currentInvoice.getID(),
                issueDate,
                currentInvoice.getLegalMonetaryTotal().getLineExtensionAmount().getPaidAmount(),
                currentInvoice.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("01")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentInvoice.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("04")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentInvoice.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("03")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentInvoice.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                currentInvoice.getAccountingSupplierParty().getCompanyID().IDtoString(),
                currentInvoice.getAccountingCustomerParty().getCompanyID().IDtoString(),
                softwareIdentifier.getTechnicalKey(),
                currentInvoice.getProfileExecutionID()
        );
    }
    @Override
    public void setDocumentDateTime(ElectronicDocument electronicDocument, Date issueDateTime){
        Invoice currentInvoice = (Invoice) electronicDocument;

        this.document.setIssueDate(DataFormatService.setDateFormat(issueDateTime));
        this.document.setIssueTime(DataFormatService.setTimeFormat(issueDateTime));
        if (currentInvoice.getDueDate() != null) this.document.setDueDate(currentInvoice.getDueDate());
        if (currentInvoice.getInvoicePeriod() != null) this.document.setInvoicePeriod(currentInvoice.getInvoicePeriod());
    }
    @Override
    public void setDocumentReference(ElectronicDocument electronicDocument){
        Invoice currentInvoice = (Invoice) electronicDocument;

        this.document.setOrderReference(currentInvoice.getOrderReference());
        this.document.setCreditNoteReference(currentInvoice.getCreditNoteReference());
        this.document.setDebitNoteReference(currentInvoice.getDebitNoteReference());
        this.document.setDespatchDocumentReference(currentInvoice.getDespatchDocumentReference());
        this.document.setReceiptDocumentReference(currentInvoice.getReceiptDocumentReference());
        this.document.setAdditionalDocumentReference(currentInvoice.getAdditionalDocumentReference());
    }
    @Override
    public void setPaymentAmount(ElectronicDocument document){
        Invoice currentInvoice = (Invoice) document;

        this.document.setPaymentMeans(currentInvoice.getPaymentMeans());
        this.document.setPrepaidPayment(currentInvoice.getPrepaidPayment());
        this.document.setPaymentExchangeRate(currentInvoice.getPaymentExchangeRate());
        this.document.setAllowanceCharges(currentInvoice.getAllowanceCharges());
        this.document.setTaxTotal(currentInvoice.getTaxTotal());
        this.document.setLegalMonetaryTotal(currentInvoice.getLegalMonetaryTotal());

        this.setInvoiceCurrencyCode(currentInvoice.getDocumentCurrencyCode().getValue());
    }
    @Override
    public void setInvoiceLine(ElectronicDocument document){
        Invoice currentInvoice = (Invoice) document;
        this.document.setLineCountNumeric(currentInvoice.getLineCountNumeric());
        this.document.setInvoiceLines(currentInvoice.getInvoiceLines());
    }
    @Override
    public void setPartys(ElectronicDocument document){
        Invoice currentInvoice = (Invoice) document;
        this.document.setAccountingSupplierParty(currentInvoice.getAccountingSupplierParty());
        this.document.setAccountingCustomerParty(currentInvoice.getAccountingCustomerParty());
        this.document.setTaxRepresentativeParty(currentInvoice.getTaxRepresentativeParty());
    }
    @Override
    public void setDelivery(ElectronicDocument document){
        Invoice currentInvoice = (Invoice) document;
        this.document.setDelivery(currentInvoice.getDelivery());
        this.document.setDeliveryTerms(currentInvoice.getDeliveryTerms());
    }
    public void setInvoiceCurrencyCode(String currencyCode){
        this.document.setDocumentCurrencyCode(new DocumentCurrencyCode(currencyCode));
        this.document.getLegalMonetaryTotal().setCurrencyCode(currencyCode);
        if(this.document.getPrepaidPayment() != null )this.document.getPrepaidPayment().forEach(prepaidPayment -> prepaidPayment.getPaidAmount().setCurrencyID(currencyCode));
        if(this.document.getAllowanceCharges() != null )this.document.getAllowanceCharges().forEach(allowanceCharge -> allowanceCharge.setCurrencyCode(currencyCode));
        if(this.document.getTaxTotal() != null )this.document.getTaxTotal().forEach(taxTotal -> taxTotal.setCurrencyCode(currencyCode));
        this.document.getInvoiceLines().forEach(line -> line.setCurrencyCode(currencyCode));
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
                "ValorTotalFactura="+this.document.getLegalMonetaryTotal().getPayableAmount().getPaidAmount()+"\n"+
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
        return "01";
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

    public Invoice getDocument(){
        return this.document;
    }
}
