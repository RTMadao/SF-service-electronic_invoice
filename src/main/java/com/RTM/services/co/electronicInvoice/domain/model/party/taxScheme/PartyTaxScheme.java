package com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme;

import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.party.location.Location;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"registrationName","companyID","taxLevelCode","registrationAddress","taxScheme"})
public class PartyTaxScheme {
    private String registrationName;
    private ID companyID;
    private String taxLevelCode;
    private Location registrationAddress;
    private TaxScheme taxScheme;

    public PartyTaxScheme(String registrationName, ID companyID, String taxLevelCode, Location registrationAddress, TaxScheme taxScheme) {
        this.registrationName = registrationName;
        this.companyID = companyID;
        this.taxLevelCode = taxLevelCode;
        this.registrationAddress = registrationAddress;
        this.taxScheme = taxScheme;
    }

    public PartyTaxScheme() {}
    @XmlElement(name = "RegistrationName", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getRegistrationName() {
        return registrationName;
    }
    @XmlElement(name = "TaxLevelCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getTaxLevelCode() {
        return taxLevelCode;
    }
    @XmlElement(name = "RegistrationAddress", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Location getRegistrationAddress() {
        return registrationAddress;
    }
    @XmlElement(name = "TaxScheme", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public TaxScheme getTaxScheme() {
        return taxScheme;
    }
    @XmlElement(name = "CompanyID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public ID getCompanyID() {
        return companyID;
    }
    public void setCompanyID(ID companyID) {
        this.companyID = companyID;
    }
    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }
    public void setTaxLevelCode(String taxLevelCode) {
        this.taxLevelCode = taxLevelCode;
    }
    public void setRegistrationAddress(Location registrationAddress) {
        this.registrationAddress = registrationAddress;
    }
    public void setTaxScheme(TaxScheme taxScheme) {
        this.taxScheme = taxScheme;
    }
}
