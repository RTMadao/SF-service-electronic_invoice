package com.RTM.services.co.electronicInvoice.domain.model.party;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"name","telephone","telefax","electronicMail","note"})
public class Contact {
    private String name;
    private String telephone;
    private String telefax;
    private String electronicMail;
    private String note;

    public Contact(String name, String telephone, String telefax, String electronicMail, String note) {
        this.name = name;
        this.telephone = telephone;
        this.telefax = telefax;
        this.electronicMail = electronicMail;
        this.note = note;
    }

    public Contact() {}
    @XmlElement(name = "Name", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getName() {
        return name;
    }
    @XmlElement(name = "Telephone", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getTelephone() {
        return telephone;
    }
    @XmlElement(name = "Telefax", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getTelefax() {
        return telefax;
    }
    @XmlElement(name = "ElectronicMail", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getElectronicMail() {
        return electronicMail;
    }
    @XmlElement(name = "Note", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getNote() {
        return note;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }
    public void setElectronicMail(String electronicMail) {
        this.electronicMail = electronicMail;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
