package com.RTM.services.co.electronicInvoice.domain.model.Attachment;

import com.RTM.services.co.electronicInvoice.domain.model.util.CDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"mimeCode","encodingCode","description"})
public class ExternalReference {
    private String mimeCode;
    private String encodingCode;
    private CDATA description;

    public ExternalReference() {
        this.mimeCode = "text/xml";
        this.encodingCode = "UTF‐8";
    }
    public ExternalReference(String description) {
        this.description = new CDATA(description);
        this.mimeCode = "text/xml";
        this.encodingCode = "UTF‐8";
    }
    @XmlElement(name = "MimeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getMimeCode() {
        return mimeCode;
    }
    @XmlElement(name = "EncodingCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getEncodingCode() {
        return encodingCode;
    }
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public CDATA getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public void setDescription(CDATA description) {
        this.description = description;
    }
}
