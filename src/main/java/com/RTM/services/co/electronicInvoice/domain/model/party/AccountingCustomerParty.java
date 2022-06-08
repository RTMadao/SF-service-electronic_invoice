package com.RTM.services.co.electronicInvoice.domain.model.party;

import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.party.location.Address;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;

import javax.xml.bind.annotation.XmlElement;

public class AccountingCustomerParty {
    private String additionalAccountID;
    private Party party;

    public AccountingCustomerParty() {}

    public AccountingCustomerParty(AccountingCustomerParty accountingCustomerParty) {
        this.additionalAccountID = accountingCustomerParty.getAdditionalAccountID();
        this.party = accountingCustomerParty.getParty();
    }

    public AccountingCustomerParty(String additionalAccountID, Party party) {
        this.additionalAccountID = additionalAccountID;
        this.party = party;
    }

    @XmlElement(name = "AdditionalAccountID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getAdditionalAccountID() {
        return this.additionalAccountID;
    }
    @XmlElement(name = "Party", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Party getParty() {
        return party;
    }
    public String getRegistrationName(){
        return this.party.getPartyTaxScheme().getRegistrationName();
    }
    public ID getCompanyID(){
        return  this.party.getPartyTaxScheme().getCompanyID();
    }
    public Address getAddress(){
        return this.party.getPartyTaxScheme().getRegistrationAddress().getAddress();
    }

    public void setAdditionalAccountID(String additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }
    public void setParty(Party party) {
        this.party = party;
    }
    public PartyTaxScheme getPartyToAttachedDocumentParty(){
        return this.party.getPartyTaxScheme();
    }
}
