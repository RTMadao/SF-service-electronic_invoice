package com.RTM.services.co.electronicInvoice.persistence.Entity;

import com.RTM.services.co.electronicInvoice.domain.service.DigestService;

public class SoftwareIdentifier {
    private int id;
    private String softwareId;
    private String softwarePin;
    private String technicalKey;

    public SoftwareIdentifier() {}

    public String getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(String softwareId) {
        this.softwareId = softwareId;
    }

    public String getSoftwarePin() {
        return softwarePin;
    }

    public void setSoftwarePin(String softwarePin) {
        this.softwarePin = softwarePin;
    }

    public String getTechnicalKey() {
        return technicalKey;
    }

    public void setTechnicalKey(String technicalKey) {
        this.technicalKey = technicalKey;
    }

    public String getSoftwareSecurityCode(String documentID){
        return DigestService.sha384(this.softwareId + this.softwarePin + documentID);
    }
}
