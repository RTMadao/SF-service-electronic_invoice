package com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class LineResponse {
    private LineReference lineReference;
    private List<Response> response;

    public LineResponse() {}
    public LineResponse(LineReference lineReference, List<Response> response) {
        this.lineReference = lineReference;
        this.response = response;
    }

    @XmlElement(name = "LineReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public LineReference getLineReference() {
        return lineReference;
    }
    @XmlElement(name = "Response", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<Response> getResponse() {
        return response;
    }

    public void setLineReference(LineReference lineReference) {
        this.lineReference = lineReference;
    }
    public void setResponse(List<Response> response) {
        this.response = response;
    }
}
