package com.RTM.services.co.electronicInvoice.domain.model.Signature.Object;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class Object {
    private QualifyingProperties qualifyingProperties;
    public Object() {}

    public Object(Date SigningTime, String UUID) {
        this.qualifyingProperties = new QualifyingProperties(SigningTime, UUID);
    }
    @XmlElement(name = "QualifyingProperties", namespace="http://uri.etsi.org/01903/v1.3.2#")
    public QualifyingProperties getQualifyingProperties() {
        return qualifyingProperties;
    }
    public void setTarget(String UUID) {
        this.qualifyingProperties.setTarget(UUID);
    }
}
