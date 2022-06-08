package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider;


import com.RTM.services.co.electronicInvoice.domain.model.util.SchemeAgency;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class SoftwareID implements SchemeAgency {

    private String id;

    public SoftwareID() {}
    public SoftwareID(String id) {
        this.id = id;
    }

    @XmlAttribute
    public int getSchemeAgencyID() {
        return this.SchemeAgencyID();
    }

    @XmlAttribute
    public String getSchemeAgencyName() {
        return this.SchemeAgencyName();
    }

    @XmlValue
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
