package com.RTM.services.co.electronicInvoice.domain.model.Signature;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.KeyInfo.KeyInfo;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.Object;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedProperties;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedInfo.SignedInfo;
import com.RTM.services.co.electronicInvoice.domain.service.DigestService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"signedInfo","signatureValue","keyInfo","object"})
public class Signature {
    private SignedInfo signedInfo;
    private String SignatureValue;
    private KeyInfo keyInfo;
    private Object object;
    public Signature() {}
    @XmlElement(name = "SignedInfo", namespace="http://www.w3.org/2000/09/xmldsig#")
    public SignedInfo getSignedInfo() {
        return signedInfo;
    }
    @XmlElement(name = "SignatureValue", namespace="http://www.w3.org/2000/09/xmldsig#")
    public String getSignatureValue() {
        return SignatureValue;
    }
    @XmlElement(name = "KeyInfo", namespace="http://www.w3.org/2000/09/xmldsig#")
    public KeyInfo getKeyInfo() {
        return keyInfo;
    }
    @XmlElement(name = "Object", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Object getObject() {
        return object;
    }

    public SignedProperties getSignedProperties(){
        return this.object.getQualifyingProperties().getSignedProperties();
    }

    public void setSignedInfo(SignedInfo signedInfo) {
        this.signedInfo = signedInfo;
    }
    public void setSignatureValue(String signatureValue) {
        SignatureValue = DigestService.digest(signatureValue);
    }
    public void setKeyInfo(KeyInfo keyInfo) {
        this.keyInfo = keyInfo;
    }
    public void setObject(Object object) {
        this.object = object;
    }

    public void setReferenceToDigest(String documentReference) {
        this.signedInfo.setReference(documentReference);
    }
    public void setReferenceKeyInfoToDigest(String reference) {
        this.signedInfo.setReferenceKeyInfo(reference);
    }
    public void setReferenceKeySignedPropertiesToDigest(String reference) {
        this.signedInfo.setReferenceKeySignedProperties(reference);
    }
}
