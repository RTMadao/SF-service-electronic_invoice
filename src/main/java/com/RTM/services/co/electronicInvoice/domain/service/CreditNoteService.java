package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.client.EmailClient;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.CreditNoteBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.InvoiceBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ApplicationResponse;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.AttachedDocument;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.CreditNote;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.Invoice;
import com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator.CreditNotePDFContext;
import com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator.InvoicePDFContext;
import com.RTM.services.co.electronicInvoice.domain.model.util.ElectronicDocumentEmailInfo;
import com.RTM.services.co.electronicInvoice.domain.model.util.StaticParameter;
import com.RTM.services.co.electronicInvoice.persistence.Entity.DocumentSummary;
import com.RTM.services.co.electronicInvoice.persistence.repository.DocumentSummaryRepository;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditNoteService {
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

    public CreditNote generateCreditNote(CreditNote userCreditNoteData){
        String documentNumber = Integer.toString(parameterService.getLastAttachedDocumentID().orElse(0));
        CreditNote generatedCreditNote = (CreditNote) electronicDocumentService.generateElectronicDocument(userCreditNoteData, new CreditNoteBuilder());
        String fileName = generatedCreditNote.getDocumentName(staticParameter.getAssignCode(),documentNumber);
        try {
            AttachedDocument attachedDocument = electronicDocumentService.generateAttachedDocument(generatedCreditNote, electronicDocumentService.getCreditNoteRootNode(generatedCreditNote));
            ApplicationResponse applicationResponse = dianResponse.getApplicationResponse(generatedCreditNote);
            if(applicationResponse.successResponse()){
                AttachedDocument attachedDocumentResponse = electronicDocumentService.generateAttachedDocumentResponse(
                        attachedDocument,
                        generatedCreditNote,
                        electronicDocumentService.getApplicationResponseRootNode(applicationResponse),
                        applicationResponse.getDocumentResponse().getResponse().getResponseCode()
                );
                generatedCreditNote.setValidationDatetime(applicationResponse.getValidationDateTime());
                String xmlPath = electronicDocumentService.attachedDocumentToXML(attachedDocumentResponse,"creditNote/"+fileName);
                parameterService.saveLastCreditNoteID();
                parameterService.saveLastAttachedDocumentID();

                File pdf = documentGeneratorService.generatePdf(new CreditNotePDFContext(generatedCreditNote),fileName);

                documentSummaryRepository.save(new DocumentSummary(
                        "91",
                        generatedCreditNote.getID(),
                        generatedCreditNote.getIssueDate(),
                        Long.toString(generatedCreditNote.getAccountingCustomerParty().getCompanyID().getId()),
                        generatedCreditNote.getAccountingCustomerParty().getRegistrationName(),
                        generatedCreditNote.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                        1,
                        xmlPath,
                        pdf.getPath(),
                        generatedCreditNote.getCUDE().getValue()
                ));

                List<File> files = new ArrayList<>();
                files.add(pdf);
                files.add(new File(xmlPath));


                emailClient.sendElectronicDocument(new ElectronicDocumentEmailInfo(
                        "Nota Crédito",
                        documentGeneratorService.generateZipFile(files,fileName),
                        fileName+".zip",
                        attachedDocumentResponse.getReceiverParty().getPartyTaxScheme().getRegistrationName(),
                        generatedCreditNote.getAccountingCustomerParty().getParty().getContact().getElectronicMail(),
                        generatedCreditNote.getAccountingSupplierParty().getParty().getContact().getElectronicMail()
                ));
            } else {
                documentSummaryRepository.save(new DocumentSummary(
                        "01",
                        generatedCreditNote.getID(),
                        generatedCreditNote.getIssueDate(),
                        Long.toString(generatedCreditNote.getAccountingCustomerParty().getCompanyID().getId()),
                        generatedCreditNote.getAccountingCustomerParty().getRegistrationName(),
                        generatedCreditNote.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                        2,
                        "",
                        "",
                        generatedCreditNote.getCUDE().getValue()
                ));
            }
            return generatedCreditNote;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<DocumentSummary> getCreditNoteList(){
        return documentSummaryRepository.getAllByDocumentType("91");
    }

}
