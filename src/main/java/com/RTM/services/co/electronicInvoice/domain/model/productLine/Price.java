package com.RTM.services.co.electronicInvoice.domain.model.productLine;

import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;
import com.RTM.services.co.electronicInvoice.domain.model.Unit;

import javax.xml.bind.annotation.XmlElement;

public class Price {
    private Money priceAmount;
    private Unit baseQuantity;

    public Price(Money priceAmount, Unit baseQuantity) {
        this.priceAmount = priceAmount;
        this.baseQuantity = baseQuantity;
    }

    public Price() {}
    @XmlElement(name = "PriceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getPriceAmount() {
        return priceAmount;
    }
    @XmlElement(name = "BaseQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Unit getBaseQuantity() {
        return baseQuantity;
    }

    public void setPriceAmount(Money priceAmount) {
        this.priceAmount = priceAmount;
    }
    public void setBaseQuantity(Unit baseQuantity) {
        this.baseQuantity = baseQuantity;
    }
}
