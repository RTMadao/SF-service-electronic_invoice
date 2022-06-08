package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"certificate","issuingCertificate","rootCertificate"})
public class SigningCertificate {
    private Cert certificate;
    private Cert issuingCertificate;
    private Cert rootCertificate;
    public SigningCertificate() {}
    @XmlElement(name = "Cert", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public Cert getCertificate() {
        return certificate;
    }
    @XmlElement(name = "Cert", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public Cert getIssuingCertificate() {
        return issuingCertificate;
    }
    @XmlElement(name = "Cert", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public Cert getRootCertificate() {
        return rootCertificate;
    }

    public void setCertificate(Cert certificate) {
        this.certificate = certificate;
    }

    public void setIssuingCertificate(Cert issuingCertificate) {
        this.issuingCertificate = issuingCertificate;
    }

    public void setRootCertificate(Cert rootCertificate) {
        this.rootCertificate = rootCertificate;
    }
}
