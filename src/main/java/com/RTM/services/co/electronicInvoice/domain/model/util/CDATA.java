package com.RTM.services.co.electronicInvoice.domain.model.util;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class CDATA {
    private String value;

    public CDATA() {}
    public CDATA(String value) {
        this.value = value;
    }
    @XmlValue
    @XmlJavaTypeAdapter(value=CDATAAdapter.class)
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
