package com.RTM.services.co.electronicInvoice.domain.model.party.location;

import javax.xml.bind.annotation.XmlElement;

public class Location {
    private Address address;
    public Location() {}
    public Location(Address address) {
        this.address = address;
    }
    @XmlElement(name = "Address", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
