package com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"responseCode","description"})
public class Response {
    private String responseCode;
    private String description;

    public Response() {}
    public Response(String responseCode, String description) {
        this.responseCode = responseCode;
        this.description = description;
    }

    @XmlElement(name = "ResponseCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getResponseCode() {
        return responseCode;
    }
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getDescription() {
        return description;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
