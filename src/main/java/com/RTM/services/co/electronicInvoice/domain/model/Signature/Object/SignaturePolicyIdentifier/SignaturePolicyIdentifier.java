package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignaturePolicyIdentifier;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Digest;

import javax.xml.bind.annotation.XmlElement;

public class SignaturePolicyIdentifier {
    private SignaturePolicyId signaturePolicyId;
    public SignaturePolicyIdentifier() {
        signaturePolicyId = new SignaturePolicyId();
    }
    @XmlElement(name = "SignaturePolicyId", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public SignaturePolicyId getSignaturePolicyId() {
        return signaturePolicyId;
    }
}
