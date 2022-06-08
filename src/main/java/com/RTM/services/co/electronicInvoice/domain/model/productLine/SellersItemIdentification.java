package com.RTM.services.co.electronicInvoice.domain.model.productLine;

import javax.xml.bind.annotation.XmlElement;

public class SellersItemIdentification {
    private String ID;
    private String extendedID;

    public SellersItemIdentification() {}
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "ExtendedID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getExtendedID() {
        return extendedID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setExtendedID(String extendedID) {
        this.extendedID = extendedID;
    }
}
