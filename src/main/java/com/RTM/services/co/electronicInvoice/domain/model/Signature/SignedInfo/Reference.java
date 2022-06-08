package com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedInfo;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Algorithm;
import com.RTM.services.co.electronicInvoice.domain.service.DigestService;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Reference {
    private Algorithm digestMethod;
    private String DigestValue;
    private String URI;
    public Reference(String URI) {
        digestMethod = new Algorithm("http://www.w3.org/2001/04/xmldsig‐more#rsa‐sha256");
        this.URI = URI;
    }
    public Reference() {}

    @XmlElement(name = "DigestMethod", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Algorithm getDigestMethod() {
        return digestMethod;
    }
    @XmlElement(name = "DigestValue", namespace="http://www.w3.org/2000/09/xmldsig#")
    public String getDigestValue() {
        return DigestValue;
    }
    @XmlAttribute(name = "URI")
    public String getURI() {
        return URI;
    }
    public void setDigestValue(String digestValue) {
        DigestValue = DigestService.digest(digestValue);
    }
}
