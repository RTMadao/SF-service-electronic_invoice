package com.RTM.services.co.electronicInvoice.domain.model.productLine;

import javax.xml.bind.annotation.XmlElement;

public class PricingReference {
    private AlternativeConditionPrice alternativeConditionPrice;

    public PricingReference(AlternativeConditionPrice alternativeConditionPrice) {
        this.alternativeConditionPrice = alternativeConditionPrice;
    }

    public PricingReference() {}
    @XmlElement(name = "AlternativeConditionPrice", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AlternativeConditionPrice getAlternativeConditionPrice() {
        return alternativeConditionPrice;
    }

    public void setAlternativeConditionPrice(AlternativeConditionPrice alternativeConditionPrice) {
        this.alternativeConditionPrice = alternativeConditionPrice;
    }
}
