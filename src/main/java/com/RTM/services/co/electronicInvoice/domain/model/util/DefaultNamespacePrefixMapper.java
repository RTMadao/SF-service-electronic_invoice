package com.RTM.services.co.electronicInvoice.domain.model.util;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import java.util.HashMap;
import java.util.Map;

public class DefaultNamespacePrefixMapper  extends NamespacePrefixMapper {

    private Map<String, String> namespaceMap = new HashMap<>();

    /**
     * Create mappings.1
     */
    public DefaultNamespacePrefixMapper() {
        namespaceMap.put("dian:gov:co:facturaelectronica:Structures‐2‐1", "sts");
        namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents‐2", "cbc");
        namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents‐2", "cac");
        namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents‐2", "ext");
        namespaceMap.put("http://uri.etsi.org/01903/v1.3.2#", "xades");
        namespaceMap.put("http://uri.etsi.org/01903/v1.4.1#", "xmlns");
        namespaceMap.put("http://www.w3.org/2000/09/xmldsig#", "ds");
    }

    /* (non-Javadoc)
     * Returning null when not found based on spec.
     * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
     */
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        return namespaceMap.getOrDefault(namespaceUri, suggestion);
    }
}
