package com.RTM.services.co.electronicInvoice.domain.model.Signature.KeyInfo;

import javax.xml.bind.annotation.XmlElement;

public class X509Data {
    private String value;
    public X509Data(String certificate) {
        value = certificate;
    }

    public X509Data() {}

    @XmlElement(name = "X509Certificate", namespace="http://www.w3.org/2000/09/xmldsig#")
    public String getValue() {
        return value;
    }
}
