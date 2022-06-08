package com.RTM.services.co.electronicInvoice.domain.model.party.location;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class ContryName {
    private String name;
    private String languageID;

    public ContryName(String name, String languageID) {
        this.name = name;
        this.languageID = languageID;
    }

    public ContryName() {}
    @XmlValue
    public String getName() {
        return name;
    }
    @XmlAttribute
    public String getLanguageID() {
        return languageID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }
}
