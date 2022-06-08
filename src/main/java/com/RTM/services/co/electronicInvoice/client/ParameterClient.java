package com.RTM.services.co.electronicInvoice.client;

import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;
import com.RTM.services.co.electronicInvoice.persistence.Entity.ElectronicDocumentParameter;
import com.RTM.services.co.electronicInvoice.persistence.Entity.SoftwareIdentifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("parameter-service")
public interface ParameterClient {
    @GetMapping("/parameter/electronic_document_parameter/")
    ResponseEntity<ElectronicDocumentParameter> getElectronicDocumentParameter();
    @GetMapping("/parameter/electronic_document_parameter/invoice/document_id/get_last")
    ResponseEntity<Integer> getLastAuthorizedInvoices();
    @GetMapping("/parameter/electronic_document_parameter/credit_note/document_id/get_last")
    ResponseEntity<Integer> getLastCreditNoteID();
    @GetMapping("/parameter/electronic_document_parameter/debit_note/document_id/get_last")
    ResponseEntity<Integer> getLastDebitNoteID();
    @GetMapping("/parameter/electronic_document_parameter/application_response/document_id/get_last")
    ResponseEntity<Integer> getLastApplicationResponseID();
    @GetMapping("/parameter/electronic_document_parameter/attached_document/document_id/get_last")
    ResponseEntity<Integer> getLastAttachedDocumentID();
    @GetMapping("/parameter/electronic_document_parameter/invoice/document_id/update")
    ResponseEntity<ElectronicDocumentParameter> saveLastAuthorizedInvoices();
    @GetMapping("/parameter/electronic_document_parameter/credit_note/document_id/update")
    ResponseEntity<ElectronicDocumentParameter> saveLastCreditNoteID();
    @GetMapping("/parameter/electronic_document_parameter/debit_note/document_id/update")
    ResponseEntity<ElectronicDocumentParameter> saveLastDebitNoteID();
    @GetMapping("/parameter/electronic_document_parameter/application_response/document_id/update")
    ResponseEntity<ElectronicDocumentParameter> saveLastApplicationResponseID();
    @GetMapping("/parameter/electronic_document_parameter/attached_document/document_id/update")
    ResponseEntity<ElectronicDocumentParameter> saveLastAttachedDocumentID();
    @GetMapping("/parameter/software_identifier/")
    ResponseEntity<SoftwareIdentifier> getSoftwareIdentifierById();
    @GetMapping("/parameter/certificate/all")
    ResponseEntity<List<Certificate>> getAllCertificate();
}
