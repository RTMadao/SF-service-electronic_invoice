package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.AuthorizationProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider.SoftwareProvider;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareSecurityCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"invoiceControl","invoiceSource","softwareProvider","softwareSecurityCode","authorizationProvider","QRCode"})
public class DianExtensions {

    private InvoiceControl invoiceControl;
    private InvoiceSource invoiceSource;
    private SoftwareProvider softwareProvider;
    private SoftwareSecurityCode softwareSecurityCode;
    private AuthorizationProvider authorizationProvider;
    private String QRCode;

    public DianExtensions(){}

    public DianExtensions(InvoiceControl invoiceControl, InvoiceSource invoiceSource, SoftwareProvider softwareProvider, SoftwareSecurityCode softwareSecurityCode, AuthorizationProvider authorizationProvider, String QRCode) {
        this.invoiceControl = invoiceControl;
        this.invoiceSource = invoiceSource;
        this.softwareProvider = softwareProvider;
        this.softwareSecurityCode = softwareSecurityCode;
        this.authorizationProvider = authorizationProvider;
        this.QRCode = QRCode;
    }

    @XmlElement(name = "InvoiceControl", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public InvoiceControl getInvoiceControl() {
        return invoiceControl;
    }

    public void setInvoiceControl(InvoiceControl invoiceControl) {
        this.invoiceControl = invoiceControl;
    }

    @XmlElement(name = "InvoiceSource", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public InvoiceSource getInvoiceSource() {
        return invoiceSource;
    }

    public void setInvoiceSource(InvoiceSource invoiceSource) {
        this.invoiceSource = invoiceSource;
    }

    @XmlElement(name = "SoftwareProvider", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public SoftwareProvider getSoftwareProvider() {
        return softwareProvider;
    }

    public void setSoftwareProvider(SoftwareProvider softwareProvider) {
        this.softwareProvider = softwareProvider;
    }

    @XmlElement(name = "SoftwareSecurityCode", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public SoftwareSecurityCode getSoftwareSecurityCode() {
        return softwareSecurityCode;
    }

    public void setSoftwareSecurityCode(SoftwareSecurityCode softwareSecurityCode) {
        this.softwareSecurityCode = softwareSecurityCode;
    }

    @XmlElement(name = "AuthorizationProvider", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public AuthorizationProvider getAuthorizationProvider() {
        return authorizationProvider;
    }

    public void setAuthorizationProvider(AuthorizationProvider authorizationProvider) {
        this.authorizationProvider = authorizationProvider;
    }

    @XmlElement(name = "QRCode", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }
}
