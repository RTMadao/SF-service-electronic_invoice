package com.RTM.services.co.electronicInvoice.domain.model.documentData;

import com.RTM.services.co.electronicInvoice.domain.model.util.ListAgency;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class DocumentCurrencyCode implements ListAgency {
    private String value;

    public DocumentCurrencyCode() {}
    public DocumentCurrencyCode(String documentCurrencyCode) {
        this.value = documentCurrencyCode;
    }
    @XmlValue
    public String getValue() {
        return value;
    }
    @XmlAttribute
    public String getListAgencyID() {
        return this.listAgencyID();
    }
    @XmlAttribute
    public String getListAgencyName() {
        return this.listAgencyName();
    }
    @XmlAttribute
    public String getListID() {
        return "ISO 4217 Alpha";
    }

    public void setValue(String value) {
        this.value = value;
    }
}
