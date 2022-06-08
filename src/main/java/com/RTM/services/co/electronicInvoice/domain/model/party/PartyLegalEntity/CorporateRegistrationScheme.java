package com.RTM.services.co.electronicInvoice.domain.model.party.PartyLegalEntity;

import javax.xml.bind.annotation.XmlElement;

public class CorporateRegistrationScheme {
    private String ID;
    private String Name;
    public CorporateRegistrationScheme() {}

    public CorporateRegistrationScheme(String ID) {
        this.ID = ID;
    }

    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "Name", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getName() {
        return Name;
    }
}
