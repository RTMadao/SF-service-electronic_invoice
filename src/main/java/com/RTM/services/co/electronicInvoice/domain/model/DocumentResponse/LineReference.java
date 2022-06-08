package com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse;

import javax.xml.bind.annotation.XmlElement;

public class LineReference {
    private int lineID;
    public LineReference() {}
    public LineReference(int lineID) {
        this.lineID = lineID;
    }
    @XmlElement(name = "LineID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public int getLineID() {
        return lineID;
    }
    public void setLineID(int lineID) {
        this.lineID = lineID;
    }
}
