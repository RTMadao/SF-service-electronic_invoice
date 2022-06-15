package com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.DianExtensions;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.AuthorizationProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareID;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareSecurityCode;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.CreditNote;
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

public class CreditNoteBuilder implements DocumentBuilder{
    private CreditNote document;

    public CreditNoteBuilder() { this.reset(); }
    public void reset(){
        this.document = new CreditNote();
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
        CreditNote currentCreditNote = (CreditNote) electronicDocument;
        this.document.setCustomizationID(currentCreditNote.getCustomizationID());
        this.document.setProfileExecutionID(currentCreditNote.getProfileExecutionID());
        this.document.setCreditNoteTypeCode(currentCreditNote.getCreditNoteTypeCode());
        this.document.setNote(currentCreditNote.getNote());
        this.document.setDiscrepancyResponse(currentCreditNote.getDiscrepancyResponse());
    }
    @Override
    public void setDocumentDateTime(ElectronicDocument electronicDocument, Date issueDateTime){
        CreditNote currentCreditNote = (CreditNote) electronicDocument;

        this.document.setIssueDate(DataFormatService.setDateFormat(issueDateTime));
        this.document.setIssueTime(DataFormatService.setTimeFormat(issueDateTime));
        if (currentCreditNote.getInvoicePeriod() != null) this.document.setInvoicePeriod(currentCreditNote.getInvoicePeriod());
    }
    @Override
    public void setDocumentID(ElectronicDocument electronicDocument, String algorithm, SoftwareIdentifier softwareIdentifier, String issueDate){
        CreditNote currentCreditNote = (CreditNote) electronicDocument;
        this.document.setId(electronicDocument.getID());
        this.document.setCUDE(new UUID(currentCreditNote.getProfileExecutionID(),algorithm));
        this.document.getCUDE().setValue(
                currentCreditNote.getID(),
                issueDate,
                currentCreditNote.getLegalMonetaryTotal().getLineExtensionAmount().getPaidAmount(),
                currentCreditNote.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("01")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentCreditNote.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("04")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentCreditNote.getTaxTotal().stream().filter(taxTotal -> taxTotal.getTaxLabel().equals("03")).findFirst().map(taxTotal -> taxTotal.getTaxAmount().getPaidAmount()).orElse("0.00"),
                currentCreditNote.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                currentCreditNote.getAccountingSupplierParty().getCompanyID().IDtoString(),
                currentCreditNote.getAccountingCustomerParty().getCompanyID().IDtoString(),
                softwareIdentifier.getSoftwarePin(),
                currentCreditNote.getProfileExecutionID()
        );
    }
    @Override
    public void setPaymentAmount(ElectronicDocument document){
        CreditNote currentCreditNote = (CreditNote) document;

        this.document.setPaymentMeans(currentCreditNote.getPaymentMeans());
        this.document.setPaymentExchangeRate(currentCreditNote.getPaymentExchangeRate());
        this.document.setAllowanceCharges(currentCreditNote.getAllowanceCharges());
        this.document.setTaxTotal(currentCreditNote.getTaxTotal());
        this.document.setLegalMonetaryTotal(currentCreditNote.getLegalMonetaryTotal());

        this.setInvoiceCurrencyCode(currentCreditNote.getDocumentCurrencyCode().getValue());
    }
    @Override
    public void setInvoiceLine(ElectronicDocument document){
        CreditNote currentCreditNote = (CreditNote) document;
        this.document.setLineCountNumeric(currentCreditNote.getLineCountNumeric());
        this.document.setCreditNoteLines(currentCreditNote.getCreditNoteLines());
    }
    @Override
    public void setDocumentReference(ElectronicDocument electronicDocument){
        CreditNote currentCreditNote = (CreditNote) electronicDocument;

        this.document.setOrderReference(currentCreditNote.getOrderReference());
        this.document.setInvoiceReference(currentCreditNote.getInvoiceReference());
        this.document.setDespatchDocumentReference(currentCreditNote.getDespatchDocumentReference());
        this.document.setReceiptDocumentReference(currentCreditNote.getReceiptDocumentReference());
        this.document.setAdditionalDocumentReference(currentCreditNote.getAdditionalDocumentReference());
    }
    @Override
    public void setPartys(ElectronicDocument document){
        CreditNote currentCreditNote = (CreditNote) document;
        this.document.setAccountingSupplierParty(currentCreditNote.getAccountingSupplierParty());
        this.document.setAccountingCustomerParty(currentCreditNote.getAccountingCustomerParty());
        this.document.setTaxRepresentativeParty(currentCreditNote.getTaxRepresentativeParty());
    }
    @Override
    public void setDelivery(ElectronicDocument document){
        CreditNote currentCreditNote = (CreditNote) document;
        this.document.setDelivery(currentCreditNote.getDelivery());
        this.document.setDeliveryTerms(currentCreditNote.getDeliveryTerms());
    }
    @Override
    public void setQRCode(Date issueDate) {
        DianExtensions dianExtensions =  this.document.getUblExtensions().getUblExtensionDIAN().getExtensionContent().getDIANExtension();
        String UUID = this.document.getCUDE().getValue();
        dianExtensions.setQRCode(
                "NroFactura="+this.document.getID()+"\n"+
                "NitFacturador"+this.document.getAccountingSupplierParty().getCompanyID().IDtoString()+"\n"+
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
        return "91";
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
        this.document.getCreditNoteLines().forEach(line -> line.setCurrencyCode(currencyCode));
        if(this.document.getAllowanceCharges() != null )this.document.getAllowanceCharges().forEach(allowanceCharge -> allowanceCharge.setCurrencyCode(currencyCode));
        if(this.document.getTaxTotal() != null )this.document.getTaxTotal().forEach(taxTotal -> taxTotal.setCurrencyCode(currencyCode));
    }

    @Override
    public CreditNote getDocument(){
        return this.document;
    }
}
