package com.RTM.services.co.electronicInvoice.domain.model.Payment;

import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Money {
    private double paidAmount;
    private String currencyID;

    public Money() {}

    public Money(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Money(double paidAmount, String currencyID) {
        this.paidAmount = paidAmount;
        this.currencyID = currencyID;
    }
    @XmlValue
    public String getPaidAmount() {
        return DataFormatService.setDoubleFormat(paidAmount);
    }
    @XmlAttribute
    public String getCurrencyID() {
        return currencyID;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }
    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }
}
