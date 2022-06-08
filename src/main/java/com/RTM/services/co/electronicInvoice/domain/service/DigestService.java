package com.RTM.services.co.electronicInvoice.domain.service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class DigestService {
    public static String sha384(String value){
        return DigestUtils.sha384Hex(value);
    }
    public static String digest(String value){
        return Base64.encodeBase64String(DigestUtils.sha256Hex(value).getBytes());
    }
}
