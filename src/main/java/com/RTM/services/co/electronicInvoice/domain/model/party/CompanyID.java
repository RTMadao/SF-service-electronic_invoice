package com.RTM.services.co.electronicInvoice.domain.model.party;

import com.RTM.services.co.electronicInvoice.domain.model.ID;

public class CompanyID  extends ID {
    public CompanyID() {}

    public CompanyID(int id, int schemeID, int schemeName) {
        super(id, schemeID, schemeName);
    }
}
