package com.RTM.services.co.electronicInvoice.domain.model.Attachment;

import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(propOrder={"validatorID","validationResultCode","validationDate","validationTime"})
public class ResultOfVerification {
    private String validatorID;
    private String validationResultCode;
    private String validationDate;
    private String validationTime;

    public ResultOfVerification() {
        this.validatorID = "Unidad Especial Dirección de Impuestos y Aduanas Nacionales";
    }
    public ResultOfVerification(String validationResultCode, Date validationDateTime) {
        this.validatorID = "Unidad Especial Dirección de Impuestos y Aduanas Nacionales";
        this.validationResultCode = validationResultCode;
        this.validationDate = DataFormatService.setDateFormat(validationDateTime);
        this.validationTime = DataFormatService.setTimeFormat(validationDateTime);
    }

    @XmlElement(name = "ValidatorID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getValidatorID() {
        return validatorID;
    }
    @XmlElement(name = "ValidationResultCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getValidationResultCode() {
        return validationResultCode;
    }
    @XmlElement(name = "ValidationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getValidationDate() {
        return validationDate;
    }
    @XmlElement(name = "ValidationTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getValidationTime() {
        return validationTime;
    }

    public void setValidatorID(String validatorID) {
        this.validatorID = validatorID;
    }
    public void setValidationResultCode(String validationResultCode) {
        this.validationResultCode = validationResultCode;
    }
    public void setValidationDate(String validationDate) {
        this.validationDate = validationDate;
    }
    public void setValidationTime(String validationTime) {
        this.validationTime = validationTime;
    }
}
