package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedSignatureProperties;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Digest;

import javax.xml.bind.annotation.XmlElement;

public class Cert {
    private Digest digest;
    private IssuerSerial issuerSerial;
    public Cert(String x509IssuerName, String x509SerialNumber, String cert) {
        this.digest = new Digest("http://www.w3.org/2001/04/xmldsig‐more#rsa‐sha256");
        this.issuerSerial = new IssuerSerial(x509IssuerName,x509SerialNumber);
        this.digest.setDigestValue(cert);
    }
    public Cert() {}

    @XmlElement(name = "CertDigest", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public Digest getCertDigest() {
        return digest;
    }
    @XmlElement(name = "IssuerSerial", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public IssuerSerial getIssuerSerial(){ return  issuerSerial; }
}
