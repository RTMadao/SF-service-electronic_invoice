package com.RTM.services.co.electronicInvoice.domain.model.AppendDocument;

public class BillingReference {
    protected InvoiceDocumentReference invoiceDocumentReference;

    public BillingReference() {}
    public BillingReference(String ID, String UUID, String issueDate) {
        this.invoiceDocumentReference = new InvoiceDocumentReference(ID,UUID,issueDate);
    }
}
