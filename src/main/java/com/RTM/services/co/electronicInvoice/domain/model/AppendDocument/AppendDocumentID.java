package com.RTM.services.co.electronicInvoice.domain.model.AppendDocument;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class AppendDocumentID {
    private String ID;
    private String schemeName;

    public AppendDocumentID() {}
    public AppendDocumentID(String ID) {
        this.ID = ID;
        schemeName = "CUFE-SHA384";
    }
    @XmlValue
    public String getID() {
        return ID;
    }
    @XmlAttribute
    public String getSchemeName() {
        return schemeName;
    }
}
