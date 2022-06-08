package com.RTM.services.co.electronicInvoice.domain.model.Payment.tax;

import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class TaxTotal {
    private Money taxAmount;
    private Money roundingAmount;
    private List<TaxSubtotal> taxSubtotal;

    public TaxTotal() {}

    public TaxTotal(Money taxAmount, Money roundingAmount, List<TaxSubtotal> taxSubtotal) {
        this.taxAmount = taxAmount;
        this.roundingAmount = roundingAmount;
        this.taxSubtotal = taxSubtotal;
    }
    @XmlElement(name = "TaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getTaxAmount() {
        return taxAmount;
    }
    @XmlElement(name = "RoundingAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getRoundingAmount() {
        return roundingAmount;
    }
    @XmlElement(name = "TaxSubtotal", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public List<TaxSubtotal> getTaxSubtotal() {
        return taxSubtotal;
    }

    public void setTaxAmount(Money taxAmount) {
        this.taxAmount = taxAmount;
    }
    public void setRoundingAmount(Money roundingAmount) {
        this.roundingAmount = roundingAmount;
    }
    public void setTaxSubtotal(List<TaxSubtotal> taxSubtotal) {
        this.taxSubtotal = taxSubtotal;
    }
    public void setCurrencyCode(String currencyCode) {
        this.taxAmount.setCurrencyID(currencyCode);
        this.roundingAmount.setCurrencyID(currencyCode);
        this.taxSubtotal.forEach(taxSubtotalItem -> taxSubtotalItem.setCurrencyCode(currencyCode));
    }
    public String getTaxLabel(){
        return this.taxSubtotal.get(0).getTaxCategory().getTaxScheme().getID();
    }
}
