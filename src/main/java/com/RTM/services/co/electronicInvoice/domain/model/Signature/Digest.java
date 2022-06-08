package com.RTM.services.co.electronicInvoice.domain.model.Signature;

import com.RTM.services.co.electronicInvoice.domain.service.DigestService;

import javax.xml.bind.annotation.XmlElement;

public class Digest {
    private Algorithm DigestMethod;
    private String DigestValue;
    public Digest(String algorithm) {
        this.DigestMethod = new Algorithm(algorithm); //"http://www.w3.org/2001/04/xmldsig‐more#rsa‐sha256"
    }
    public Digest() {}

    @XmlElement(name = "DigestMethod", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Algorithm getDigestMethod() {
        return DigestMethod;
    }
    @XmlElement(name = "DigestValue", namespace="http://www.w3.org/2000/09/xmldsig#")
    public String getDigestValue() {
        return DigestValue;
    }
    public void setDigestValue(String digestValue) {
        DigestValue = DigestService.digest(digestValue);
    }
}
