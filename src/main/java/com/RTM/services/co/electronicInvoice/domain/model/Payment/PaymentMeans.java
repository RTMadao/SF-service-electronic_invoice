package com.RTM.services.co.electronicInvoice.domain.model.Payment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"ID","paymentMeansCode","paymentDueDate","paymentID"})
public class PaymentMeans {
    private String ID;
    private String paymentMeansCode;
    private String paymentDueDate;
    private String paymentID;

    public PaymentMeans() {}

    public PaymentMeans(String ID, String paymentMeansCode) {
        this.ID = ID;
        this.paymentMeansCode = paymentMeansCode;
    }
    @XmlElement(name = "ID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getID() {
        return ID;
    }
    @XmlElement(name = "PaymentMeansCode", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getPaymentMeansCode() {
        return paymentMeansCode;
    }
    @XmlElement(name = "PaymentDueDate", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getPaymentDueDate() {
        return paymentDueDate;
    }
    @XmlElement(name = "PaymentID", namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getPaymentID() {
        return paymentID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setPaymentMeansCode(String paymentMeansCode) {
        this.paymentMeansCode = paymentMeansCode;
    }
}
