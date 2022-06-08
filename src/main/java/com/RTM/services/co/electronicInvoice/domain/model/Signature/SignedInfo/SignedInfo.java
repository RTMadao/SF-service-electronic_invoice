package com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedInfo;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Algorithm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"canonicalizationMethod","signatureMethod","reference","referenceKeyInfo","referenceKeySignedProperties"})
public class SignedInfo {
    private Algorithm canonicalizationMethod;
    private Algorithm signatureMethod;
    private DocumentReference reference;
    private Reference referenceKeyInfo;
    private Reference referenceKeySignedProperties;

    public SignedInfo() {}
    public SignedInfo(String UUID) {
        this.canonicalizationMethod = new Algorithm("http://www.w3.org/TR/2001/REC‐xml‐c14n‐20010315");
        this.signatureMethod = new Algorithm("http://www.w3.org/2001/04/xmldsig‐more#rsa‐sha256");
        reference = new DocumentReference("");
        referenceKeyInfo = new Reference(UUID+"‐KeyInfo");
        referenceKeySignedProperties = new Reference("#xmldsig-"+UUID+"‐signedprops");
    }
    @XmlElement(name = "CanonicalizationMethod", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Algorithm getCanonicalizationMethod() {
        return canonicalizationMethod;
    }
    @XmlElement(name = "SignatureMethod", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Algorithm getSignatureMethod() {
        return signatureMethod;
    }
    @XmlElement(name = "Reference", namespace="http://www.w3.org/2000/09/xmldsig#")
    public DocumentReference getReference() {
        return reference;
    }
    @XmlElement(name = "Reference", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Reference getReferenceKeyInfo() {
        return referenceKeyInfo;
    }
    @XmlElement(name = "Reference", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Reference getReferenceKeySignedProperties() {
        return referenceKeySignedProperties;
    }
    public void setReference(String reference) {
        this.reference.setDigestValue(reference);
    }
    public void setReferenceKeyInfo(String referenceKeyInfo) {
        this.referenceKeyInfo.setDigestValue(referenceKeyInfo);
    }
    public void setReferenceKeySignedProperties(String referenceKeySignedProperties) {
        this.referenceKeySignedProperties.setDigestValue(referenceKeySignedProperties);
    }
}
