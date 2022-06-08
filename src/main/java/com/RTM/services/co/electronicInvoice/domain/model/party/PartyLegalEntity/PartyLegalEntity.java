package com.RTM.services.co.electronicInvoice.domain.model.party.PartyLegalEntity;

import com.RTM.services.co.electronicInvoice.domain.model.ID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"registrationName","companyID","corporateRegistrationScheme"})
public class PartyLegalEntity {
    private CorporateRegistrationScheme corporateRegistrationScheme;
    private String registrationName;
    private ID companyID;

    public PartyLegalEntity() {}

    public PartyLegalEntity(CorporateRegistrationScheme corporateRegistrationScheme, String registrationName, ID companyID) {
        this.corporateRegistrationScheme = corporateRegistrationScheme;
        this.registrationName = registrationName;
        this.companyID = companyID;
    }

    @XmlElement(name = "CorporateRegistrationScheme", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public CorporateRegistrationScheme getCorporateRegistrationScheme() {
        return corporateRegistrationScheme;
    }
    @XmlElement(name = "RegistrationName", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getRegistrationName() {
        return registrationName;
    }
    @XmlElement(name = "CompanyID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public ID getCompanyID() {
        return companyID;
    }

    public void setCorporateRegistrationScheme(CorporateRegistrationScheme corporateRegistrationScheme) {
        this.corporateRegistrationScheme = corporateRegistrationScheme;
    }
}
