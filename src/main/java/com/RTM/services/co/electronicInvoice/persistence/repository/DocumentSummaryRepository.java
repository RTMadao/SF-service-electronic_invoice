package com.RTM.services.co.electronicInvoice.persistence.repository;

import com.RTM.services.co.electronicInvoice.persistence.Entity.DocumentSummary;
import com.RTM.services.co.electronicInvoice.persistence.crudRepository.DocumentSummaryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DocumentSummaryRepository {
    @Autowired
    private DocumentSummaryCrudRepository crudRepository;
    public List<DocumentSummary> getAll() {
        return (List<DocumentSummary>) crudRepository.findAll();
    }
    public Optional<DocumentSummary> getById(int id){
        return crudRepository.findById(id);
    }
    public List<DocumentSummary> getAllByDocumentType(String documentType) {
        return crudRepository.findByDocumentType(documentType);
    }
    public DocumentSummary save(DocumentSummary summary) {
        return crudRepository.save(summary);
    }
}
