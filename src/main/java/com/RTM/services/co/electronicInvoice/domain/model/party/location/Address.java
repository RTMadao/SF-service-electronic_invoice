package com.RTM.services.co.electronicInvoice.domain.model.party.location;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"ID","cityName","postalZone","countrySubentity","countrySubentityCode","addressLine","country"})
public class Address {
    private String ID;
    private String cityName;
    private String postalZone;
    private String countrySubentity;
    private String countrySubentityCode;
    private AddressLine addressLine;
    private Contry country;
    public Address() {}
    public Address(String ID, String cityName, String postalZone, String countrySubentity, String countrySubentityCode, AddressLine addressLine, Contry country) {
        this.ID = ID;
        this.cityName = cityName;
        this.postalZone = postalZone;
        this.countrySubentity = countrySubentity;
        this.countrySubentityCode = countrySubentityCode;
        this.addressLine = addressLine;
        this.country = country;
    }
    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "CityName", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getCityName() {
        return cityName;
    }
    @XmlElement(name = "PostalZone", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getPostalZone() {
        return postalZone;
    }
    @XmlElement(name = "CountrySubentity", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getCountrySubentity() {
        return countrySubentity;
    }
    @XmlElement(name = "CountrySubentityCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getCountrySubentityCode() {
        return countrySubentityCode;
    }
    @XmlElement(name = "AddressLine", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AddressLine getAddressLine() {
        return addressLine;
    }
    @XmlElement(name = "Country", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Contry getCountry() {
        return country;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public void setPostalZone(String postalZone) {
        this.postalZone = postalZone;
    }
    public void setCountrySubentity(String countrySubentity) {
        this.countrySubentity = countrySubentity;
    }
    public void setCountrySubentityCode(String countrySubentityCode) {
        this.countrySubentityCode = countrySubentityCode;
    }
    public void setAddressLine(AddressLine addressLine) {
        this.addressLine = addressLine;
    }
    public void setCountry(Contry country) {
        this.country = country;
    }
}
