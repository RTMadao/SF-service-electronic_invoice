package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.Provider.SoftwareProvider;

import com.RTM.services.co.electronicInvoice.domain.model.ID;

public class ProviderID extends ID {
    public ProviderID() {}
    public ProviderID(int id, int schemeID, int schemeName) {
        super(id, schemeID, schemeName);
    }
}
