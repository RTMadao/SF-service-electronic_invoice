package com.RTM.services.co.electronicInvoice.persistence.repository;

import com.RTM.services.co.electronicInvoice.client.ParameterClient;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.repository.InvoiceControlRepository;
import com.RTM.services.co.electronicInvoice.persistence.mapper.ElectronicDocumentParameterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ElectronicDocumentParameterRepository implements InvoiceControlRepository {

    @Autowired
    private ParameterClient parameterClient;
    @Autowired
    private ElectronicDocumentParameterMapper mapper;

    @Override
    public Optional<InvoiceControl> getInvoiceControl() {
        return Optional.ofNullable(mapper.toInvoiceControl(parameterClient.getElectronicDocumentParameter().getBody()));
    }
    @Override
    public Optional<Integer> getLastAuthorizedInvoices() {
        return Optional.ofNullable(parameterClient.getLastAuthorizedInvoices().getBody());
    }
    @Override
    public Optional<Integer> getLastCreditNoteID() {
        return Optional.ofNullable(parameterClient.getLastCreditNoteID().getBody());
    }
    @Override
    public Optional<Integer> getLastDebitNoteID() {
        return Optional.ofNullable(parameterClient.getLastDebitNoteID().getBody());
    }
    @Override
    public Optional<Integer> getLastApplicationResponseID() {
        return Optional.ofNullable(parameterClient.getLastApplicationResponseID().getBody());
    }
    @Override
    public Optional<Integer> getLastAttachedDocumentID() {
        return Optional.ofNullable(parameterClient.getLastAttachedDocumentID().getBody());
    }

    @Override
    public void saveLastAuthorizedInvoices() {
        parameterClient.saveLastAuthorizedInvoices().getBody();
    }
    @Override
    public void saveLastCreditNoteID() {
        parameterClient.saveLastCreditNoteID().getBody();
    }
    @Override
    public void saveLastDebitNoteID() {
        parameterClient.saveLastDebitNoteID().getBody();
    }
    @Override
    public void saveLastApplicationResponseID() {
        parameterClient.saveLastApplicationResponseID().getBody();
    }
    @Override
    public void saveLastAttachedDocumentID() {
        parameterClient.saveLastAttachedDocumentID().getBody();
    }
}
