package com.RTM.services.co.electronicInvoice.domain.model.Attachment;

import javax.xml.bind.annotation.XmlElement;

public class Attachment {
    private ExternalReference externalReference;

    public Attachment() {}

    public Attachment(String document) {
        this.externalReference = new ExternalReference(document);
    }

    @XmlElement(name = "ExternalReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public ExternalReference getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(ExternalReference externalReference) {
        this.externalReference = externalReference;
    }
}
