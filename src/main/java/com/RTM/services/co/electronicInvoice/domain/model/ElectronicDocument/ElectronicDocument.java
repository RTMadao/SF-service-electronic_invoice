package com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.AppendDocument;
import com.RTM.services.co.electronicInvoice.domain.model.DateRange;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.AllowanceCharge;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.LegalMonetaryTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PaymentExchangeRate;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Terms.DeliveryTerms;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.UBLExtensions;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DocumentCurrencyCode;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.UUID;
import com.RTM.services.co.electronicInvoice.domain.model.party.AccountingCustomerParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.AccountingSupplierParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.Delivery;
import com.RTM.services.co.electronicInvoice.domain.model.party.TaxRepresentativeParty;

import java.util.Date;
import java.util.List;

public abstract class ElectronicDocument {
    protected UBLExtensions ublExtensions;
    protected String UBLVersionID;
    protected String customizationID;
    protected String profileID;
    protected String profileExecutionID;
    protected String id;
    protected UUID CUDE;
    protected String IssueDate;
    protected String IssueTime;
    protected String Note;
    protected DocumentCurrencyCode documentCurrencyCode;
    protected String lineCountNumeric;
    protected DateRange InvoicePeriod;
    protected AppendDocument orderReference;
    protected AppendDocument DespatchDocumentReference;
    protected AppendDocument ReceiptDocumentReference;
    protected AccountingSupplierParty accountingSupplierParty;
    protected AccountingCustomerParty accountingCustomerParty;
    protected TaxRepresentativeParty taxRepresentativeParty;
    protected Delivery delivery;
    protected List<DeliveryTerms> deliveryTerms;
    protected List<AllowanceCharge> allowanceCharges;
    protected PaymentExchangeRate paymentExchangeRate;
    protected List<TaxTotal> taxTotal;
    protected LegalMonetaryTotal legalMonetaryTotal;
    protected Date validationDatetime;

    public ElectronicDocument() {}

    public abstract UBLExtensions getUblExtensions();
    public abstract String getUBLVersionID();
    public abstract String getCustomizationID();
    public abstract String getProfileID();
    public abstract String getProfileExecutionID();
    public abstract String getID();
    public abstract UUID getCUDE();
    public abstract String getIssueDate();
    public abstract String getIssueTime();
    public abstract String getNote();
    public abstract DocumentCurrencyCode getDocumentCurrencyCode();
    public abstract String getLineCountNumeric();
    public abstract DateRange getInvoicePeriod();
    public abstract AppendDocument getOrderReference();
    public abstract AppendDocument getDespatchDocumentReference();
    public abstract AppendDocument getReceiptDocumentReference();
    public abstract AccountingSupplierParty getAccountingSupplierParty();
    public abstract AccountingCustomerParty getAccountingCustomerParty();
    public abstract TaxRepresentativeParty getTaxRepresentativeParty();
    public abstract Delivery getDelivery();
    public abstract List<DeliveryTerms> getDeliveryTerms();
    public abstract List<AllowanceCharge> getAllowanceCharges();
    public abstract PaymentExchangeRate getPaymentExchangeRate();
    public abstract List<TaxTotal> getTaxTotal();
    public abstract LegalMonetaryTotal getLegalMonetaryTotal();
    public Date getValidationDatetime() {
        return validationDatetime;
    }

    public void setUblExtensions(UBLExtensions ublExtensions) {
        this.ublExtensions = ublExtensions;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCUDE(UUID CUDE) {
        this.CUDE = CUDE;
    }
    public void setNote(String note) {
        Note = note;
    }
    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }
    public void setIssueTime(String issueTime) {
        IssueTime = issueTime;
    }
    public void setDocumentCurrencyCode(DocumentCurrencyCode documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }
    public void setLineCountNumeric(String lineCountNumeric) {
        this.lineCountNumeric = lineCountNumeric;
    }
    public void setInvoicePeriod(DateRange invoicePeriod) {
        InvoicePeriod = invoicePeriod;
    }
    public void setOrderReference(AppendDocument orderReference) {
        this.orderReference = orderReference;
    }
    public void setDespatchDocumentReference(AppendDocument despatchDocumentReference) {
        DespatchDocumentReference = despatchDocumentReference;
    }
    public void setReceiptDocumentReference(AppendDocument receiptDocumentReference) {
        ReceiptDocumentReference = receiptDocumentReference;
    }
    public void setAccountingSupplierParty(AccountingSupplierParty accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }
    public void setAccountingCustomerParty(AccountingCustomerParty accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }
    public void setTaxRepresentativeParty(TaxRepresentativeParty taxRepresentativeParty) {
        this.taxRepresentativeParty = taxRepresentativeParty;
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
    public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }
    public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }
    public void setPaymentExchangeRate(PaymentExchangeRate paymentExchangeRate) {
        this.paymentExchangeRate = paymentExchangeRate;
    }
    public void setTaxTotal(List<TaxTotal> taxTotal) {
        this.taxTotal = taxTotal;
    }
    public void setLegalMonetaryTotal(LegalMonetaryTotal legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }
    public void setValidationDatetime(Date validationDatetime) {
        this.validationDatetime = validationDatetime;
    }
    public void setUBLVersionID(String UBLVersionID) {
        this.UBLVersionID = UBLVersionID;
    }
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }
    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }
    public abstract ID supplierPartyID();
    public abstract String getDocumentName(String assignCode, String fileNumber);
}
