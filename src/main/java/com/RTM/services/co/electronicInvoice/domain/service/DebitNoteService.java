package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.client.EmailClient;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.DebitNoteBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.ApplicationResponse;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.AttachedDocument;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.DebitNote;
import com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator.DebitNotePDFContext;
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
public class DebitNoteService {
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

    public DebitNote generateCreditNote(DebitNote userDebitNoteData){
        String documentNumber = Integer.toString(parameterService.getLastAttachedDocumentID().orElse(0));
        DebitNote generatedDebitNote = (DebitNote) electronicDocumentService.generateElectronicDocument(userDebitNoteData, new DebitNoteBuilder());
        String fileName = generatedDebitNote.getDocumentName(staticParameter.getAssignCode(),documentNumber);
        try {
            AttachedDocument attachedDocument = electronicDocumentService.generateAttachedDocument(generatedDebitNote, electronicDocumentService.getDebitNoteRootNode(generatedDebitNote));
            ApplicationResponse applicationResponse = dianResponse.getApplicationResponse(generatedDebitNote);
            if(applicationResponse.successResponse()){
                AttachedDocument attachedDocumentResponse = electronicDocumentService.generateAttachedDocumentResponse(
                        attachedDocument,
                        generatedDebitNote,
                        electronicDocumentService.getApplicationResponseRootNode(applicationResponse),
                        applicationResponse.getDocumentResponse().getResponse().getResponseCode()
                );
                generatedDebitNote.setValidationDatetime(applicationResponse.getValidationDateTime());
                String xmlPath = electronicDocumentService.attachedDocumentToXML(attachedDocumentResponse,"debitNote/"+fileName);
                parameterService.saveLastDebitNoteID();
                parameterService.saveLastAttachedDocumentID();

                File pdf = documentGeneratorService.generatePdf(new DebitNotePDFContext(generatedDebitNote),fileName);

                documentSummaryRepository.save(new DocumentSummary(
                        "92",
                        generatedDebitNote.getID(),
                        generatedDebitNote.getIssueDate(),
                        Long.toString(generatedDebitNote.getAccountingCustomerParty().getCompanyID().getId()),
                        generatedDebitNote.getAccountingCustomerParty().getRegistrationName(),
                        generatedDebitNote.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                        1,
                        xmlPath,
                        pdf.getPath(),
                        generatedDebitNote.getCUDE().getValue()
                ));

                List<File> files = new ArrayList<>();
                files.add(pdf);
                files.add(new File(xmlPath));


                emailClient.sendElectronicDocument(new ElectronicDocumentEmailInfo(
                        "Nota Débito",
                        documentGeneratorService.generateZipFile(files,fileName),
                        fileName+".zip",
                        attachedDocumentResponse.getReceiverParty().getPartyTaxScheme().getRegistrationName(),
                        generatedDebitNote.getAccountingCustomerParty().getParty().getContact().getElectronicMail(),
                        generatedDebitNote.getAccountingSupplierParty().getParty().getContact().getElectronicMail()
                ));
            } else {
                documentSummaryRepository.save(new DocumentSummary(
                        "01",
                        generatedDebitNote.getID(),
                        generatedDebitNote.getIssueDate(),
                        Long.toString(generatedDebitNote.getAccountingCustomerParty().getCompanyID().getId()),
                        generatedDebitNote.getAccountingCustomerParty().getRegistrationName(),
                        generatedDebitNote.getLegalMonetaryTotal().getPayableAmount().getPaidAmount(),
                        2,
                        "",
                        "",
                        generatedDebitNote.getCUDE().getValue()
                ));
            }
            return generatedDebitNote;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<DocumentSummary> getDebitNoteList(){
        return documentSummaryRepository.getAllByDocumentType("92");
    }

}
