package com.RTM.services.co.electronicInvoice.domain.model.party.location;

import javax.xml.bind.annotation.XmlElement;

public class AddressLine {
    private String line;

    public AddressLine() {}

    public AddressLine(String line) {
        this.line = line;
    }

    @XmlElement(name = "Line", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
