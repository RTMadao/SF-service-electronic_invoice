package com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions;

import javax.xml.bind.annotation.XmlElement;

public class UBLExtensions {

    private UBLExtensionDIAN ublExtensionDIAN;
    private UBLExtensionSignature ublExtensionSignature;

    public UBLExtensions(){}

    public UBLExtensions(UBLExtensionDIAN ublExtensionDIAN, UBLExtensionSignature ublExtensionSignature) {
        this.ublExtensionDIAN = ublExtensionDIAN;
        this.ublExtensionSignature = ublExtensionSignature;
    }

    @XmlElement(name = "UBLExtension", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public UBLExtensionDIAN getUblExtensionDIAN() {
        return ublExtensionDIAN;
    }

    public void setUblExtensionDIAN(UBLExtensionDIAN ublExtensionDIAN) {
        this.ublExtensionDIAN = ublExtensionDIAN;
    }

    @XmlElement(name = "UBLExtension", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public UBLExtensionSignature getUblExtensionSignature() {
        return ublExtensionSignature;
    }

    public void setUblExtensionSignature(UBLExtensionSignature ublExtensionSignature) {
        this.ublExtensionSignature = ublExtensionSignature;
    }
}
