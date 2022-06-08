package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignaturePolicyIdentifier.SignaturePolicyIdentifier;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignerRole.SignerRole;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(propOrder={"signingTime","signingCertificate","signaturePolicyIdentifier","signerRole"})
public class SignedSignatureProperties {
    private Date SigningTime;
    private SigningCertificate signingCertificate;
    private SignaturePolicyIdentifier signaturePolicyIdentifier;
    private SignerRole signerRole;
    public SignedSignatureProperties(Date SigningTime) {
        this.SigningTime = SigningTime;
        this.signaturePolicyIdentifier = new SignaturePolicyIdentifier();
        this.signerRole = new SignerRole();
    }
    public SignedSignatureProperties() {}

    @XmlElement(name = "SigningTime", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public Date getSigningTime() {
        return SigningTime;
    }
    @XmlElement(name = "SigningCertificate", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public SigningCertificate getSigningCertificate() {
        return signingCertificate;
    }
    @XmlElement(name = "SignaturePolicyIdentifier", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public SignaturePolicyIdentifier getSignaturePolicyIdentifier() {
        return signaturePolicyIdentifier;
    }
    @XmlElement(name = "SignerRole", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public SignerRole getSignerRole() {
        return signerRole;
    }
    public void setSigningCertificate(SigningCertificate signingCertificate) {
        this.signingCertificate = signingCertificate;
    }
}
