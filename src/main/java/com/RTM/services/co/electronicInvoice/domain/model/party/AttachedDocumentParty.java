package com.RTM.services.co.electronicInvoice.domain.model.party;

import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;

public class AttachedDocumentParty {
    private PartyTaxScheme partyTaxScheme;

    public AttachedDocumentParty(PartyTaxScheme partyTaxScheme) {
        this.partyTaxScheme = partyTaxScheme;
    }

    public AttachedDocumentParty() {
        partyTaxScheme = new PartyTaxScheme();
    }
    public PartyTaxScheme getPartyTaxScheme() {
        return partyTaxScheme;
    }
    public ID getCompanyID(){
        return  this.partyTaxScheme.getCompanyID();
    }
    public void setPartyTaxScheme(PartyTaxScheme partyTaxScheme) {
        this.partyTaxScheme = partyTaxScheme;
    }
}
