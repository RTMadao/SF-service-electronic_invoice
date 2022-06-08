package com.RTM.services.co.electronicInvoice.domain.model.Terms;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"specialTerms","lossRiskResponsibilityCode","lossRisk"})
public class DeliveryTerms {
    private String SpecialTerms;
    private String LossRiskResponsibilityCode;
    private String LossRisk;

    public DeliveryTerms(){}
    @XmlElement(name = "SpecialTerms", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getSpecialTerms() {
        return SpecialTerms;
    }
    @XmlElement(name = "LossRiskResponsibilityCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getLossRiskResponsibilityCode() {
        return LossRiskResponsibilityCode;
    }
    @XmlElement(name = "LossRisk", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getLossRisk() {
        return LossRisk;
    }

    public void setSpecialTerms(String specialTerms) {
        SpecialTerms = specialTerms;
    }
    public void setLossRiskResponsibilityCode(String lossRiskResponsibilityCode) {
        LossRiskResponsibilityCode = lossRiskResponsibilityCode;
    }
    public void setLossRisk(String lossRisk) {
        LossRisk = lossRisk;
    }
}
