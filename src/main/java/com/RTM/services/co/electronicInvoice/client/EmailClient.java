package com.RTM.services.co.electronicInvoice.client;

import com.RTM.services.co.electronicInvoice.domain.model.util.ElectronicDocumentEmailInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("email-service")
public interface EmailClient {
    @PostMapping("/email/electronic_document")
    ResponseEntity sendElectronicDocument(@RequestBody ElectronicDocumentEmailInfo info);
}
