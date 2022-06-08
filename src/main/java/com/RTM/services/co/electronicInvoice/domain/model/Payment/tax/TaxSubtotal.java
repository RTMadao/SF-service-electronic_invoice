package com.RTM.services.co.electronicInvoice.domain.model.Payment.tax;

import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;
import com.RTM.services.co.electronicInvoice.domain.model.Unit;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"taxableAmount","taxAmount","baseUnitMeasure","perUnitAmount","taxCategory"})
public class TaxSubtotal {
    private Money taxableAmount;
    private Money taxAmount;
    private Unit baseUnitMeasure;
    private Money perUnitAmount;
    private TaxCategory taxCategory;

    public TaxSubtotal() {}

    public TaxSubtotal(Money taxableAmount, Money taxAmount, Unit baseUnitMeasure, Money perUnitAmount, TaxCategory taxCategory) {
        this.taxableAmount = taxableAmount;
        this.taxAmount = taxAmount;
        this.baseUnitMeasure = baseUnitMeasure;
        this.perUnitAmount = perUnitAmount;
        this.taxCategory = taxCategory;
    }
    @XmlElement(name = "TaxableAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getTaxableAmount() {
        return taxableAmount;
    }
    @XmlElement(name = "TaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getTaxAmount() {
        return taxAmount;
    }
    @XmlElement(name = "BaseUnitMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Unit getBaseUnitMeasure() {
        return baseUnitMeasure;
    }
    @XmlElement(name = "PerUnitAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getPerUnitAmount() {
        return perUnitAmount;
    }
    @XmlElement(name = "TaxCategory", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public void setTaxableAmount(Money taxableAmount) {
        this.taxableAmount = taxableAmount;
    }
    public void setTaxAmount(Money taxAmount) {
        this.taxAmount = taxAmount;
    }
    public void setBaseUnitMeasure(Unit baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }
    public void setPerUnitAmount(Money perUnitAmount) {
        this.perUnitAmount = perUnitAmount;
    }
    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }
    public void setCurrencyCode(String currencyCode) {
        this.taxableAmount.setCurrencyID(currencyCode);
        this.taxAmount.setCurrencyID(currencyCode);
        this.perUnitAmount.setCurrencyID(currencyCode);
    }
}
