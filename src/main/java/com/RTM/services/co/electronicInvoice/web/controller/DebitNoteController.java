package com.RTM.services.co.electronicInvoice.web.controller;

import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.DebitNote;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.Invoice;
import com.RTM.services.co.electronicInvoice.domain.service.DebitNoteService;
import com.RTM.services.co.electronicInvoice.persistence.Entity.DocumentSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/electronic_document/debit_note")
public class DebitNoteController {
    @Autowired
    private DebitNoteService service;

    @PostMapping("/generate")
    public ResponseEntity<DebitNote> saveElectronicDocumentParameter(@RequestBody DebitNote userDebitNoteData){
        return new ResponseEntity<>(service.generateCreditNote(userDebitNoteData), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DocumentSummary>> getAll(){
        return new ResponseEntity<>(service.getDebitNoteList(), HttpStatus.OK);
    }
    @GetMapping("/get/pdf/{filePath}")
    public void getPdf(@PathVariable("filePath") String filePath, HttpServletResponse response){
        filePath = filePath.replaceAll("_","/");

        try {
            File file = new File(filePath);
            FileInputStream resource = new FileInputStream(file);

            org.apache.commons.io.IOUtils.copy(resource, response.getOutputStream());
            response.setContentType("application/pdf");

            response.flushBuffer();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
