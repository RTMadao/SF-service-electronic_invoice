package com.RTM.services.co.electronicInvoice.persistence.mapper;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.persistence.Entity.ElectronicDocumentParameter;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElectronicDocumentParameterMapper {
    @Mappings({
            @Mapping(source = "authorizationPeriodStartDate", target = "authorizationPeriod.startDate"),
            @Mapping(source = "authorizationPeriodEndDate", target = "authorizationPeriod.endDate"),
            @Mapping(source = "authorizedInvoicesPrefix", target = "authorizedInvoices.prefix"),
            @Mapping(source = "authorizedInvoicesFrom", target = "authorizedInvoices.from"),
            @Mapping(source = "authorizedInvoicesTo", target = "authorizedInvoices.to")
    })
    InvoiceControl toInvoiceControl(ElectronicDocumentParameter electronicDocumentParameter);
    List<InvoiceControl> toInvoiceControls(List<ElectronicDocumentParameter> electronicDocumentParameter);

    @InheritInverseConfiguration()
    @Mappings({
            @Mapping(ignore = true, target = "id"),
            @Mapping(ignore = true, target = "creditNoteIdLastUsed"),
            @Mapping(ignore = true, target = "debitNoteIdLastUsed"),
            @Mapping(ignore = true, target = "applicationIdResponseLastUsed"),
            @Mapping(ignore = true, target = "attachedDocumentIdLastUsed")
    })
    ElectronicDocumentParameter toCompanyParameter(InvoiceControl invoiceControl);
}
