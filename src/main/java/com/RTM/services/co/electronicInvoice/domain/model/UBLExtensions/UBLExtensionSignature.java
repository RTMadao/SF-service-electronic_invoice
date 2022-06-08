package com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions;

import javax.xml.bind.annotation.XmlElement;

public class UBLExtensionSignature {
    private ExtensionContentSignature extensionContent;

    public UBLExtensionSignature(){}

    public UBLExtensionSignature(ExtensionContentSignature extensionContent) {
        this.extensionContent = extensionContent;
    }

    @XmlElement(name = "ExtensionContent", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public ExtensionContentSignature getExtensionContent() {
        return extensionContent;
    }

    public void setExtensionContent(ExtensionContentSignature extensionContent) {
        this.extensionContent = extensionContent;
    }
}
