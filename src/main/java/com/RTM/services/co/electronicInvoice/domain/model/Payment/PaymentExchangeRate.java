package com.RTM.services.co.electronicInvoice.domain.model.Payment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(propOrder={"sourceCurrencyCode","sourceCurrencyBaseRate","targetCurrencyCode","targetCurrencyBaseRate","calculationRate","date"})
public class PaymentExchangeRate {
    private String SourceCurrencyCode;
    private final String SourceCurrencyBaseRate = "1.00";
    private String TargetCurrencyCode;
    private final String TargetCurrencyBaseRate = "1.00";
    private double calculationRate;
    private Date date;

    public PaymentExchangeRate() {}
    @XmlElement(name = "SourceCurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getSourceCurrencyCode() {
        return SourceCurrencyCode;
    }
    @XmlElement(name = "SourceCurrencyBaseRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getSourceCurrencyBaseRate() {
        return SourceCurrencyBaseRate;
    }
    @XmlElement(name = "TargetCurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getTargetCurrencyCode() {
        return TargetCurrencyCode;
    }
    @XmlElement(name = "TargetCurrencyBaseRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getTargetCurrencyBaseRate() {
        return TargetCurrencyBaseRate;
    }
    @XmlElement(name = "CalculationRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public double getCalculationRate() {
        return calculationRate;
    }
    @XmlElement(name = "Date", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Date getDate() {
        return date;
    }

    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        SourceCurrencyCode = sourceCurrencyCode;
    }
    public void setTargetCurrencyCode(String targetCurrencyCode) {
        TargetCurrencyCode = targetCurrencyCode;
    }
    public void setCalculationRate(double calculationRate) {
        this.calculationRate = calculationRate;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
