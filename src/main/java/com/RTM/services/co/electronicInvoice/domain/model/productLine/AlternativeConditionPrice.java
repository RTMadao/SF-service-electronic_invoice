package com.RTM.services.co.electronicInvoice.domain.model.productLine;

import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;

import javax.xml.bind.annotation.XmlElement;

public class AlternativeConditionPrice {
    private Money priceAmount;
    private String priceTypeCode;

    public AlternativeConditionPrice(Money priceAmount) {
        this.priceAmount = priceAmount;
        this.priceTypeCode = "01";
    }

    public AlternativeConditionPrice() {
        this.priceTypeCode = "01";
    }
    @XmlElement(name = "PriceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getPriceAmount() {
        return priceAmount;
    }
    @XmlElement(name = "PriceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public String getPriceTypeCode() {
        return priceTypeCode;
    }
    public void setPriceAmount(Money priceAmount) {
        this.priceAmount = priceAmount;
    }
    public void setPriceTypeCode(String priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }
}
