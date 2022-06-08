package com.RTM.services.co.electronicInvoice.domain.model.Payment;

import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"ID","chargeIndicator","allowanceChargeReasonCode","allowanceChargeReason","multiplierFactorNumeric","amount","baseAmount"})
public class AllowanceCharge {
    private String ID;
    private Boolean chargeIndicator;
    private String allowanceChargeReasonCode;
    private String allowanceChargeReason;
    private double multiplierFactorNumeric;
    private Money amount;
    private Money baseAmount;

    public AllowanceCharge() {}

    public AllowanceCharge(String ID, Boolean chargeIndicator, String allowanceChargeReasonCode, String allowanceChargeReason, double multiplierFactorNumeric, Money amount, Money baseAmount) {
        this.ID = ID;
        this.chargeIndicator = chargeIndicator;
        this.allowanceChargeReasonCode = allowanceChargeReasonCode;
        this.allowanceChargeReason = allowanceChargeReason;
        this.multiplierFactorNumeric = multiplierFactorNumeric;
        this.amount = amount;
        this.baseAmount = baseAmount;
    }
    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "ChargeIndicator", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Boolean getChargeIndicator() {
        return chargeIndicator;
    }
    @XmlElement(name = "AllowanceChargeReasonCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getAllowanceChargeReasonCode() {
        return allowanceChargeReasonCode;
    }
    @XmlElement(name = "AllowanceChargeReason", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getAllowanceChargeReason() {
        return allowanceChargeReason;
    }
    @XmlElement(name = "MultiplierFactorNumeric", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getMultiplierFactorNumeric() {
        return DataFormatService.setDoubleFormat(multiplierFactorNumeric);
    }
    @XmlElement(name = "Amount", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getAmount() {
        return amount;
    }
    @XmlElement(name = "BaseAmount", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getBaseAmount() {
        return baseAmount;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setChargeIndicator(Boolean chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
    }
    public void setAllowanceChargeReasonCode(String allowanceChargeReasonCode) {
        this.allowanceChargeReasonCode = allowanceChargeReasonCode;
    }
    public void setAllowanceChargeReason(String allowanceChargeReason) {
        this.allowanceChargeReason = allowanceChargeReason;
    }
    public void setMultiplierFactorNumeric(double multiplierFactorNumeric) {
        this.multiplierFactorNumeric = multiplierFactorNumeric;
    }
    public void setAmount(Money amount) {
        this.amount = amount;
    }
    public void setBaseAmount(Money baseAmount) {
        this.baseAmount = baseAmount;
    }
    public void setCurrencyCode(String currencyCode){
        this.amount.setCurrencyID(currencyCode);
        this.baseAmount.setCurrencyID(currencyCode);
    }
}
