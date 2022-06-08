package com.RTM.services.co.electronicInvoice.domain.model.party;

import com.RTM.services.co.electronicInvoice.domain.model.party.location.Address;

import javax.xml.bind.annotation.XmlElement;

public class Delivery {
    private Address deliveryAddress;
    private Party deliveryParty;

    public Delivery() {}
    @XmlElement(name = "DeliveryAddress", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    @XmlElement(name = "DeliveryParty", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Party getDeliveryParty() {
        return deliveryParty;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public void setDeliveryParty(Party deliveryParty) {
        this.deliveryParty = deliveryParty;
    }
}
