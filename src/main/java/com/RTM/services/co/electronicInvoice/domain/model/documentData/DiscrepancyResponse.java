package com.RTM.services.co.electronicInvoice.domain.model.documentData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"referenceID","responseCode","description"})
public class DiscrepancyResponse {
    private String referenceID;
    private String responseCode;
    private String description;

    public DiscrepancyResponse() {}

    public DiscrepancyResponse(String referenceID, String responseCode, String description) {
        this.referenceID = referenceID;
        this.responseCode = responseCode;
        this.description = description;
    }
    @XmlElement(name = "ReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getReferenceID() {
        return referenceID;
    }
    @XmlElement(name = "ResponseCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getResponseCode() {
        return responseCode;
    }
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getDescription() {
        return description;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
