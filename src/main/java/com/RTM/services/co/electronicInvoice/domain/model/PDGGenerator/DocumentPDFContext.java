package com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator;

import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ElectronicDocument;
import org.thymeleaf.context.Context;

public abstract class DocumentPDFContext {
    protected Context context;
    protected String template;
    protected ElectronicDocument document;

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }
    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }
    public ElectronicDocument getDocument() {
        return document;
    }
    public void setDocument(ElectronicDocument document) {
        this.document = document;
    }
}
