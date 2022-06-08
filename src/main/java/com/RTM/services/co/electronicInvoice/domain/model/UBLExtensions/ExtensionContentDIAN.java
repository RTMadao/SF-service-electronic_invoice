package com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.DianExtensions;

import javax.xml.bind.annotation.XmlElement;

public class ExtensionContentDIAN {

    private DianExtensions dianExtensions;

    public ExtensionContentDIAN(){}

    public ExtensionContentDIAN(DianExtensions dianExtensions) {
        this.dianExtensions = dianExtensions;
    }

    @XmlElement(name = "DianExtensions", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public DianExtensions getDIANExtension() {
        return dianExtensions;
    }

    public void setDianExtensions(DianExtensions dianExtensions) {
        this.dianExtensions = dianExtensions;
    }
}
