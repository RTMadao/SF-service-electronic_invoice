package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.client.EmailClient;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.InvoiceBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ApplicationResponse;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.AttachedDocument;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.Invoice;
import com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator.InvoicePDFContext;
import com.RTM.services.co.electronicInvoice.domain.model.util.ElectronicDocumentEmailInfo;
import com.RTM.services.co.electronicInvoice.domain.model.util.StaticParameter;
import com.RTM.services.co.electronicInvoice.persistence.Entity.DocumentSummary;
import com.RTM.services.co.electronicInvoice.persistence.repository.DocumentSummaryRepository;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private ElectronicDocumentService electronicDocumentService;
    @Autowired
    private DianResponse dianResponse;
    @Autowired
    private DocumentGeneratorService documentGeneratorService;
    @Autowired
    private EmailClient emailClient;
    @Autowired
    private DocumentSummaryRepository documentSummaryRepository;
    @Autowired
    ParameterService parameterService;
    @Autowired
    StaticParameter staticParameter;

    public Invoice generateInvoice(Invoice userInvoiceData){
        String documentNumber = Integer.toString(parameterService.getLastAttachedDocumentID().orElse(0));
        Invoice generatedInvoice = (Invoice) electronicDocumentService.generateElectronicDocument(userInvoiceData, new InvoiceBuilder());
        String fileName = generatedInvoice.getDocumentName(staticParameter.getAssignCode(),documentNumber);
        try {
            AttachedDocument attachedDocument = electronicDocumentService.generateAttachedDocument(generatedInvoice, electronicDocumentService.getInvoiceRootNode(generatedInvoice));
            ApplicationResponse applicationResponse = dianResponse.getApplicationResponse(generatedInvoice);
            if(applicationResponse.successResponse()){
                AttachedDocument attachedDocumentResponse = electronicDocumentService.generateAttachedDocumentResponse(
                        attachedDocument,
                        generatedInvoice,
                        electronicDocumentService.getApplicationResponseRootNode(applicationResponse),
                        applicationResponse.getDocumentResponse().getResponse().getResponseCode()
                );
                generatedInvoice.setValidationDateTime(applicationResponse.getValidationDateTime());
                String xmlPath = electronicDocumentService.attachedDocumentToXML(attachedDocumentResponse,"invoice/"+fileName);
                parameterService.saveLastAuthorizedInvoices();
                parameterService.saveLastAttachedDocumentID();

                File pdf = documentGeneratorService.generatePdf(new InvoicePDFContext(generatedInvoice),fileName);

                documentSummaryRepository.save(new DocumentSummary(
                        "01",
                        generatedInvoice.getID(),
                        generatedInvoice.getIssueDate(),
                        Long.toString(generatedInvoice.getAccountingCustomerParty().getCompanyID().getId()),
                        generatedInvoice.getAccountingCustomerParty().getRegistrationName(),
                        generatedInvoice.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                        1,
                        xmlPath,
                        pdf.getPath(),
                        generatedInvoice.getCUDE().getValue()
                ));

                List<File> files = new ArrayList<>();
                files.add(pdf);
                files.add(new File(xmlPath));


                emailClient.sendElectronicDocument(new ElectronicDocumentEmailInfo(
                        "Factura Electrónica de Venta",
                        documentGeneratorService.generateZipFile(files,fileName),
                        fileName+".zip",
                        attachedDocumentResponse.getReceiverParty().getPartyTaxScheme().getRegistrationName(),
                        generatedInvoice.getAccountingCustomerParty().getParty().getContact().getElectronicMail(),
                        generatedInvoice.getAccountingSupplierParty().getParty().getContact().getElectronicMail()
                ));
            } else {
                documentSummaryRepository.save(new DocumentSummary(
                        "01",
                        generatedInvoice.getID(),
                        generatedInvoice.getIssueDate(),
                        Long.toString(generatedInvoice.getAccountingCustomerParty().getCompanyID().getId()),
                        generatedInvoice.getAccountingCustomerParty().getRegistrationName(),
                        generatedInvoice.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                        2,
                        "",
                        "",
                        generatedInvoice.getCUDE().getValue()
                ));
            }

            return generatedInvoice;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<DocumentSummary> getInvoiceList(){
        return documentSummaryRepository.getAllByDocumentType("01");
    }
}
