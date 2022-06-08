package com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ElectronicDocument;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedProperties;
import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;
import com.RTM.services.co.electronicInvoice.persistence.Entity.SoftwareIdentifier;

import java.util.Date;
import java.util.List;

public interface DocumentBuilder {

    void setExtensions(InvoiceSource invoiceSource, InvoiceControl invoiceControl, SoftwareIdentifier softwareIdentifier, ID supplierPartyID, String documentID);
    void setDocumentStaticParams(String UBLVersionID, String profileID);
    void setDocumentParams(ElectronicDocument electronicDocument);
    void setDocumentDateTime(ElectronicDocument electronicDocument, Date issueDateTime);
    void setPaymentAmount(ElectronicDocument electronicDocument);
    void setInvoiceLine(ElectronicDocument electronicDocument);
    void setDocumentID(ElectronicDocument electronicDocument, String algorithm, SoftwareIdentifier softwareIdentifier, String issueDate);
    void setDocumentReference(ElectronicDocument electronicDocument);
    void setPartys(ElectronicDocument electronicDocument);
    void setDelivery(ElectronicDocument document);
    void setSignature(String document, List<Certificate> certificates);
    void setSignatureReference(String rootNode, String keyInfo, String signedPropertiesNode);
    void setQRCode(Date issueDate);

    ElectronicDocument getDocument();
    String getDocumentType();
    SignedProperties getSignedProperties();
}
