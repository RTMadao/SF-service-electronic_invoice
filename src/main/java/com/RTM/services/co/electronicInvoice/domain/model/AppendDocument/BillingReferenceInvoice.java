package com.RTM.services.co.electronicInvoice.domain.model.AppendDocument;

import javax.xml.bind.annotation.XmlElement;

public class BillingReferenceInvoice extends BillingReference{
    public BillingReferenceInvoice() {}
    public BillingReferenceInvoice(String ID, String UUID, String issueDate) {
        super(ID, UUID, issueDate);
    }
    @XmlElement(name = "InvoiceDocumentReference", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public InvoiceDocumentReference getInvoiceDocumentReference() {
        return this.invoiceDocumentReference;
    }
}
