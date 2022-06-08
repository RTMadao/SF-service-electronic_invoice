package com.RTM.services.co.electronicInvoice.domain.model.Signature;

import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedProperties;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "SignedProperties")
public class SignedPropertiesRoot extends SignedProperties {
    public SignedPropertiesRoot(SignedProperties signedProperties) {
        super(signedProperties);
    }
    public SignedPropertiesRoot() {
        super();
    }
}
