package com.RTM.services.co.electronicInvoice.domain.model.productLine;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Item {
    private String description;
    private int PackSizeNumeric;
    private String BrandName;
    private String ModelName;
    private SellersItemIdentification sellersItemIdentification;
    private List<AdditionalItemProperty> additionalItemProperty;

    public Item(String description, int packSizeNumeric, String brandName, String modelName, SellersItemIdentification sellersItemIdentification, List<AdditionalItemProperty> additionalItemProperty) {
        this.description = description;
        PackSizeNumeric = packSizeNumeric;
        BrandName = brandName;
        ModelName = modelName;
        this.sellersItemIdentification = sellersItemIdentification;
        this.additionalItemProperty = additionalItemProperty;
    }

    public Item() {}
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getDescription() {
        return description;
    }
    @XmlElement(name = "PackSizeNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public int getPackSizeNumeric() {
        return PackSizeNumeric;
    }
    @XmlElement(name = "BrandName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2")
    public String getBrandName() {
        return BrandName;
    }
    @XmlElement(name = "ModelName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public String getModelName() {
        return ModelName;
    }
    @XmlElement(name = "SellersItemIdentification", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public SellersItemIdentification getSellersItemIdentification() {
        return sellersItemIdentification;
    }
    @XmlElement(name = "AdditionalItemProperty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2")
    public List<AdditionalItemProperty> getAdditionalItemProperty() {
        return additionalItemProperty;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setPackSizeNumeric(int packSizeNumeric) {
        PackSizeNumeric = packSizeNumeric;
    }
    public void setBrandName(String brandName) {
        BrandName = brandName;
    }
    public void setModelName(String modelName) {
        ModelName = modelName;
    }
    public void setSellersItemIdentification(SellersItemIdentification sellersItemIdentification) {
        this.sellersItemIdentification = sellersItemIdentification;
    }
    public void setAdditionalItemProperty(List<AdditionalItemProperty> additionalItemProperty) {
        this.additionalItemProperty = additionalItemProperty;
    }
}
