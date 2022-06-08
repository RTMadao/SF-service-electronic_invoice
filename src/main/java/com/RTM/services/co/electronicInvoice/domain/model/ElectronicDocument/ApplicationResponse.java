package com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument;

import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.DocumentResponse;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.UBLExtensions;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.UUID;
import com.RTM.services.co.electronicInvoice.domain.model.party.AttachedDocumentParty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "ApplicationResponse")
@XmlType(propOrder={"ublExtensions","UBLVersionID","customizationID","profileID","profileExecutionID","ID","CUFE",
        "issueDate","issueTime","note","senderParty","receiverParty","documentResponse"
})
public class ApplicationResponse {
    private UBLExtensions ublExtensions;
    private String id;
    private String UBLVersionID;
    private String customizationID;
    private String profileID;
    private String profileExecutionID;
    private UUID CUFE;
    private String Note;
    private String IssueDate;
    private String IssueTime;
    private AttachedDocumentParty senderParty;
    private AttachedDocumentParty receiverParty;
    private DocumentResponse documentResponse;

    public ApplicationResponse() {}

    @XmlElement(name = "UBLExtensions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public UBLExtensions getUblExtensions() {
        return ublExtensions;
    }
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return id;
    }
    @XmlElement(name = "ProfileID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getProfileID() {
        return profileID+": ApplicationResponse de Factura Electrónica de Venta";
    }
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public UUID getCUFE() {
        return CUFE;
    }
    @XmlElement(name = "SenderParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AttachedDocumentParty getSenderParty() {
        return senderParty;
    }
    @XmlElement(name = "UBLVersionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getUBLVersionID() {
        return UBLVersionID;
    }
    @XmlElement(name = "CustomizationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getCustomizationID() {
        return customizationID;
    }
    @XmlElement(name = "ProfileExecutionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getProfileExecutionID() {
        return profileExecutionID;
    }
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getNote() {
        return Note;
    }
    @XmlElement(name = "IssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueDate() {
        return IssueDate;
    }
    @XmlElement(name = "IssueTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueTime() {
        return IssueTime;
    }
    @XmlElement(name = "ReceiverParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AttachedDocumentParty getReceiverParty() {
        return receiverParty;
    }
    @XmlElement(name = "DocumentResponse", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public DocumentResponse getDocumentResponse() {
        return documentResponse;
    }
    public ID supplierPartyID() {
        return this.senderParty.getCompanyID();
    }

    public boolean successResponse(){
        return this.getDocumentResponse().getResponse().getResponseCode().equals("02");
    }

    public void setUblExtensions(UBLExtensions ublExtensions) {
        this.ublExtensions = ublExtensions;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNote(String note) {
        Note = note;
    }
    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }
    public void setIssueTime(String issueTime) {
        IssueTime = issueTime;
    }
    public void setUBLVersionID(String UBLVersionID) {
        this.UBLVersionID = UBLVersionID;
    }
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }
    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }
    public void setCUFE(UUID CUFE) {
        this.CUFE = CUFE;
    }
    public void setSenderParty(AttachedDocumentParty senderParty) {
        this.senderParty = senderParty;
    }
    public void setReceiverParty(AttachedDocumentParty receiverParty) {
        this.receiverParty = receiverParty;
    }
    public void setDocumentResponse(DocumentResponse documentResponse) {
        this.documentResponse = documentResponse;
    }
    public Date getValidationDateTime(){
        return this.ublExtensions.getUblExtensionSignature().getExtensionContent().getExtensions().getSignedProperties().getSignedSignatureProperties().getSigningTime();
    }
}
