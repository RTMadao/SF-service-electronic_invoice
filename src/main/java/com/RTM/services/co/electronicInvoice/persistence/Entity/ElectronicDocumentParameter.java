package com.RTM.services.co.electronicInvoice.persistence.Entity;

import java.util.Date;

public class ElectronicDocumentParameter {
    private int id;
    private String invoiceAuthorization;
    private Date authorizationPeriodStartDate;
    private Date authorizationPeriodEndDate;
    private String authorizedInvoicesPrefix;
    private int authorizedInvoicesFrom;
    private int authorizedInvoicesTo;
    private int creditNoteIdLastUsed;
    private int debitNoteIdLastUsed;
    private int applicationIdResponseLastUsed;
    private int attachedDocumentIdLastUsed;

    public ElectronicDocumentParameter() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceAuthorization() {
        return invoiceAuthorization;
    }

    public void setInvoiceAuthorization(String invoiceAuthorization) {
        this.invoiceAuthorization = invoiceAuthorization;
    }

    public Date getAuthorizationPeriodStartDate() {
        return authorizationPeriodStartDate;
    }

    public void setAuthorizationPeriodStartDate(Date authorizationPeriodStartDate) {
        this.authorizationPeriodStartDate = authorizationPeriodStartDate;
    }

    public Date getAuthorizationPeriodEndDate() {
        return authorizationPeriodEndDate;
    }

    public void setAuthorizationPeriodEndDate(Date authorizationPeriodEndDate) {
        this.authorizationPeriodEndDate = authorizationPeriodEndDate;
    }

    public String getAuthorizedInvoicesPrefix() {
        return authorizedInvoicesPrefix;
    }

    public void setAuthorizedInvoicesPrefix(String authorizedInvoicesPrefix) {
        this.authorizedInvoicesPrefix = authorizedInvoicesPrefix;
    }

    public int getAuthorizedInvoicesFrom() {
        return authorizedInvoicesFrom;
    }

    public void setAuthorizedInvoicesFrom(int authorizedInvoicesFrom) {
        this.authorizedInvoicesFrom = authorizedInvoicesFrom;
    }

    public int getAuthorizedInvoicesTo() {
        return authorizedInvoicesTo;
    }

    public void setAuthorizedInvoicesTo(int authorizedInvoicesTo) {
        this.authorizedInvoicesTo = authorizedInvoicesTo;
    }

    public int getCreditNoteIdLastUsed() {
        return creditNoteIdLastUsed;
    }

    public void setCreditNoteIdLastUsed(int creditNoteIdLastUsed) {
        this.creditNoteIdLastUsed = creditNoteIdLastUsed;
    }

    public int getDebitNoteIdLastUsed() {
        return debitNoteIdLastUsed;
    }

    public void setDebitNoteIdLastUsed(int debitNoteIdLastUsed) {
        this.debitNoteIdLastUsed = debitNoteIdLastUsed;
    }

    public int getApplicationIdResponseLastUsed() {
        return applicationIdResponseLastUsed;
    }

    public void setApplicationIdResponseLastUsed(int applicationIdResponseLastUsed) {
        this.applicationIdResponseLastUsed = applicationIdResponseLastUsed;
    }

    public int getAttachedDocumentIdLastUsed() {
        return attachedDocumentIdLastUsed;
    }

    public void setAttachedDocumentIdLastUsed(int attachedDocumentIdLastUsed) {
        this.attachedDocumentIdLastUsed = attachedDocumentIdLastUsed;
    }
}
