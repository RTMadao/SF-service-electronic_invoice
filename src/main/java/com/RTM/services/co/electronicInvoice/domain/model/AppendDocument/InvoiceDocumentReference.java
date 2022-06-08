package com.RTM.services.co.electronicInvoice.domain.model.AppendDocument;

import com.RTM.services.co.electronicInvoice.domain.model.Attachment.Attachment;
import com.RTM.services.co.electronicInvoice.domain.model.Attachment.ResultOfVerification;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"ID","UUID","issueDate","documentTypeCode","attachment","resultOfVerification"})
public class InvoiceDocumentReference {
    private String ID;
    private AppendDocumentID UUID;
    private String IssueDate;
    private String documentTypeCode;
    private Attachment attachment;
    private ResultOfVerification resultOfVerification;

    public InvoiceDocumentReference() {}
    public InvoiceDocumentReference(String ID, String UUID, String issueDate) {
        this.ID = ID;
        this.UUID = new AppendDocumentID(UUID);
        IssueDate = issueDate;
    }
    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "UUID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public AppendDocumentID getUUID() {
        return UUID;
    }
    @XmlElement(name = "IssueDate", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueDate() {
        return IssueDate;
    }
    @XmlElement(name = "DocumentTypeCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getDocumentTypeCode() {
        return documentTypeCode;
    }
    @XmlElement(name = "Attachment", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Attachment getAttachment() {
        return attachment;
    }
    @XmlElement(name = "ResultOfVerification", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public ResultOfVerification getResultOfVerification() {
        return resultOfVerification;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setUUID(AppendDocumentID UUID) {
        this.UUID = UUID;
    }
    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }
    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
    public void setResultOfVerification(ResultOfVerification resultOfVerification) {
        this.resultOfVerification = resultOfVerification;
    }
}
