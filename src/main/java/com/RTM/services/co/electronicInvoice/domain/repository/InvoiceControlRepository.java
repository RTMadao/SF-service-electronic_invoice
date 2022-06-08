package com.RTM.services.co.electronicInvoice.domain.repository;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;

import java.util.Optional;

public interface InvoiceControlRepository {
    Optional<InvoiceControl> getInvoiceControl();
    Optional<Integer> getLastAuthorizedInvoices();
    Optional<Integer> getLastCreditNoteID();
    Optional<Integer> getLastDebitNoteID();
    Optional<Integer> getLastApplicationResponseID();
    Optional<Integer> getLastAttachedDocumentID();
    void saveLastAuthorizedInvoices();
    void saveLastCreditNoteID();
    void saveLastDebitNoteID();
    void saveLastApplicationResponseID();
    void saveLastAttachedDocumentID();
}
