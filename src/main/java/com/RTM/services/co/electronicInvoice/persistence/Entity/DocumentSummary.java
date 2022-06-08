package com.RTM.services.co.electronicInvoice.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "document_summary")
public class DocumentSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String documentType;
    private String documentId;
    private String issueDate;
    private String accountingCustomerPartyId;
    private String accountingCustomerPartyName;
    private String total;
    private int state;
    private String fileXmlName;
    private String filePdfName;
    private String documentCude;

    public DocumentSummary() {}
    public DocumentSummary(String documentType, String documentId, String issueDate, String accountingCustomerPartyId, String accountingCustomerPartyName, String total, int state, String fileXmlName, String filePdfName, String documentCude) {
        this.documentType = documentType;
        this.documentId = documentId;
        this.issueDate = issueDate;
        this.accountingCustomerPartyId = accountingCustomerPartyId;
        this.accountingCustomerPartyName = accountingCustomerPartyName;
        this.total = total;
        this.state = state;
        this.fileXmlName = fileXmlName;
        this.filePdfName = filePdfName;
        this.documentCude = documentCude;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public String getDocumentCude() {
        return documentCude;
    }
    public String getFileXmlName() {
        return fileXmlName;
    }
    public String getFilePdfName() {
        return filePdfName;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getAccountingCustomerPartyID() {
        return accountingCustomerPartyId;
    }
    public void setAccountingCustomerPartyID(String accountingCustomerPartyID) {
        this.accountingCustomerPartyId = accountingCustomerPartyID;
    }
    public String getAccountingCustomerPartyName() {
        return accountingCustomerPartyName;
    }
    public void setAccountingCustomerPartyName(String accountingCustomerPartyName) {
        this.accountingCustomerPartyName = accountingCustomerPartyName;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void setDocumentCude(String documentCude) {
        this.documentCude = documentCude;
    }
    public void setFileXmlName(String fileXmlName) {
        this.fileXmlName = fileXmlName;
    }
    public void setFilePdfName(String filePdfName) {
        this.filePdfName = filePdfName;
    }
}
