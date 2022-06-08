package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignerRole;

import javax.xml.bind.annotation.XmlElement;

public class ClaimedRoles {
    private String value;
    public ClaimedRoles() {this.value="supplier";}
    @XmlElement(name = "ClaimedRole", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public String getValue() {
        return value;
    }
}
