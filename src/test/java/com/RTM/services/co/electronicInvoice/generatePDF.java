package com.RTM.services.co.electronicInvoice;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.AppendDocument;
import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.BillingReferenceCN;
import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.BillingReferenceDN;
import com.RTM.services.co.electronicInvoice.domain.model.DateRange;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.InvoiceBuilder;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.Invoice;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator.InvoicePDFContext;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.AllowanceCharge;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.LegalMonetaryTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PaymentMeans;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PrepaidPayment.PrepaidPayment;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxCategory;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxSubtotal;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Unit;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DocumentCurrencyCode;
import com.RTM.services.co.electronicInvoice.domain.model.party.*;
import com.RTM.services.co.electronicInvoice.domain.model.party.PartyLegalEntity.CorporateRegistrationScheme;
import com.RTM.services.co.electronicInvoice.domain.model.party.PartyLegalEntity.PartyLegalEntity;
import com.RTM.services.co.electronicInvoice.domain.model.party.location.*;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.TaxScheme;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.*;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.DocumentLine.InvoiceLine;
import com.RTM.services.co.electronicInvoice.domain.service.ElectronicDocumentService;
import com.RTM.services.co.electronicInvoice.domain.service.DocumentGeneratorService;
import com.lowagie.text.DocumentException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class generatePDF {
    @Autowired
    private DocumentGeneratorService documentGeneratorService;
    @Autowired
    private ElectronicDocumentService electronicDocumentService;
    private Logger logger = LoggerFactory.getLogger(generatePDF.class);
    Invoice getInvoice(){
        Invoice invoice = new Invoice();
        invoice.setCustomizationID("01");
        invoice.setProfileExecutionID("2");
        invoice.setID("SF1");
        invoice.setDueDate("2022-06-20");
        invoice.setNote("Nota");
        invoice.setInvoiceTypeCode("01");
        invoice.setInvoicePeriod(new DateRange(new Date(),new Date()));
        invoice.setDocumentCurrencyCode(new DocumentCurrencyCode("COP"));

        invoice.setOrderReference(new AppendDocument("SETP990000101",new Date()));
        invoice.setDespatchDocumentReference(new AppendDocument("SETP990000101",new Date()));
        invoice.setReceiptDocumentReference(new AppendDocument("SETP990000101",new Date()));
        AppendDocument appendDocument = new AppendDocument("SETP990000101",new Date());
        appendDocument.setDocumentTypeCode("Code");
        invoice.setAdditionalDocumentReference(appendDocument);
        invoice.setDebitNoteReference(new BillingReferenceDN("SETP990000101","1dc661228f152332d876e1f1cd2042ecdea1804ed0da78f84dc9ee0938d69f17037dc53f97778ed2721d65c1fc3c73ac","2018-09-29"));
        invoice.setCreditNoteReference(new BillingReferenceCN("SETP990000101","1dc661228f152332d876e1f1cd2042ecdea1804ed0da78f84dc9ee0938d69f17037dc53f97778ed2721d65c1fc3c73ac","2018-09-29"));

        invoice.setAccountingSupplierParty(new AccountingSupplierParty());
        invoice.getAccountingSupplierParty().setAdditionalAccountID("1");
        invoice.setLineCountNumeric("2");
        invoice.getAccountingSupplierParty().setParty(
                new Party("AAA","Salcedo & Fawcett S.A.S.",
                        new Location(
                                new Address("13001","CARTAGENA","11001","BOLÍVAR","13",new AddressLine("BARRIO ESCALLON VILLA CALLE BUENOS AIRES"),new Contry("CO",new ContryName("Colombia","es")))
                        ),
                        new PartyTaxScheme("Salcedo & Fawcett S.A.S.",new ID(901249079,1,31),"0-99",
                                new Location(
                                        new Address("13001","CARTAGENA","11001","BOLÍVAR","13",new AddressLine("BARRIO ESCALLON VILLA CALLE BUENOS AIRES"),new Contry("CO",new ContryName("Colombia","es")))
                                ),
                                new TaxScheme("ZZ","No aplica")
                        ),
                        new PartyLegalEntity(new CorporateRegistrationScheme("SETP"),"FACTURADOR DE EJEMPLO",new ID(12345667,6,31)),
                        new Contact("Erick Sinu","320 553 7304","12431241","salcedo.fawcett@gmail.com","Test descripcion contacto")
                )
        );
        invoice.setAccountingCustomerParty(new AccountingCustomerParty());
        invoice.getAccountingCustomerParty().setAdditionalAccountID("1");
        invoice.getAccountingCustomerParty().setParty(
                new Party("AAA","Nombre Tienda",
                        new Location(
                                new Address("11001","Bogotá, D.c.","11001","Bogotá","11",new AddressLine("Kenndy"),new Contry("CO",new ContryName("Colombia","es")))
                        ),
                        new PartyTaxScheme("FACTURADOR DE EJEMPLO",new ID(12345667,6,31),"0-99",
                                new Location(
                                        new Address("11001","Bogotá, D.c.","11001","Bogotá","11",new AddressLine("Kenndy"),new Contry("CO",new ContryName("Colombia","es")))
                                ),
                                new TaxScheme("ZZ","No aplica")
                        ),
                        new PartyLegalEntity(new CorporateRegistrationScheme("SETP"),"FACTURADOR DE EJEMPLO",new ID(12345667,6,31)),
                        new Contact("Erick Sinu","9712311","12431241","ericka@mail.com","Test descripcion contacto")
                )
        );
        invoice.setTaxRepresentativeParty(new TaxRepresentativeParty(new ID(1234567,0,13)));
        List<PaymentMeans> paymentMeans = new ArrayList<>();
        paymentMeans.add(new PaymentMeans("2","42"));
        invoice.setPaymentMeans(paymentMeans);
        List<PrepaidPayment> prepaidPayments = new ArrayList<>();
        prepaidPayments.add(new PrepaidPayment(
                "SFR3123856",
                new Money(1000.00),
                "2018-09-29",
                "2018-09-29",
                "Prepago recibido"
        ));
        prepaidPayments.add(new PrepaidPayment(
                "SFR3123855",
                new Money(1200.00),
                "2018-09-29",
                "2018-09-29",
                "Prepago recibido"
        ));
        invoice.setPrepaidPayment(prepaidPayments);
        List<AllowanceCharge> allowanceCharges = new ArrayList<>();
        allowanceCharges.add(new AllowanceCharge(
                "1",
                false,
                "CODE",
                "D001 - Pago no despues de 14 días después de emitir la factura",
                10.00,
                new Money(100.00),
                new Money(1000.00)
        ));
        invoice.setAllowanceCharges(allowanceCharges);
        List<TaxTotal> taxTotals = new ArrayList<>();
        List<TaxSubtotal> taxSubtotals = new ArrayList<>();
        taxSubtotals.add(new TaxSubtotal(
                new Money(35.00),
                new Money(35.00),
                new Unit(100,"20"),
                new Money(100.00),
                new TaxCategory(
                        10.00,
                        new TaxScheme("01","IVA")
                )
        ));
        taxTotals.add(new TaxTotal(
                new Money(35.00),
                new Money(35.00),
                taxSubtotals
        ));
        invoice.setTaxTotal(taxTotals);
        invoice.setLegalMonetaryTotal(new LegalMonetaryTotal(
                new Money(350.00),
                new Money(350.00),
                new Money(385.00),
                new Money(100.00),
                new Money(0.00),
                new Money(0.00),
                new Money(285.00)
        ));
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        invoiceLines.add(new InvoiceLine(
                new LineID("1",null),
                "note",
                new Unit(2,"10","NUI"),
                new Money(200.00),
                new PricingReference(new AlternativeConditionPrice(new Money(100.00))),
                allowanceCharges,
                taxTotals,
                new Item("S0001 - Costo Directo", 1, "Marca", "modelo", null, null),
                new Price(new Money(100.00),new Unit(1,"10","NIU"))
        ));
        invoiceLines.add(new InvoiceLine(
                new LineID("2",null),
                "note",
                new Unit(1,"10","NUI"),
                new Money(150.00),
                new PricingReference(new AlternativeConditionPrice(new Money(100.00))),
                allowanceCharges,
                taxTotals,
                new Item("S0003 - Utilidad", 1, "Marca", "modelo", null, null),
                new Price(new Money(150.00),new Unit(1,"10","NIU"))
        ));
        invoice.setInvoiceLines(invoiceLines);
        return invoice;
    }
    @Test
    public void generatePDF(){
        Invoice invoice = (Invoice) electronicDocumentService.generateElectronicDocument(getInvoice(),new InvoiceBuilder());
        invoice.setValidationDateTime(new Date());
        //try {
        //    logger.warn(documentGeneratorService.generatePdf(new InvoicePDFContext(invoice)).getAbsolutePath());
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //} catch (DocumentException e) {
        //    throw new RuntimeException(e);
        //}
    }
}
