package com.RTM.services.co.electronicInvoice.domain.model.DIanExtensions.InvoiceControl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"prefix","from","to"})
public class AuthorizedInvoices {

    private String Prefix;
    private int From;
    private int To;

    public AuthorizedInvoices() {}
    public AuthorizedInvoices(String prefix, int from, int to) {
        Prefix = prefix;
        From = from;
        To = to;
    }

    @XmlElement(name = "Prefix", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        Prefix = prefix;
    }

    @XmlElement(name = "From", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public int getFrom() {
        return From;
    }

    public void setFrom(int from) {
        From = from;
    }

    @XmlElement(name = "To", namespace="dian:gov:co:facturaelectronica:Structures‐2‐1")
    public int getTo() {
        return To;
    }

    public void setTo(int to) {
        To = to;
    }

    public String getDocumentID(String documentID){
        return this.Prefix+documentID;
    }
}
