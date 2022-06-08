package com.RTM.services.co.electronicInvoice.domain.model.productLine.DocumentLine;

import com.RTM.services.co.electronicInvoice.domain.model.Payment.AllowanceCharge;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Unit;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.Item;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.LineID;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.Price;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.PricingReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(propOrder={"ID","note","documentQuantity","lineExtensionAmount","pricingReference","allowanceCharge","taxTotals","item","price"})
public class DebitNoteLine implements DocumentLine{
    private LineID ID;
    private String note;
    private Unit debitedQuantity;
    private Money lineExtensionAmount;
    private PricingReference pricingReference;
    private List<AllowanceCharge> allowanceCharge;
    private List<TaxTotal> taxTotals;
    private Item item;
    private Price price;

    public DebitNoteLine(LineID ID, String note, Unit debitedQuantity, Money lineExtensionAmount, PricingReference pricingReference, List<AllowanceCharge> allowanceCharge, List<TaxTotal> taxTotals, Item item, Price price) {
        this.ID = ID;
        this.note = note;
        this.debitedQuantity = debitedQuantity;
        this.lineExtensionAmount = lineExtensionAmount;
        this.pricingReference = pricingReference;
        this.allowanceCharge = allowanceCharge;
        this.taxTotals = taxTotals;
        this.item = item;
        this.price = price;
    }

    public DebitNoteLine() {}
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public LineID getID() {
        return ID;
    }
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public String getNote() {
        return note;
    }
    @Override
    @XmlElement(name = "DebitedQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Unit getDocumentQuantity() {
        return debitedQuantity;
    }
    @XmlElement(name = "PriceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Money getLineExtensionAmount() {
        return lineExtensionAmount;
    }
    @XmlElement(name = "PricingReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public PricingReference getPricingReference() {
        return pricingReference;
    }
    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<AllowanceCharge> getAllowanceCharge() {
        return allowanceCharge;
    }
    @XmlElement(name = "TaxTotal", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }
    @XmlElement(name = "Item", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Item getItem() {
        return item;
    }
    @XmlElement(name = "Price", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public Price getPrice() {
        return price;
    }

    public void setID(LineID ID) {
        this.ID = ID;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public void setDebitedQuantity(Unit debitedQuantity) {
        this.debitedQuantity = debitedQuantity;
    }
    public void setLineExtensionAmount(Money lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }
    public void setPricingReference(PricingReference pricingReference) {
        this.pricingReference = pricingReference;
    }
    public void setAllowanceCharge(List<AllowanceCharge> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }
    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public void setPrice(Price price) {
        this.price = price;
    }
    public void setCurrencyCode(String currencyCode){
        this.lineExtensionAmount.setCurrencyID(currencyCode);
        if(this.pricingReference != null)this.pricingReference.getAlternativeConditionPrice().getPriceAmount().setCurrencyID(currencyCode);
        if(this.allowanceCharge != null)this.allowanceCharge.forEach(allowanceCharge -> allowanceCharge.setCurrencyCode(currencyCode));
        if(this.taxTotals != null)this.taxTotals.forEach(taxTotal -> taxTotal.setCurrencyCode(currencyCode));
        this.price.getPriceAmount().setCurrencyID(currencyCode);
    }
}
