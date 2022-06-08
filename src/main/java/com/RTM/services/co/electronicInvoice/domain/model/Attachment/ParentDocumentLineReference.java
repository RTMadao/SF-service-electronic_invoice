package com.RTM.services.co.electronicInvoice.domain.model.Attachment;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.InvoiceDocumentReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(propOrder={"lineID","documentReference"})
public class ParentDocumentLineReference {
    private String lineID;
    private InvoiceDocumentReference documentReference;

    public ParentDocumentLineReference() {}
    public ParentDocumentLineReference(String lineID) {
        this.lineID = lineID;
    }

    @XmlElement(name = "LineID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getLineID() {
        return lineID;
    }
    @XmlElement(name = "DocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public InvoiceDocumentReference getDocumentReference() {
        return documentReference;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }
    public void setDocumentReference(String ID, String UUID, String issueDate) {
        this.documentReference = new InvoiceDocumentReference(ID, UUID, issueDate);
        this.documentReference.setDocumentTypeCode("ApplicationResponse");
    }
    public void setResponseAttachment(String applicationResponseDocument){
        this.documentReference.setAttachment(new Attachment(applicationResponseDocument));
    }
    public void setResultOfVerification(String validationResultCode, Date validationDateTime){
        this.documentReference.setResultOfVerification(new ResultOfVerification(validationResultCode, validationDateTime));
    }
}
