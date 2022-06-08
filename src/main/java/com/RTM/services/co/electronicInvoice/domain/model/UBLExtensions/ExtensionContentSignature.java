package com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Signature;

import javax.xml.bind.annotation.XmlElement;

public class ExtensionContentSignature {
    private Signature signature;

    public ExtensionContentSignature() {}

    public ExtensionContentSignature(Signature signature) {
        this.signature = signature;
    }

    @XmlElement(name = "Signature", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Signature getExtensions() {
        return signature;
    }
    public void setSignature(Signature signature) {
        this.signature = signature;
    }
}
