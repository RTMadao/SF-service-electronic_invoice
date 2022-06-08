package com.RTM.services.co.electronicInvoice.domain.model.Payment.PrepaidPayment;

import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"ID","paidAmount","receivedDate","paidDate","instructionID"})
public class PrepaidPayment {
    private String ID;
    private Money paidAmount;
    private String receivedDate;
    private String paidDate;
    private String instructionID;

    public PrepaidPayment() {}

    public PrepaidPayment(String ID, Money paidAmount, String receivedDate, String paidDate, String instructionID) {
        this.ID = ID;
        this.paidAmount = paidAmount;
        this.receivedDate = receivedDate;
        this.paidDate = paidDate;
        this.instructionID = instructionID;
    }
    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "PaidAmount", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public Money getPaidAmount() {
        return paidAmount;
    }
    @XmlElement(name = "ReceivedDate", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getReceivedDate() {
        return receivedDate;
    }
    @XmlElement(name = "PaidDate", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getPaidDate() {
        return paidDate;
    }
    @XmlElement(name = "InstructionID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getInstructionID() {
        return instructionID;
    }
}
