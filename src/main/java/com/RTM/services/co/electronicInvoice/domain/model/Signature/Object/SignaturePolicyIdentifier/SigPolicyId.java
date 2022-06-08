package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignaturePolicyIdentifier;

import javax.xml.bind.annotation.XmlElement;

public class SigPolicyId {
    private String identifier;
    public SigPolicyId() {
        this.identifier = "https://facturaelectronica.dian.gov.co/politicadefirma/v1/politicadefirmav2.pdf";
    }
    @XmlElement(name = "Identifier", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public String getIdentifier() {
        return identifier;
    }
}
