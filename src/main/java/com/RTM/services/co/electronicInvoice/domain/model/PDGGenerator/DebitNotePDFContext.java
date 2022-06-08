package com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator;

import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.DebitNote;
import org.thymeleaf.context.Context;

public class DebitNotePDFContext extends DocumentPDFContext {
    public DebitNotePDFContext(DebitNote debitNote) {
        this.context = new Context();
        context.setVariable("debitNote", debitNote);
        this.document = debitNote;
        this.template = "debitNote";
    }
}
