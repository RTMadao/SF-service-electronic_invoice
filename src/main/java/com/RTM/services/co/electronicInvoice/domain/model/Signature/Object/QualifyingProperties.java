package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties.SigningCertificate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class QualifyingProperties {
    private SignedProperties signedProperties;
    private String target;
    public QualifyingProperties(Date SigningTime, String UUID) {
        this.signedProperties = new SignedProperties(SigningTime);
        this.target = "#xmldsig-"+UUID;
    }
    public QualifyingProperties() {this.target = "#xmldsig-UUID";}

    @XmlElement(name = "SignedProperties", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public SignedProperties getSignedProperties() {
        return signedProperties;
    }
    @XmlAttribute(name = "Target")
    public String getTarget() {
        return target;
    }
    public void setTarget(String UUID) {
        this.target = this.target.replace("UUID",UUID);
    }
    public void setSigningCertificate(SigningCertificate signingCertificate) {
        this.getSignedProperties().getSignedSignatureProperties().setSigningCertificate(signingCertificate);
    }
}
