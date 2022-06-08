package com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.*;
import com.RTM.services.co.electronicInvoice.domain.model.DateRange;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.AllowanceCharge;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.LegalMonetaryTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PaymentExchangeRate;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PaymentMeans;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PrepaidPayment.PrepaidPayment;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Terms.DeliveryTerms;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.UBLExtensions;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DiscrepancyResponse;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DocumentCurrencyCode;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.UUID;
import com.RTM.services.co.electronicInvoice.domain.model.party.AccountingCustomerParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.AccountingSupplierParty;
import com.RTM.services.co.electronicInvoice.domain.model.party.Delivery;
import com.RTM.services.co.electronicInvoice.domain.model.party.TaxRepresentativeParty;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.DocumentLine.DebitNoteLine;
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

@XmlRootElement(name = "DebitNote")
@XmlType(propOrder={"ublExtensions","UBLVersionID","customizationID","profileID","profileExecutionID","ID","CUDE",
        "issueDate","issueTime","note","documentCurrencyCode","lineCountNumeric","invoicePeriod","discrepancyResponse",
        "invoiceReference","orderReference","despatchDocumentReference","receiptDocumentReference",
        "additionalDocumentReference","accountingSupplierParty","accountingCustomerParty","taxRepresentativeParty",
        "delivery","deliveryTerms","paymentExchangeRate","paymentMeans","allowanceCharges","taxTotal",
        "legalMonetaryTotal","debitNoteLines"
})
public class DebitNote extends ElectronicDocument{
    private DiscrepancyResponse discrepancyResponse;
    private BillingReferenceInvoice invoiceReference;
    private InvoiceDocumentReference additionalDocumentReference;
    private List<PaymentMeans> paymentMeans;
    private List<DebitNoteLine> debitNoteLines;

    public DebitNote() {}

    @XmlElement(name = "UBLExtensions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public UBLExtensions getUblExtensions() {
        return ublExtensions;
    }
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return id;
    }
    @XmlElement(name = "ProfileID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getProfileID() {
        return profileID+": Nota Débito de Factura Electrónica de Venta";
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
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getNote() {
        return Note;
    }
    @Override
    @XmlElement(name = "AccountingSupplierParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AccountingSupplierParty getAccountingSupplierParty() {
        return accountingSupplierParty;
    }
    @XmlElement(name = "IssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueDate() {
        return IssueDate;
    }
    @XmlElement(name = "IssueTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueTime() {
        return IssueTime;
    }
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public UUID getCUDE() {
        return CUDE;
    }
    @XmlElement(name = "InvoicePeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public DateRange getInvoicePeriod() {
        return InvoicePeriod;
    }
    @XmlElement(name = "DiscrepancyResponse", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public DiscrepancyResponse getDiscrepancyResponse() {
        return discrepancyResponse;
    }
    @XmlElement(name = "DocumentCurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public DocumentCurrencyCode getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }
    @XmlElement(name = "LineCountNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getLineCountNumeric() {
        return lineCountNumeric;
    }
    @XmlElement(name = "OrderReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AppendDocument getOrderReference() {
        return orderReference;
    }
    @XmlElement(name = "BillingReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public BillingReferenceInvoice getInvoiceReference() {
        return invoiceReference;
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
    public InvoiceDocumentReference getAdditionalDocumentReference() {
        return additionalDocumentReference;
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
    @XmlElement(name = "PaymentMeans", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<PaymentMeans> getPaymentMeans() {
        return paymentMeans;
    }
    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }
    @XmlElement(name = "Delivery", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Delivery getDelivery() {
        return delivery;
    }
    @XmlElement(name = "DeliveryTerms", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<DeliveryTerms> getDeliveryTerms() {
        return deliveryTerms;
    }
    @XmlElement(name = "PaymentExchangeRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public PaymentExchangeRate getPaymentExchangeRate() {
        return paymentExchangeRate;
    }
    @XmlElement(name = "TaxTotal", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<TaxTotal> getTaxTotal() {
        return taxTotal;
    }
    @XmlElement(name = "RequestedMonetaryTotal", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public LegalMonetaryTotal getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }
    @XmlElement(name = "DebitNoteLine", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<DebitNoteLine> getDebitNoteLines() {
        return debitNoteLines;
    }

    @Override
    public ID supplierPartyID() {
        return this.accountingSupplierParty.getCompanyID();
    }
    @Override
    public String getDocumentName(String assignCode, String fileNumber){
        String nit = this.accountingSupplierParty.getCompanyID().IDtoString();
        for (int i=0;i<(10-nit.length());i++) nit = "0"+nit;
        for (int i=0;i<(8-fileNumber.length());i++) fileNumber = "0"+fileNumber;
        return "nd"+nit+assignCode+ DataFormatService.setYearLastDigitFormat(new Date())+fileNumber;
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
    public InvoiceDocumentReference getRelatedInvoice(){
        return  this.invoiceReference.getInvoiceDocumentReference();
    }
    public void setDiscrepancyResponse(DiscrepancyResponse discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }
    public void setInvoiceReference(BillingReferenceInvoice invoiceReference) {
        this.invoiceReference = invoiceReference;
    }
    public void setAdditionalDocumentReference(InvoiceDocumentReference additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }
    public void setPaymentMeans(List<PaymentMeans> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }
    public void setDebitNoteLines(List<DebitNoteLine> debitNoteLines) {
        this.debitNoteLines = debitNoteLines;
    }
}
