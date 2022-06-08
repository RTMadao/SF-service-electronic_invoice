package com.RTM.services.co.electronicInvoice.domain.model.util;

public class ElectronicDocumentEmailInfo {
    private String documentType;
    private String filePath;
    private String fileName;
    private String customer;
    private String customerEmailContact;
    private String emailContact;

    public ElectronicDocumentEmailInfo() {}

    public ElectronicDocumentEmailInfo(String documentType, String filePath, String fileName, String customer, String customerEmailContact, String emailContact) {
        this.documentType = documentType;
        this.filePath = filePath;
        this.fileName = fileName;
        this.customer = customer;
        this.customerEmailContact = customerEmailContact;
        this.emailContact = emailContact;
    }

    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getCustomerEmailContact() {
        return customerEmailContact;
    }
    public void setCustomerEmailContact(String customerEmailContact) {
        this.customerEmailContact = customerEmailContact;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public String getEmailContact() {
        return emailContact;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
