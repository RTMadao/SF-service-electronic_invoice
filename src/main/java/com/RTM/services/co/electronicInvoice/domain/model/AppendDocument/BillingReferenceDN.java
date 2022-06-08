package com.RTM.services.co.electronicInvoice.domain.model.AppendDocument;

import javax.xml.bind.annotation.XmlElement;

public class BillingReferenceDN extends BillingReference{
    public BillingReferenceDN() {}
    public BillingReferenceDN(String ID, String UUID, String issueDate) {
        super(ID, UUID, issueDate);
    }
    @XmlElement(name = "DebitNoteDocumentReference", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public InvoiceDocumentReference getInvoiceDocumentReference() {
        return this.invoiceDocumentReference;
    }
}
