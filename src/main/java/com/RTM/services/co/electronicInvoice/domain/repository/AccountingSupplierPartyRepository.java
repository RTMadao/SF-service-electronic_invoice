package com.RTM.services.co.electronicInvoice.domain.repository;

import com.RTM.services.co.electronicInvoice.domain.model.party.AccountingSupplierParty;

import java.util.Optional;

public interface AccountingSupplierPartyRepository {
    Optional<AccountingSupplierParty> getAccountingSupplierPartyById(int id);
}
