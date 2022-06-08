package com.RTM.services.co.electronicInvoice.domain.model.party;

import com.RTM.services.co.electronicInvoice.domain.model.party.PartyLegalEntity.PartyLegalEntity;
import com.RTM.services.co.electronicInvoice.domain.model.party.location.Location;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlType(propOrder={"industryClasificationCode","partyName","physicalLocation","partyTaxScheme","partyLegalEntity","contact"})
public class Party {
    private String industryClasificationCode;
    private String partyName;
    private Location physicalLocation;
    private PartyTaxScheme partyTaxScheme;
    private PartyLegalEntity partyLegalEntity;
    private Contact contact;

    public Party() {}

    public Party(String industryClasificationCode, String partyName, Location physicalLocation, PartyTaxScheme partyTaxScheme, PartyLegalEntity partyLegalEntity, Contact contact) {
        this.industryClasificationCode = industryClasificationCode;
        this.partyName = partyName;
        this.physicalLocation = physicalLocation;
        this.partyTaxScheme = partyTaxScheme;
        this.partyLegalEntity = partyLegalEntity;
        this.contact = contact;
    }

    @XmlElement(name = "IndustryClasificationCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public String getIndustryClasificationCode() {
        return industryClasificationCode;
    }
    @XmlElement(name = "PartyName", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public String getPartyName() {
        return partyName;
    }
    @XmlElement(name = "PhysicalLocation", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Location getPhysicalLocation() {
        return physicalLocation;
    }
    @XmlElement(name = "PartyTaxScheme", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public PartyTaxScheme getPartyTaxScheme() {
        return partyTaxScheme;
    }
    @XmlElement(name = "PartyLegalEntity", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }
    @XmlElement(name = "Contact", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Contact getContact() {
        return contact;
    }

    public void setIndustryClasificationCode(String industryClasificationCode) {
        this.industryClasificationCode = industryClasificationCode;
    }
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
    public void setPhysicalLocation(Location physicalLocation) {
        this.physicalLocation = physicalLocation;
    }
    public void setPartyTaxScheme(PartyTaxScheme partyTaxScheme) {
        this.partyTaxScheme = partyTaxScheme;
    }
    public void setPartyLegalEntity(PartyLegalEntity partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
}