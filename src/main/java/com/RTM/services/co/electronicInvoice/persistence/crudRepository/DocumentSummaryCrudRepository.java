package com.RTM.services.co.electronicInvoice.persistence.crudRepository;

import com.RTM.services.co.electronicInvoice.persistence.Entity.DocumentSummary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentSummaryCrudRepository extends CrudRepository<DocumentSummary, Integer> {
    List<DocumentSummary> findByDocumentType(String documentType);
}
