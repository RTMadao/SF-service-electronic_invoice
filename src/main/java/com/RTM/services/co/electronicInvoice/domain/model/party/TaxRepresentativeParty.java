package com.RTM.services.co.electronicInvoice.domain.model.party;

import com.RTM.services.co.electronicInvoice.domain.model.ID;

import javax.xml.bind.annotation.XmlElement;

public class TaxRepresentativeParty {
    private ID partyIdentification;

    public TaxRepresentativeParty() {
    }
    public TaxRepresentativeParty(ID partyIdentification) {
        this.partyIdentification = partyIdentification;
    }
    @XmlElement(name = "PartyIdentification", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public ID getPartyIdentification() {
        return partyIdentification;
    }

    public void setPartyIdentification(ID partyIdentification) {
        this.partyIdentification = partyIdentification;
    }
}
