package com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator;

import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.CreditNote;
import org.thymeleaf.context.Context;

public class CreditNotePDFContext extends DocumentPDFContext {
    public CreditNotePDFContext(CreditNote creditNote) {
        this.context = new Context();
        context.setVariable("creditNote", creditNote);
        this.document = creditNote;
        this.template = "creditNote";
    }
}
