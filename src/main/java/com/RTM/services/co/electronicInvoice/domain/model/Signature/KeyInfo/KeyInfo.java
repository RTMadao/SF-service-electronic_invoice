package com.RTM.services.co.electronicInvoice.domain.model.Signature.KeyInfo;

import javax.xml.bind.annotation.XmlElement;

public class KeyInfo {
    private X509Data x509Data;
    public KeyInfo(String certificate) {
        x509Data = new X509Data(certificate);
    }

    public KeyInfo() {}

    @XmlElement(name = "X509Data", namespace="http://www.w3.org/2000/09/xmldsig#")
    public X509Data getX509Data() {
        return x509Data;
    }
}
