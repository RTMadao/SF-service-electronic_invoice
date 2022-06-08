package com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme;

import javax.xml.bind.annotation.XmlElement;

public class TaxScheme {
    private String ID;
    private String name;

    public TaxScheme(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public TaxScheme() {}
    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "Name", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
}
