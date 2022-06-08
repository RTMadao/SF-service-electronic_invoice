package com.RTM.services.co.electronicInvoice.domain.model.party.location;

import javax.xml.bind.annotation.XmlElement;

public class Contry {
    private String identificationCode;
    private ContryName Name;

    public Contry() {}

    public Contry(String identificationCode, ContryName name) {
        this.identificationCode = identificationCode;
        Name = name;
    }

    @XmlElement(name = "IdentificationCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIdentificationCode() {
        return identificationCode;
    }
    @XmlElement(name = "Name", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public ContryName getName() {
        return Name;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }
    public void setName(ContryName name) {
        Name = name;
    }
}
