package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider;

import com.RTM.services.co.electronicInvoice.domain.model.ID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"providerID","softwareID"})
public class SoftwareProvider {

    private ID providerID;
    private SoftwareID softwareID;

    public SoftwareProvider() {
    }

    public SoftwareProvider(ID providerID, SoftwareID softwareID) {
        this.providerID = providerID;
        this.softwareID = softwareID;
    }

    @XmlElement(name = "ProviderID", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public ID getProviderID() {
        return providerID;
    }

    public void setProviderID(ProviderID providerID) {
        this.providerID = providerID;
    }

    @XmlElement(name = "SoftwareID", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public SoftwareID getSoftwareID() {
        return softwareID;
    }

    public void setSoftwareID(SoftwareID softwareID) {
        this.softwareID = softwareID;
    }
}
