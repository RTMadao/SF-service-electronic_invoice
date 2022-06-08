package com.RTM.services.co.electronicInvoice.domain.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Unit {
    private int value;
    private String unitCode;
    private String unitCodeName;

    public Unit() {}

    public Unit(int value, String unitCode) {
        this.value = value;
        this.unitCode = unitCode;
    }
    public Unit(int value, String unitCode, String unitCodeName) {
        this.value = value;
        this.unitCode = unitCode;
        this.unitCodeName = unitCodeName;
    }

    @XmlValue
    public int getValue() {
        return value;
    }
    @XmlAttribute
    public String getUnitCode() {
        return unitCode;
    }
    public String getUnitCodeName() {
        return unitCodeName;
    }
}
