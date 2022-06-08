package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.repository.InvoiceControlRepository;
import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;
import com.RTM.services.co.electronicInvoice.persistence.Entity.SoftwareIdentifier;
import com.RTM.services.co.electronicInvoice.persistence.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterService {

    @Autowired
    private InvoiceControlRepository invoiceControlRepository;
    @Autowired
    private ParameterRepository parameterRepository;

    public Optional<InvoiceControl> getInvoiceControlParameter() {
        return invoiceControlRepository.getInvoiceControl();
    }
    public Optional<SoftwareIdentifier> getSoftwareIdentifier(){
        return parameterRepository.getSoftwareIdentifier();
    }
    public Optional<Integer> getLastAuthorizedInvoices() {
        return invoiceControlRepository.getLastAuthorizedInvoices();
    }
    public void saveLastAuthorizedInvoices() {
        invoiceControlRepository.saveLastAuthorizedInvoices();
    }
    public Optional<Integer> getLastCreditNoteID() {
        return invoiceControlRepository.getLastCreditNoteID();
    }
    public void saveLastCreditNoteID() {
        invoiceControlRepository.saveLastCreditNoteID();
    }
    public Optional<Integer> getLastDebitNoteID() {
        return invoiceControlRepository.getLastDebitNoteID();
    }
    public void saveLastDebitNoteID() {
        invoiceControlRepository.saveLastDebitNoteID();
    }
    public Optional<Integer> getLastApplicationResponseID() {
        return invoiceControlRepository.getLastApplicationResponseID();
    }
    public void saveLastApplicationResponseID() {
        invoiceControlRepository.saveLastApplicationResponseID();
    }
    public Optional<Integer> getLastAttachedDocumentID() {
        return invoiceControlRepository.getLastAttachedDocumentID();
    }
    public void saveLastAttachedDocumentID() {
        invoiceControlRepository.saveLastAttachedDocumentID();
    }
    public List<Certificate> getCertificateList() {
        return parameterRepository.getCertificateList();
    }
}
