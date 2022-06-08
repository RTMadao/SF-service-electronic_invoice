package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource;

import javax.xml.bind.annotation.XmlElement;

public class InvoiceSource {

    private IdentificationCode identificationCode;

    public InvoiceSource(){}

    public InvoiceSource(IdentificationCode identificationCode) {
        this.identificationCode = identificationCode;
    }

    @XmlElement(name = "IdentificationCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public IdentificationCode getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(IdentificationCode identificationCode) {
        this.identificationCode = identificationCode;
    }
}
