package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignaturePolicyIdentifier;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Digest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"signaturePolicyId","sigPolicyHash"})
public class SignaturePolicyId {
    private SigPolicyId signaturePolicyId;
    private Digest sigPolicyHash;
    public SignaturePolicyId() {
        signaturePolicyId = new SigPolicyId();
        sigPolicyHash = new Digest("http://www.w3.org/2001/04/xmldsig‐more#rsa‐sha256");
        sigPolicyHash.setDigestValue(signaturePolicyId.getIdentifier());
    }
    @XmlElement(name = "SigPolicyId", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public SigPolicyId getSignaturePolicyId() {
        return signaturePolicyId;
    }
    @XmlElement(name = "SigPolicyHash", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public Digest getSigPolicyHash() {
        return sigPolicyHash;
    }
}
