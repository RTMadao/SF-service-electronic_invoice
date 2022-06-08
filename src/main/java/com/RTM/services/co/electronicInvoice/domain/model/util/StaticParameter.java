package com.RTM.services.co.electronicInvoice.domain.model.util;

import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.TaxScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "parameter")
@PropertySource(value = "classpath:staticParameter.yml")
public class StaticParameter {
    @Value("${UBLVersionID}")
    private String UBLVersionID;
    @Value("${identificationCodeListAgencyID}")
    private int identificationCodeListAgencyID;
    @Value("${identificationCodeListAgencyName}")
    private String identificationCodeListAgencyName;
    @Value("${identificationCodeValue}")
    private String identificationCodeValue;
    @Value("${identificationCodeListSchemeURI}")
    private String identificationCodeListSchemeURI;
    @Value("${invoiceProfileID}")
    private String invoiceProfileID;
    @Value("${CUDESchemeName}")
    private String CUDESchemeName;
    @Value("${xmlDirectoryPath}")
    private String xmlDirectoryPath;
    @Value("${assignCode}")
    private String assignCode;

    public StaticParameter() {
    }

    public String getUBLVersionID() {
        return UBLVersionID;
    }
    public int getIdentificationCodeListAgencyID() {
        return identificationCodeListAgencyID;
    }
    public String getIdentificationCodeListAgencyName() {
        return identificationCodeListAgencyName;
    }
    public String getIdentificationCodeCode() {
        return identificationCodeValue;
    }
    public String getIdentificationCodeListSchemeURI() {
        return identificationCodeListSchemeURI;
    }
    public String getInvoiceProfileID() {
        return invoiceProfileID;
    }
    public String getCUDESchemeName() {
        return CUDESchemeName;
    }
    public String getXmlDirectoryPath() {
        return xmlDirectoryPath;
    }
    public String getAssignCode() {
        return assignCode;
    }
    public PartyTaxScheme getDIANPartyData(){
        return new PartyTaxScheme(
                "Unidad Especial Dirección de Impuestos y Aduanas Nacionales",
                new ID(800197268,4,1),
                null,
                null,
                new TaxScheme("1","IVA")
        );
    }
}
