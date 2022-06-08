package com.RTM.services.co.electronicInvoice.domain.model.Payment;

import javax.xml.bind.annotation.XmlElement;

public class LegalMonetaryTotal {
    private Money lineExtensionAmount;
    private Money taxExclusiveAmount;
    private Money taxInclusiveAmount;
    private Money allowanceTotalAmount;
    private Money chargeTotalAmount;
    private Money prePaidAmount;
    private Money payableAmount;

    public LegalMonetaryTotal(Money lineExtensionAmount, Money taxExclusiveAmount, Money taxInclusiveAmount, Money allowanceTotalAmount, Money chargeTotalAmount, Money prePaidAmount, Money payableAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
        this.taxExclusiveAmount = taxExclusiveAmount;
        this.taxInclusiveAmount = taxInclusiveAmount;
        this.allowanceTotalAmount = allowanceTotalAmount;
        this.chargeTotalAmount = chargeTotalAmount;
        this.prePaidAmount = prePaidAmount;
        this.payableAmount = payableAmount;
    }

    public LegalMonetaryTotal() {}
    @XmlElement(name = "LineExtensionAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getLineExtensionAmount() {
        return lineExtensionAmount;
    }
    @XmlElement(name = "TaxExclusiveAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getTaxExclusiveAmount() {
        return taxExclusiveAmount;
    }
    @XmlElement(name = "TaxInclusiveAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }
    @XmlElement(name = "AllowanceTotalAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }
    @XmlElement(name = "ChargeTotalAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getChargeTotalAmount() {
        return chargeTotalAmount;
    }
    @XmlElement(name = "PrePaidAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getPrePaidAmount() {
        return prePaidAmount;
    }
    @XmlElement(name = "PayableAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getPayableAmount() {
        return payableAmount;
    }

    public void setLineExtensionAmount(Money lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }
    public void setTaxExclusiveAmount(Money taxExclusiveAmount) {
        this.taxExclusiveAmount = taxExclusiveAmount;
    }
    public void setTaxInclusiveAmount(Money taxInclusiveAmount) {
        this.taxInclusiveAmount = taxInclusiveAmount;
    }
    public void setAllowanceTotalAmount(Money allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }
    public void setChargeTotalAmount(Money chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }
    public void setPrePaidAmount(Money prePaidAmount) {
        this.prePaidAmount = prePaidAmount;
    }
    public void setPayableAmount(Money payableAmount) {
        this.payableAmount = payableAmount;
    }
    public void setCurrencyCode(String currencyCode){
        this.lineExtensionAmount.setCurrencyID(currencyCode);
        this.taxExclusiveAmount.setCurrencyID(currencyCode);
        this.taxInclusiveAmount.setCurrencyID(currencyCode);
        this.allowanceTotalAmount.setCurrencyID(currencyCode);
        this.chargeTotalAmount.setCurrencyID(currencyCode);
        this.prePaidAmount.setCurrencyID(currencyCode);
        this.payableAmount.setCurrencyID(currencyCode);
    }
    public void setPaidAmount(double lineExtensionAmount, double taxExclusiveAmount, double taxInclusiveAmount, double allowanceTotalAmount, double chargeTotalAmount, double prePaidAmount, double payableAmount){
        this.lineExtensionAmount.setPaidAmount(lineExtensionAmount);
        this.taxExclusiveAmount.setPaidAmount(taxExclusiveAmount);
        this.taxInclusiveAmount.setPaidAmount(taxInclusiveAmount);
        this.allowanceTotalAmount.setPaidAmount(allowanceTotalAmount);
        this.chargeTotalAmount.setPaidAmount(chargeTotalAmount);
        this.prePaidAmount.setPaidAmount(prePaidAmount);
        this.payableAmount.setPaidAmount(payableAmount);
    }
}
