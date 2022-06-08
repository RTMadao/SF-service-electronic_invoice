package com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedInfo;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Algorithm;
import com.RTM.services.co.electronicInvoice.domain.service.DigestService;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"transforms","digestMethod","digestValue"})
public class DocumentReference {
    private Transforms transforms;
    private Algorithm digestMethod;
    private String DigestValue;
    private String URI;

    public DocumentReference() {}
    public DocumentReference(String URI) {
        digestMethod = new Algorithm("http://www.w3.org/2001/04/xmldsig‐more#rsa‐sha256");
        this.URI = URI;
        transforms = new Transforms();
    }
    @XmlElement(name = "Transforms", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Transforms getTransforms() {
        return transforms;
    }
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
    public void setTransforms(Transforms transforms) {
        this.transforms = transforms;
    }
    public void setDigestValue(String digestValue) {
        DigestValue = DigestService.digest(digestValue);
    }
}
