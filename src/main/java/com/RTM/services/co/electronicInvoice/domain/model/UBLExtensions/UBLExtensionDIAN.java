package com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions;

import javax.xml.bind.annotation.XmlElement;

public class UBLExtensionDIAN {

    private ExtensionContentDIAN extensionContent;

    public UBLExtensionDIAN(){}

    public UBLExtensionDIAN(ExtensionContentDIAN extensionContent) {
        this.extensionContent = extensionContent;
    }

    @XmlElement(name = "ExtensionContent", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public ExtensionContentDIAN getExtensionContent() {
        return extensionContent;
    }

    public void setExtensionContent(ExtensionContentDIAN extensionContent) {
        this.extensionContent = extensionContent;
    }
}
