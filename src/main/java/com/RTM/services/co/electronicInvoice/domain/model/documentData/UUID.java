package com.RTM.services.co.electronicInvoice.domain.model.documentData;

import com.RTM.services.co.electronicInvoice.domain.service.DigestService;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class UUID {
    private String value;
    private String schemeID;
    private String schemeName;

    public UUID(String schemeID, String schemeName) {
        this.schemeID = schemeID;
        this.schemeName = schemeName;
    }
    public UUID() {}

    @XmlValue
    public String getValue() {
        return value;
    }
    @XmlAttribute
    public String getSchemeID() {
        return schemeID;
    }
    @XmlAttribute
    public String getSchemeName() {
        return schemeName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSchemeID(String schemeID) {
        this.schemeID = schemeID;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public void setValue(String ID, String Date, String totalPrice, String IVA, String INC, String ICA, String totalTax, String NIT, String customerID, String key, String profileExecutionID) {
        this.value = DigestService.sha384(ID+Date+totalPrice+"01"+IVA+"04"+INC+"03"+ICA+totalTax+NIT+customerID+key+profileExecutionID);
    }
    public void setValue(String ID, String Date, String NIT, String customerID, String responseCode, String referenceDocumentID, String softwarePin) {
        this.value = DigestService.sha384(ID+Date+NIT+customerID+responseCode+referenceDocumentID+softwarePin);
    }
}
