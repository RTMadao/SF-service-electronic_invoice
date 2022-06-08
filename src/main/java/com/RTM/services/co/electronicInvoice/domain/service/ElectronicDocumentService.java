package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl.InvoiceControl;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.IdentificationCode;
import com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceSource.InvoiceSource;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.ApplicationResponseBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.AttachedDocumentBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.DocumentBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.DocumentResponse;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.*;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.Object.SignedProperties;
import com.RTM.services.co.electronicInvoice.domain.model.Signature.SignedPropertiesRoot;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;
import com.RTM.services.co.electronicInvoice.domain.model.util.StaticParameter;
import com.RTM.services.co.electronicInvoice.persistence.Entity.Certificate;
import com.RTM.services.co.electronicInvoice.persistence.Entity.SoftwareIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
import java.util.stream.Collectors;

@Service
public class ElectronicDocumentService {
    @Autowired
    ParameterService parameterService;
    @Autowired
    XMLCastService xmlCastService;
    @Autowired
    StaticParameter staticParameter;

    public ElectronicDocument generateElectronicDocument(ElectronicDocument document, DocumentBuilder concreteBuilder){
        InvoiceControl invoiceControl = parameterService.getInvoiceControlParameter().orElseThrow(() -> new MissingResourceException("No se encontraron los parametros","InvoiceControl","Key"));
        SoftwareIdentifier softwareIdentifier = parameterService.getSoftwareIdentifier().orElseThrow(() -> new MissingResourceException("No se encontraron los Datos de identificacion del software","softwareIdentifier","Key"));
        List<Certificate> certificates = parameterService.getCertificateList();
        Date issueDateTime = new Date();

        DocumentBuilder builder = concreteBuilder;

        builder.setExtensions(new InvoiceSource(new IdentificationCode(
                staticParameter.getIdentificationCodeCode(),
                staticParameter.getIdentificationCodeListAgencyID(),
                staticParameter.getIdentificationCodeListAgencyName(),
                staticParameter.getIdentificationCodeListSchemeURI()
        )), invoiceControl,softwareIdentifier,document.supplierPartyID(),document.getID());
        builder.setDocumentStaticParams(staticParameter.getUBLVersionID(), staticParameter.getInvoiceProfileID());
        builder.setDocumentParams(document);
        builder.setDocumentDateTime(document,issueDateTime);
        builder.setDocumentReference(document);
        builder.setPartys(document);
        builder.setDelivery(document);
        builder.setInvoiceLine(document);
        builder.setPaymentAmount(document);
        builder.setDocumentID(document,staticParameter.getCUDESchemeName(),softwareIdentifier,DataFormatService.setDateFormat(issueDateTime));
        builder.setQRCode(issueDateTime);
        try {
            String rootNode = getRootNode(builder.getDocument(), builder.getDocumentType());
            builder.setSignature(rootNode,certificates);
            String signedPropertiesNode = getSignedPropertiesNode(builder.getSignedProperties());
            builder.setSignatureReference(
                    rootNode,
                    certificates.stream().filter(cert -> cert.getEntity().equals("supplier")).collect(Collectors.toList()).get(0).getCertificate(),
                    signedPropertiesNode
            );
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return builder.getDocument();
    }
    public ApplicationResponse generateApplicationResponse(ElectronicDocument document,PartyTaxScheme senderParty, PartyTaxScheme reciberParty, DocumentResponse response){
        int applicationResponseID = parameterService.getLastApplicationResponseID().orElseThrow(() -> new MissingResourceException("No se encontraron los Datos de ID de documento ApplicationResponse","attachedDocumentID","Key"));
        applicationResponseID += 1;
        SoftwareIdentifier softwareIdentifier = parameterService.getSoftwareIdentifier().orElseThrow(() -> new MissingResourceException("No se encontraron los Datos de identificacion del software","softwareIdentifier","Key"));
        List<Certificate> certificates = parameterService.getCertificateList();
        Date issueDateTime = new Date();

        ApplicationResponseBuilder builder = new ApplicationResponseBuilder();

        builder.setExtensions(new InvoiceSource(new IdentificationCode(
                staticParameter.getIdentificationCodeCode(),
                staticParameter.getIdentificationCodeListAgencyID(),
                staticParameter.getIdentificationCodeListAgencyName(),
                staticParameter.getIdentificationCodeListSchemeURI()
        )),softwareIdentifier,document.supplierPartyID(),Integer.toString(applicationResponseID));
        builder.setDocumentStaticParams(staticParameter.getUBLVersionID(), staticParameter.getInvoiceProfileID());
        builder.setDocumentParams(document, "note");
        builder.setDocumentDateTime(issueDateTime);
        builder.setPartys(senderParty, reciberParty);
        builder.setDocumentResponse(response);
        builder.setDocumentID(
                Integer.toString(applicationResponseID),
                staticParameter.getCUDESchemeName(),
                DataFormatService.setDateLocale(issueDateTime),
                document.getID(),
                softwareIdentifier
        );
        try {
            String rootNode = getApplicationResponseRootNode(builder.getDocument());
            builder.setSignature(rootNode,certificates);
            String signedPropertiesNode = getSignedPropertiesNode(builder.getSignedProperties());
            builder.setSignatureReference(
                    rootNode,
                    certificates.stream().filter(cert -> cert.getEntity().equals("supplier")).collect(Collectors.toList()).get(0).getCertificate(),
                    signedPropertiesNode
            );
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return builder.getDocument();
    }
    public AttachedDocument generateAttachedDocument(ElectronicDocument document, String documentXML){
        int attachedDocumentID = parameterService.getLastAttachedDocumentID().orElseThrow(() -> new MissingResourceException("No se encontraron los Datos de ID de documento AttachedDocument","attachedDocumentID","Key"));
        List<Certificate> certificates = parameterService.getCertificateList();

        attachedDocumentID += 1;
        Date issueDateTime = new Date();

        AttachedDocumentBuilder builder = new AttachedDocumentBuilder();

        builder.setExtensions();
        builder.setDocumentStaticParams(staticParameter.getUBLVersionID(), staticParameter.getInvoiceProfileID());
        builder.setDocumentParams(document);
        builder.setDocumentID(Integer.toString(attachedDocumentID), document.getID());
        builder.setDocumentDateTime(issueDateTime);
        builder.setPartys(document);
        builder.setAttachment(documentXML);

        try {
            String rootNode = getAttachedDocumentRootNode(builder.getDocument());
            builder.setSignature(document);
            String signedPropertiesNode = getSignedPropertiesNode(builder.getSignedProperties());
            builder.setSignatureReference(
                    rootNode,
                    certificates.stream().filter(cert -> cert.getEntity().equals("supplier")).collect(Collectors.toList()).get(0).getCertificate(),
                    signedPropertiesNode
            );
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return builder.getDocument();
    }
    public AttachedDocument generateAttachedDocumentResponse(AttachedDocument attachedDocument, ElectronicDocument document, String applicationResponseXML, String responseCode){
        AttachedDocumentBuilder builder = new AttachedDocumentBuilder().setBuilder(attachedDocument);
        builder.setParentDocumentLineReference(document.getID(),document.getCUDE().getValue(),document.getIssueDate(),applicationResponseXML,responseCode);
        return builder.getDocument();
    }
    public void invoiceToXML(ElectronicDocument document, String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);
        xmlCastService.toFile(jaxbContext,document,staticParameter.getXmlDirectoryPath()+path+".xml");
    }
    public void creditNoteToXML(ElectronicDocument document, String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CreditNote.class);
        xmlCastService.toFile(jaxbContext,document,staticParameter.getXmlDirectoryPath()+path+".xml");
    }
    public void debitNoteToXML(ElectronicDocument document, String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DebitNote.class);
        xmlCastService.toFile(jaxbContext,document,staticParameter.getXmlDirectoryPath()+path+".xml");
    }
    public void applicationResponseToXML(ApplicationResponse document, String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationResponse.class);
        xmlCastService.toFile(jaxbContext,document,staticParameter.getXmlDirectoryPath()+path+".xml");
    }
    public String attachedDocumentToXML(AttachedDocument document, String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AttachedDocument.class);
        xmlCastService.toFile(jaxbContext,document,staticParameter.getXmlDirectoryPath()+path+".xml");
        return staticParameter.getXmlDirectoryPath()+path+".xml";
    }
    public String getRootNode(ElectronicDocument document, String documentType) throws JAXBException {
        if (documentType.equals("91")) return this.getCreditNoteRootNode((CreditNote) document);
        else if (documentType.equals("92")) return this.getDebitNoteRootNode((DebitNote) document);
        else return this.getInvoiceRootNode((Invoice) document);
    }
    public String getInvoiceRootNode(Invoice invoice) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);
        return xmlCastService.toString(jaxbContext,invoice);
    }
    public String getCreditNoteRootNode(CreditNote creditNote) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CreditNote.class);
        return xmlCastService.toString(jaxbContext,creditNote);
    }
    public String getDebitNoteRootNode(DebitNote debitNote) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DebitNote.class);
        return xmlCastService.toString(jaxbContext,debitNote);
    }
    public String getApplicationResponseRootNode(ApplicationResponse applicationResponse) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ApplicationResponse.class);
        return xmlCastService.toString(jaxbContext,applicationResponse);
    }
    public String getAttachedDocumentRootNode(AttachedDocument attachedDocument) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(AttachedDocument.class);
        return xmlCastService.toString(jaxbContext,attachedDocument);
    }
    public String getSignedPropertiesNode(SignedProperties signedProperties) throws JAXBException {
        SignedPropertiesRoot signedPropertiesRoot = new SignedPropertiesRoot(signedProperties);
        JAXBContext jaxbContext = JAXBContext.newInstance(SignedPropertiesRoot.class);
        return xmlCastService.toString(jaxbContext,signedPropertiesRoot);
    }
}
