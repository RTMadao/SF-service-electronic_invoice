package com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedInfo;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Algorithm;

import javax.xml.bind.annotation.XmlElement;

public class Transforms {
    private Algorithm Transform;
    public Transforms() {
        Transform = new Algorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
    }
    @XmlElement(name = "Transform", namespace="http://www.w3.org/2000/09/xmldsig#")
    public Algorithm getTransform() {
        return Transform;
    }
}
