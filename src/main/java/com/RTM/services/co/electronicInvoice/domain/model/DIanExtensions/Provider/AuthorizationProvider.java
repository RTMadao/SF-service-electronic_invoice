package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider;

import com.RTM.services.co.electronicInvoice.domain.model.ID;

import javax.xml.bind.annotation.XmlElement;

public class AuthorizationProvider {

    private ID authorizationProviderID;

    public AuthorizationProvider(){
        this.authorizationProviderID =  new ID(800197268,4,31);
    }

    @XmlElement(name = "AuthorizationProviderID", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public ID getAuthorizationProviderID() {
        return authorizationProviderID;
    }

    public void setAuthorizationProviderID(ID authorizationProviderID) {
        this.authorizationProviderID = authorizationProviderID;
    }
}
