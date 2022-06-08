package com.RTM.services.co.electronicInvoice.domain.model.party;

import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.party.location.Address;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;

import javax.xml.bind.annotation.XmlElement;

public class AccountingSupplierParty {
    private String additionalAccountID;
    private Party party;

    public AccountingSupplierParty() {}

    public AccountingSupplierParty(AccountingSupplierParty accountingSupplierParty) {
        this.additionalAccountID = accountingSupplierParty.additionalAccountID;
        this.party = accountingSupplierParty.getParty();
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
    public PartyTaxScheme getPartyToAttachedDocumentParty(){
        PartyTaxScheme partyTaxScheme = new PartyTaxScheme();
        partyTaxScheme.setRegistrationName(this.party.getPartyTaxScheme().getRegistrationName());
        partyTaxScheme.setCompanyID(this.party.getPartyTaxScheme().getCompanyID());
        partyTaxScheme.setTaxLevelCode(this.party.getPartyTaxScheme().getTaxLevelCode());
        partyTaxScheme.setTaxScheme(this.party.getPartyTaxScheme().getTaxScheme());
        return partyTaxScheme;
    }
    public void setAdditionalAccountID(String additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }
    public void setParty(Party party) {
        this.party = party;
    }
}
