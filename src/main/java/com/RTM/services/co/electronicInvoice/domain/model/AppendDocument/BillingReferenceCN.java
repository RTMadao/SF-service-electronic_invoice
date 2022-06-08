package com.RTM.services.co.electronicInvoice.domain.model.AppendDocument;

import javax.xml.bind.annotation.XmlElement;

public class BillingReferenceCN extends BillingReference{
    public BillingReferenceCN() {}
    public BillingReferenceCN(String ID, String UUID, String issueDate) {
        super(ID, UUID, issueDate);
    }
    @XmlElement(name = "CreditNoteDocumentReference", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public InvoiceDocumentReference getInvoiceDocumentReference() {
        return this.invoiceDocumentReference;
    }
}
