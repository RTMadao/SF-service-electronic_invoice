package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignerRole;

import javax.xml.bind.annotation.XmlElement;

public class SignerRole {
    private ClaimedRoles claimedRoles;
    public SignerRole() {this.claimedRoles = new ClaimedRoles();}
    @XmlElement(name = "ClaimedRoles", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public ClaimedRoles getClaimedRoles() {
        return claimedRoles;
    }
}
