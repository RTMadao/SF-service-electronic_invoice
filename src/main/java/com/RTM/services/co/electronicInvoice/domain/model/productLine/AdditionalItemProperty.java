package com.RTM.services.co.electronicInvoice.domain.model.productLine;

import com.RTM.services.co.electronicInvoice.domain.model.Unit;

import javax.xml.bind.annotation.XmlElement;

public class AdditionalItemProperty {
    private String name;
    private String value;
    private Unit valueQuantity;

    public AdditionalItemProperty() {}
    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getName() {
        return name;
    }
    @XmlElement(name = "Value", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getValue() {
        return value;
    }
    @XmlElement(name = "ValueQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Unit getValueQuantity() {
        return valueQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setValueQuantity(Unit valueQuantity) {
        this.valueQuantity = valueQuantity;
    }
}
