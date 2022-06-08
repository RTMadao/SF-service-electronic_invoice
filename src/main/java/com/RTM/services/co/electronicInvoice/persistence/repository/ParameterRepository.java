package com.RTM.services.co.electronicInvoice.persistence.repository;

import com.RTM.services.co.electronicInvoice.client.ParameterClient;
import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;
import com.RTM.services.co.electronicInvoice.persistence.Entity.SoftwareIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ParameterRepository {
    @Autowired
    private ParameterClient parameterClient;
    public Optional<SoftwareIdentifier> getSoftwareIdentifier() {
        return Optional.ofNullable(parameterClient.getSoftwareIdentifierById().getBody());
    }
    public List<Certificate> getCertificateList() {
        return parameterClient.getAllCertificate().getBody();
    }
}
