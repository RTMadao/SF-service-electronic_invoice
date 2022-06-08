package com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator;

import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.Invoice;
import org.thymeleaf.context.Context;

public class InvoicePDFContext extends DocumentPDFContext{
    public InvoicePDFContext(Invoice invoice) {
        this.context = new Context();
        context.setVariable("invoice", invoice);
        this.document = invoice;
        this.template = "invoice";
    }
}
