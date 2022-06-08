package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl;

import com.RTM.services.co.electronicInvoice.domain.model.DateRange;

import javax.xml.bind.annotation.*;

@XmlType(propOrder={"invoiceAuthorization","authorizationPeriod","authorizedInvoices"})
public class InvoiceControl {

    private String InvoiceAuthorization;
    private DateRange AuthorizationPeriod;
    private AuthorizedInvoices authorizedInvoices;

    public InvoiceControl() {}

    public InvoiceControl(String invoiceAuthorization, DateRange authorizationPeriod, AuthorizedInvoices authorizedInvoices) {
        InvoiceAuthorization = invoiceAuthorization;
        AuthorizationPeriod = authorizationPeriod;
        this.authorizedInvoices = authorizedInvoices;
    }

    @XmlElement(name = "InvoiceAuthorization", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public String getInvoiceAuthorization() {
        return InvoiceAuthorization;
    }

    public void setInvoiceAuthorization(String invoiceAuthorization) {
        InvoiceAuthorization = invoiceAuthorization;
    }

    @XmlElement(name = "AuthorizationPeriod", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public DateRange getAuthorizationPeriod() {
        return AuthorizationPeriod;
    }

    public void setAuthorizationPeriod(DateRange authorizationPeriod) {
        AuthorizationPeriod = authorizationPeriod;
    }

    @XmlElement(name = "AuthorizedInvoices", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public AuthorizedInvoices getAuthorizedInvoices() {
        return authorizedInvoices;
    }

    public void setAuthorizedInvoices(AuthorizedInvoices authorizedInvoices) {
        this.authorizedInvoices = authorizedInvoices;
    }

    public String getDocumentID(String documentID){
        return this.authorizedInvoices.getDocumentID(documentID);
    }
}
