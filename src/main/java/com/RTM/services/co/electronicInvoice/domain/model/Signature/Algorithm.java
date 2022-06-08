package com.RTM.services.co.electronicInvoice.domain.model.Signature;

import javax.xml.bind.annotation.XmlAttribute;

public class Algorithm {
    private String value;
    public Algorithm() {}
    public Algorithm(String value) {
        this.value = value;
    }
    @XmlAttribute(name = "Algorithm")
    public String getValue() {
        return value;
    }
}
