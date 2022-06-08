package com.RTM.services.co.electronicInvoice.domain.model.Payment.tax;

import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.TaxScheme;
import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;

import javax.xml.bind.annotation.XmlElement;

public class TaxCategory {
    private double Percent;
    private TaxScheme taxScheme;

    public TaxCategory() {}

    public TaxCategory(double percent, TaxScheme taxScheme) {
        Percent = percent;
        this.taxScheme = taxScheme;
    }
    @XmlElement(name = "Percent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getPercent() {
        return DataFormatService.setDoubleFormat(Percent);
    }
    @XmlElement(name = "TaxScheme", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public TaxScheme getTaxScheme() {
        return taxScheme;
    }

    public void setPercent(double percent) {
        Percent = percent;
    }
    public void setTaxScheme(TaxScheme taxScheme) {
        this.taxScheme = taxScheme;
    }
}
