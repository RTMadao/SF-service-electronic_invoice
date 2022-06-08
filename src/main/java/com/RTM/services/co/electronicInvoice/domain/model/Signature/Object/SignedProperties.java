package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.SignedSignatureProperties;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class SignedProperties {
    private SignedSignatureProperties signedSignatureProperties;
    public SignedProperties(){}
    public SignedProperties(Date SigningTime) {
        signedSignatureProperties = new SignedSignatureProperties(SigningTime);
    }
    public SignedProperties(SignedProperties signedProperties){
        this.signedSignatureProperties = signedProperties.getSignedSignatureProperties();
    }
    @XmlElement(name = "SignedSignatureProperties", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public SignedSignatureProperties getSignedSignatureProperties() {
        return signedSignatureProperties;
    }
}
