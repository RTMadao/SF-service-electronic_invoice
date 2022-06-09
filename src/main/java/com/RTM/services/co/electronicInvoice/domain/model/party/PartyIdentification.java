package com.RTM.services.co.electronicInvoice.domain.model.party;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class PartyIdentification {
    private long id;
    private int schemeID;
    private int schemeName;

    public PartyIdentification() {}

    public PartyIdentification(long id, int schemeID, int schemeName) {
        this.id = id;
        this.schemeID = schemeID;
        this.schemeName = schemeName;
    }

    @XmlValue
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @XmlAttribute
    public int getSchemeID() {
        return schemeID;
    }
    public void setSchemeID(int schemeID) {
        this.schemeID = schemeID;
    }
    @XmlAttribute
    public int getSchemeName() {
        return schemeName;
    }
    public void setSchemeName(int schemeName) {
        this.schemeName = schemeName;
    }
}
