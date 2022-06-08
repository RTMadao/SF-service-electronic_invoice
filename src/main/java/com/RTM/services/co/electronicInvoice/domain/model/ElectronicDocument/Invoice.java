package com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.BillingReferenceCN;
import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.BillingReferenceDN;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.IdentificationCode;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.DateRange;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.AllowanceCharge;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.LegalMonetaryTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PaymentExchangeRate;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PaymentMeans;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PrepaidPayment.PrepaidPayment;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Terms.DeliveryTerms;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.UBLExtensions;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DocumentCurrencyCode;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.UUID;
import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.AppendDocument;
import com.RTM.services.co.electronicInvoice.domain.model.party.AccountingCustomerParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.AccountingSupplierParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.Delivery;
import com.RTM.services.co.electronicInvoice.domain.model.party.TaxRepresentativeParty;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.DocumentLine.InvoiceLine;
import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.commons.codec.binary.Base64;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Invoice")
@XmlType(propOrder={"ublExtensions","UBLVersionID","customizationID","profileID","profileExecutionID","ID","CUDE",
        "issueDate","issueTime","dueDate","invoiceTypeCode","note","documentCurrencyCode","lineCountNumeric",
        "invoicePeriod","orderReference","creditNoteReference","debitNoteReference","despatchDocumentReference",
        "receiptDocumentReference","additionalDocumentReference","accountingSupplierParty","accountingCustomerParty",
        "taxRepresentativeParty","delivery","deliveryTerms","paymentMeans","prepaidPayment","allowanceCharges",
        "paymentExchangeRate","taxTotal","legalMonetaryTotal","invoiceLines"
})
public class Invoice extends ElectronicDocument{
    private String dueDate;
    private String invoiceTypeCode;
    private BillingReferenceCN creditNoteReference;
    private BillingReferenceDN debitNoteReference;
    private AppendDocument additionalDocumentReference;
    private List<PaymentMeans> paymentMeans;
    private List<PrepaidPayment> prepaidPayment;
    private List<InvoiceLine> invoiceLines;

    public Invoice() {}

    @XmlElement(name = "UBLExtensions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public UBLExtensions getUblExtensions() {
        return ublExtensions;
    }
    @XmlElement(name = "UBLVersionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getUBLVersionID() {
        return UBLVersionID;
    }
    @XmlElement(name = "CustomizationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getCustomizationID() {
        return customizationID;
    }
    @XmlElement(name = "ProfileExecutionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getProfileExecutionID() {
        return profileExecutionID;
    }
    @XmlElement(name = "ProfileID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getProfileID() {
        return profileID+": Factura Electrónica de Venta";
    }
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return id;
    }
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public UUID getCUDE() {
        return CUDE;
    }
    @XmlElement(name = "IssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueDate() {
        return IssueDate;
    }
    @XmlElement(name = "IssueTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueTime() {
        return IssueTime;
    }
    @XmlElement(name = "DueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getDueDate() {
        return dueDate;
    }
    @XmlElement(name = "InvoiceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getNote() {
        return Note;
    }
    @XmlElement(name = "DocumentCurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public DocumentCurrencyCode getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }
    @XmlElement(name = "LineCountNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getLineCountNumeric() {
        return lineCountNumeric;
    }
    @XmlElement(name = "InvoicePeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public DateRange getInvoicePeriod() {
        return InvoicePeriod;
    }
    @XmlElement(name = "OrderReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AppendDocument getOrderReference() {
        return orderReference;
    }
    @XmlElement(name = "BillingReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public BillingReferenceCN getCreditNoteReference() {
        return creditNoteReference;
    }
    @XmlElement(name = "BillingReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public BillingReferenceDN getDebitNoteReference() {
        return debitNoteReference;
    }
    @XmlElement(name = "DespatchDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AppendDocument getDespatchDocumentReference() {
        return DespatchDocumentReference;
    }
    @XmlElement(name = "ReceiptDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AppendDocument getReceiptDocumentReference() {
        return ReceiptDocumentReference;
    }
    @XmlElement(name = "AdditionalDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AppendDocument getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }
    @Override
    @XmlElement(name = "AccountingSupplierParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AccountingSupplierParty getAccountingSupplierParty() {
        return accountingSupplierParty;
    }
    @Override
    @XmlElement(name = "AccountingCustomerParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AccountingCustomerParty getAccountingCustomerParty() {
        return accountingCustomerParty;
    }
    @XmlElement(name = "TaxRepresentativeParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public TaxRepresentativeParty getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }
    @XmlElement(name = "Delivery", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Delivery getDelivery() {
        return delivery;
    }
    @XmlElement(name = "DeliveryTerms", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<DeliveryTerms> getDeliveryTerms() {
        return deliveryTerms;
    }
    @XmlElement(name = "PaymentMeans", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<PaymentMeans> getPaymentMeans() {
        return paymentMeans;
    }
    @XmlElement(name = "PrepaidPayment", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<PrepaidPayment> getPrepaidPayment() {
        return prepaidPayment;
    }
    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }
    @XmlElement(name = "PaymentExchangeRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public PaymentExchangeRate getPaymentExchangeRate() {
        return paymentExchangeRate;
    }
    @XmlElement(name = "TaxTotal", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<TaxTotal> getTaxTotal() {
        return taxTotal;
    }
    @XmlElement(name = "LegalMonetaryTotal", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public LegalMonetaryTotal getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }
    @XmlElement(name = "InvoiceLine", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    @Override
    public com.RTM.services.co.electronicInvoice.domain.model.ID supplierPartyID() {
        return this.accountingSupplierParty.getCompanyID();
    }
    @Override
    public String getDocumentName(String assignCode, String fileNumber){
        String nit = this.accountingSupplierParty.getCompanyID().IDtoString();
        for (int i=0;i<(10-nit.length());i++) nit = "0"+nit;
        for (int i=0;i<(8-fileNumber.length());i++) fileNumber = "0"+fileNumber;
        return "fv"+nit+assignCode+ DataFormatService.setYearLastDigitFormat(new Date())+fileNumber;
    }
    public String generateQRCode(int width, int height){
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(this.ublExtensions.getUblExtensionDIAN().getExtensionContent().getDIANExtension().getQRCode(), BarcodeFormat.QR_CODE, width, height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
            return Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
        } catch (WriterException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getGenerationDateTime(){
        return DataFormatService.getDateFromFormat(this.ublExtensions.getUblExtensionSignature().getExtensionContent().getExtensions().getSignedProperties().getSignedSignatureProperties().getSigningTime(),"yyyy-MM-dd HH:mm:ss");
    }
    public String getValidationDateTime(){
        return (this.validationDatetime != null)?DataFormatService.getDateFromFormat(this.validationDatetime,"yyyy-MM-dd HH:mm:ss"):"";
    }
    public InvoiceControl getInvoiceParams(){
        return this.ublExtensions.getUblExtensionDIAN().getExtensionContent().getDIANExtension().getInvoiceControl();
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }
    public void setCreditNoteReference(BillingReferenceCN creditNoteReference) {
        this.creditNoteReference = creditNoteReference;
    }
    public void setDebitNoteReference(BillingReferenceDN debitNoteReference) {
        this.debitNoteReference = debitNoteReference;
    }
    public void setAdditionalDocumentReference(AppendDocument additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }
    public void setPaymentMeans(List<PaymentMeans> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }
    public void setPrepaidPayment(List<PrepaidPayment> prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
    }
    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
    public void setValidationDateTime(Date date){
        this.validationDatetime = date;
    }

}
