package com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument;

import com.RTM.services.co.electronicInvoice.domain.model.Attachment.Attachment;
import com.RTM.services.co.electronicInvoice.domain.model.Attachment.ParentDocumentLineReference;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.UBLExtensions.UBLExtensionSignature;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.UUID;
import com.RTM.services.co.electronicInvoice.domain.model.party.AttachedDocumentParty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "AttachedDocument")
@XmlType(propOrder={"ublExtensionSignature","UBLVersionID","customizationID","profileID","profileExecutionID","ID",
        "CUFE","issueDate","issueTime","documentType","parentDocumentID","senderParty","receiverParty","attachment",
        "parentDocumentLineReference"
})
public class AttachedDocument {
    private UBLExtensionSignature ublExtensionSignature;
    private String UBLVersionID;
    private String customizationID;
    private String profileID;
    private String profileExecutionID;
    private UUID CUFE;
    private String IssueDate;
    private String IssueTime;
    private String id;
    private String parentDocumentID;
    private AttachedDocumentParty senderParty;
    private AttachedDocumentParty receiverParty;
    private Attachment attachment;
    private List<ParentDocumentLineReference> parentDocumentLineReference;
    public AttachedDocument() {
        parentDocumentLineReference = new ArrayList<ParentDocumentLineReference>();
    }

    @XmlElement(name = "UBLExtension", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2")
    public UBLExtensionSignature getUblExtensionSignature() {
        return ublExtensionSignature;
    }
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return id;
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
    @XmlElement(name = "ProfileID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getProfileID() {
        return profileID;
    }
    @XmlElement(name = "DocumentType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getDocumentType() {
        return "Contenedor de Factura Electrónica";
    }
    @XmlElement(name = "IssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueDate() {
        return IssueDate;
    }
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public UUID getCUFE() {
        return CUFE;
    }
    @XmlElement(name = "IssueTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getIssueTime() {
        return IssueTime;
    }
    @XmlElement(name = "ParentDocumentID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getParentDocumentID() {
        return parentDocumentID;
    }
    @XmlElement(name = "ReceiverParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public AttachedDocumentParty getReceiverParty() {
        return receiverParty;
    }
    @XmlElement(name = "SenderParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public AttachedDocumentParty getSenderParty() {
        return senderParty;
    }
    @XmlElement(name = "Attachment", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Attachment getAttachment() {
        return attachment;
    }
    @XmlElement(name = "ParentDocumentLineReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<ParentDocumentLineReference> getParentDocumentLineReference() {
        return parentDocumentLineReference;
    }

    public ID supplierPartyID() {
        return this.senderParty.getCompanyID();
    }

    public void setUblExtensionSignature(UBLExtensionSignature ublExtensionSignature) {
        this.ublExtensionSignature = ublExtensionSignature;
    }
    public void setUBLExtension(UBLExtensionSignature ublExtensionSignature) {
        this.ublExtensionSignature = ublExtensionSignature;
    }
    public void setSenderParty(AttachedDocumentParty senderParty) {
        this.senderParty = senderParty;
    }
    public void setID(String ID) {
        this.id = ID;
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
    public void setUUID(UUID CUFE) {
        this.CUFE = CUFE;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setParentDocumentID(String parentDocumentID) {
        this.parentDocumentID = parentDocumentID;
    }
    public void setReceiverParty(AttachedDocumentParty receiverParty) {
        this.receiverParty = receiverParty;
    }
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
    public void setParentDocumentLineReference(List<ParentDocumentLineReference> parentDocumentLineReference) {
        this.parentDocumentLineReference = parentDocumentLineReference;
    }
    public void addParentDocumentLineReference(ParentDocumentLineReference parentDocumentLineReference) {
        this.parentDocumentLineReference.add(parentDocumentLineReference);
    }
}
