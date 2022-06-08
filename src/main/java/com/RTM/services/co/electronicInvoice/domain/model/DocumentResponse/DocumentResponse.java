package com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.InvoiceDocumentReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"response","documentReference","lineResponse"})
public class DocumentResponse {
    private Response response;
    private InvoiceDocumentReference documentReference;
    private LineResponse lineResponse;

    public DocumentResponse() {}
    public DocumentResponse(Response response, InvoiceDocumentReference documentReference, LineResponse lineResponse) {
        this.response = response;
        this.documentReference = documentReference;
        this.lineResponse = lineResponse;
    }

    @XmlElement(name = "Response", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Response getResponse() {
        return response;
    }
    @XmlElement(name = "DocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public InvoiceDocumentReference getDocumentReference() {
        return documentReference;
    }
    @XmlElement(name = "LineResponse", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public LineResponse getLineResponse() {
        return lineResponse;
    }
}
