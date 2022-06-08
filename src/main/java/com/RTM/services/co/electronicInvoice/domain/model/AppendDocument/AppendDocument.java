package com.RTM.services.co.electronicInvoice.domain.model.AppendDocument;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class AppendDocument {
    private String ID;
    private Date issueDate;
    private String documentTypeCode;

    public AppendDocument() {}
    public AppendDocument(String ID, Date issueDate) {
        this.ID = ID;
        this.issueDate = issueDate;
    }

    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "IssueDate", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Date getIssueDate() {
        return issueDate;
    }
    @XmlElement(name = "DocumentTypeCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }
}
