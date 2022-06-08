package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider;

import com.RTM.services.co.electronicInvoice.domain.model.util.SchemeAgency;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class SoftwareSecurityCode implements SchemeAgency {

    private String code;
    public SoftwareSecurityCode() {}
    public SoftwareSecurityCode(String id) {
        this.code = id;
    }
    @XmlValue
    public String getId() {
        return code;
    }
    @XmlAttribute
    public int getSchemeAgencyID() {
        return this.SchemeAgencyID();
    }
    @XmlAttribute
    public String getSchemeAgencyName() {
        return this.SchemeAgencyName();
    }

    public void setId(String id) {
        this.code = id;
    }
}
