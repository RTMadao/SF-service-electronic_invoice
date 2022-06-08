package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties;

import javax.xml.bind.annotation.XmlElement;

public class IssuerSerial {
    private String X509IssuerName;
    private String X509SerialNumber;
    public IssuerSerial(String x509IssuerName, String x509SerialNumber) {
        X509IssuerName = x509IssuerName;
        X509SerialNumber = x509SerialNumber;
    }
    public IssuerSerial() {}

    @XmlElement(name = "X509IssuerName", namespace="http://www.w3.org/2000/09/xmldsig#")
    public String getX509IssuerName() {
        return X509IssuerName;
    }
    @XmlElement(name = "X509SerialNumber", namespace="http://www.w3.org/2000/09/xmldsig#")
    public String getX509SerialNumber() {
        return X509SerialNumber;
    }
}
