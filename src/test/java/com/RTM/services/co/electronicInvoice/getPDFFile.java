package com.RTM.services.co.electronicInvoice;

import com.RTM.services.co.electronicInvoice.domain.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class getPDFFile {
    @Autowired
    private InvoiceService invoiceService;
    /*
    @Test
    public void getDataFromXml(){
        invoiceService.getInvoicePDF("/home/madao/Documentos/proyectos/Proyecto grado/ElectronicDocuments/invoice/fv09012490791232200013.xml");
    }*/
}
