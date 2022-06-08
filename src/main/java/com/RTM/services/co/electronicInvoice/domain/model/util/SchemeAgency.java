package com.RTM.services.co.electronicInvoice.domain.model.util;

import javax.xml.bind.annotation.XmlAttribute;

public interface SchemeAgency {
    default int SchemeAgencyID() {
        return 195;
    }
    default String SchemeAgencyName() {
        return "CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)";
    }
}
