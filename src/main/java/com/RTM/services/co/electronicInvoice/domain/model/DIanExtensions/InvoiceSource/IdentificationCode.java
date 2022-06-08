package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class IdentificationCode {

    private String codigo;
    private int listAgencyID;
    private String listAgencyName;
    private String listSchemeURI;

    public IdentificationCode() {}
    public IdentificationCode(String codigo, int listAgencyID, String listAgencyName, String listSchemeURI) {
        this.codigo = codigo;
        this.listAgencyID = listAgencyID;
        this.listAgencyName = listAgencyName;
        this.listSchemeURI = listSchemeURI;
    }

    @XmlValue
    public String getCodigo() {
        return codigo;
    }


    @XmlAttribute
    public int getListAgencyID() {
        return listAgencyID;
    }

    @XmlAttribute
    public String getListAgencyName() {
        return listAgencyName;
    }

    @XmlAttribute
    public String getListSchemeURI() {
        return listSchemeURI;
    }
}
