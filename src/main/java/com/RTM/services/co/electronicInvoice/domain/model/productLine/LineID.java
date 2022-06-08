package com.RTM.services.co.electronicInvoice.domain.model.productLine;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class LineID {
    private String value;
    private String schemeID;

    public LineID() {}

    public LineID(String value, String schemeID) {
        this.value = value;
        this.schemeID = schemeID;
    }
    @XmlValue
    public String getValue() {
        return value;
    }
    @XmlAttribute
    public String getSchemeID() {
        return schemeID;
    }
}
