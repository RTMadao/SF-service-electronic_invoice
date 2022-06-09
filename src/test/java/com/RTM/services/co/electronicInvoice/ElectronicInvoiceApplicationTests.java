package com.RTM.services.co.electronicInvoice;

import com.RTM.services.co.electronicInvoice.domain.model.AppendDocument.*;
import com.RTM.services.co.electronicInvoice.domain.model.DateRange;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentBuilder.*;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.DocumentResponse;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.LineReference;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.LineResponse;
import com.RTM.services.co.electronicInvoice.domain.model.DocumentResponse.Response;
import com.RTM.services.co.electronicInvoice.domain.model.ElectronicDocument.*;
import com.RTM.services.co.electronicInvoice.domain.model.ID;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.AllowanceCharge;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.LegalMonetaryTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.Money;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PaymentMeans;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.PrepaidPayment.PrepaidPayment;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxCategory;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxSubtotal;
import com.RTM.services.co.electronicInvoice.domain.model.Payment.tax.TaxTotal;
import com.RTM.services.co.electronicInvoice.domain.model.Unit;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DiscrepancyResponse;
import com.RTM.services.co.electronicInvoice.domain.model.documentData.DocumentCurrencyCode;
import com.RTM.services.co.electronicInvoice.domain.model.party.*;
import com.RTM.services.co.electronicInvoice.domain.model.party.PartyLegalEntity.CorporateRegistrationScheme;
import com.RTM.services.co.electronicInvoice.domain.model.party.PartyLegalEntity.PartyLegalEntity;
import com.RTM.services.co.electronicInvoice.domain.model.party.location.*;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.PartyTaxScheme;
import com.RTM.services.co.electronicInvoice.domain.model.party.taxScheme.TaxScheme;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.*;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.DocumentLine.CreditNoteLine;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.DocumentLine.DebitNoteLine;
import com.RTM.services.co.electronicInvoice.domain.model.productLine.DocumentLine.InvoiceLine;
import com.RTM.services.co.electronicInvoice.domain.service.DataFormatService;
import com.RTM.services.co.electronicInvoice.domain.service.ElectronicDocumentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ElectronicInvoiceApplicationTests {

	@Autowired
	private ElectronicDocumentService electronicDocumentService;
/*
	Invoice getInvoice(){
		Invoice invoice = new Invoice();
		invoice.setCustomizationID("01");
		invoice.setProfileExecutionID("2");
		//invoice.setID("SF1");
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
		/*invoice.getAccountingSupplierParty().setParty(
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
				true,
				"CODE",
				"Descuento",
				10.00,
				new Money(100.00),
				new Money(1000.00)
		));
		invoice.setAllowanceCharges(allowanceCharges);
		List<TaxTotal> taxTotals = new ArrayList<>();
		List<TaxSubtotal> taxSubtotals = new ArrayList<>();
		taxSubtotals.add(new TaxSubtotal(
				new Money(100.00),
				new Money(100.00),
				new Unit(100,"20"),
				new Money(100.00),
				new TaxCategory(
						100.00,
						new TaxScheme("01","IVA")
				)
		));
		taxTotals.add(new TaxTotal(
				new Money(100.00),
				new Money(100.00),
				taxSubtotals
		));
		invoice.setTaxTotal(taxTotals);
		invoice.setLegalMonetaryTotal(new LegalMonetaryTotal(
				new Money(100.00),
				new Money(100.00),
				new Money(10.00),
				new Money(10.00),
				new Money(150.00),
				new Money(10.00),
				new Money(150.00)
		));
		List<InvoiceLine> invoiceLines = new ArrayList<>();
		invoiceLines.add(new InvoiceLine(
				new LineID("1",null),
				"note",
				new Unit(2,"10"),
				new Money(100.00),
				new PricingReference(new AlternativeConditionPrice(new Money(100.00))),
				allowanceCharges,
				taxTotals,
				new Item("description", 1, "Marca", "modelo", null, null),
				new Price(new Money(100.00),new Unit(1,"10"))
		));
		invoice.setInvoiceLines(invoiceLines);
		return invoice;
	}
	@Test
	void generateInvoiceXml() throws JAXBException, FileNotFoundException {
		//electronicDocumentService.invoiceToXML((Invoice) electronicDocumentService.generateElectronicDocument(this.getInvoice(), new InvoiceBuilder()));
	}
	@Test
	void generateCreditNoteXml(){
		CreditNote creditNote = new CreditNote();

		creditNote.setCustomizationID("01");
		creditNote.setProfileExecutionID("2");
		creditNote.setInvoicePeriod(new DateRange(new Date(),new Date()));
		creditNote.setCreditNoteTypeCode("94");
		creditNote.setNote("note");
		creditNote.setDocumentCurrencyCode(new DocumentCurrencyCode("COP"));
		creditNote.setLineCountNumeric("2");
		creditNote.setDiscrepancyResponse(new DiscrepancyResponse("element","02","Descriopcion"));

		creditNote.setInvoiceReference(new BillingReferenceInvoice("SETP990000101","1dc661228f152332d876e1f1cd2042ecdea1804ed0da78f84dc9ee0938d69f17037dc53f97778ed2721d65c1fc3c73ac","2018-09-29"));
		creditNote.setOrderReference(new AppendDocument("SETP990000101",new Date()));
		creditNote.setDespatchDocumentReference(new AppendDocument("SETP990000101",new Date()));
		creditNote.setReceiptDocumentReference(new AppendDocument("SETP990000101",new Date()));
		AppendDocument appendDocument = new AppendDocument("SETP990000101",new Date());
		appendDocument.setDocumentTypeCode("Code");
		creditNote.setAdditionalDocumentReference(appendDocument);

		creditNote.setAccountingSupplierParty(new AccountingSupplierParty());
		creditNote.getAccountingSupplierParty().setAdditionalAccountID("1");
		creditNote.setLineCountNumeric("2");
		creditNote.getAccountingSupplierParty().setParty(
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
		creditNote.setAccountingCustomerParty(new AccountingCustomerParty());
		creditNote.getAccountingCustomerParty().setAdditionalAccountID("1");
		creditNote.getAccountingCustomerParty().setParty(
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
		creditNote.setTaxRepresentativeParty(new TaxRepresentativeParty(new ID(1234567,0,13)));
		List<PaymentMeans> paymentMeans = new ArrayList<>();
		paymentMeans.add(new PaymentMeans("2","42"));
		creditNote.setPaymentMeans(paymentMeans);
		List<AllowanceCharge> allowanceCharges = new ArrayList<>();
		allowanceCharges.add(new AllowanceCharge(
				"1",
				true,
				"CODE",
				"Descuento",
				10.00,
				new Money(100.00),
				new Money(1000.00)
		));
		creditNote.setAllowanceCharges(allowanceCharges);
		List<TaxTotal> taxTotals = new ArrayList<>();
		List<TaxSubtotal> taxSubtotals = new ArrayList<>();
		taxSubtotals.add(new TaxSubtotal(
				new Money(100.00),
				new Money(100.00),
				new Unit(100,"20"),
				new Money(100.00),
				new TaxCategory(
						100.00,
						new TaxScheme("01","IVA")
				)
		));
		taxTotals.add(new TaxTotal(
				new Money(100.00),
				new Money(100.00),
				taxSubtotals
		));
		creditNote.setTaxTotal(taxTotals);
		creditNote.setLegalMonetaryTotal(new LegalMonetaryTotal(
				new Money(100.00),
				new Money(100.00),
				new Money(10.00),
				new Money(10.00),
				new Money(150.00),
				new Money(10.00),
				new Money(150.00)
		));
		List<CreditNoteLine> creditNoteLines = new ArrayList<>();
		creditNoteLines.add(new CreditNoteLine(
				new LineID("1",null),
				"note",
				new Unit(2,"10"),
				new Money(100.00),
				new PricingReference(new AlternativeConditionPrice(new Money(100.00))),
				allowanceCharges,
				taxTotals,
				new Item("description", 1, "Marca", "modelo", null, null),
				new Price(new Money(100.00),new Unit(1,"10"))
		));
		creditNote.setCreditNoteLines(creditNoteLines);
		//try {
		//	//electronicDocumentService.creditNoteToXML(electronicDocumentService.generateElectronicDocument(creditNote, new CreditNoteBuilder()));
		//} catch (JAXBException e) {
		//	throw new RuntimeException(e);
		//}
	}
	@Test
	void generateDebitNoteXml(){
		DebitNote debitNote = new DebitNote();

		debitNote.setCustomizationID("01");
		debitNote.setProfileExecutionID("2");
		debitNote.setInvoicePeriod(new DateRange(new Date(),new Date()));
		debitNote.setNote("note");
		debitNote.setDocumentCurrencyCode(new DocumentCurrencyCode("COP"));
		debitNote.setLineCountNumeric("2");
		debitNote.setDiscrepancyResponse(new DiscrepancyResponse("element","02","Descriopcion"));

		debitNote.setInvoiceReference(new BillingReferenceInvoice("SETP990000101","1dc661228f152332d876e1f1cd2042ecdea1804ed0da78f84dc9ee0938d69f17037dc53f97778ed2721d65c1fc3c73ac","2018-09-29"));
		debitNote.setOrderReference(new AppendDocument("SETP990000101",new Date()));
		debitNote.setDespatchDocumentReference(new AppendDocument("SETP990000101",new Date()));
		debitNote.setReceiptDocumentReference(new AppendDocument("SETP990000101",new Date()));
		InvoiceDocumentReference invoiceDocumentReference = new InvoiceDocumentReference("SETP990000101","1dc661228f152332d876e1f1cd2042ecdea1804ed0da78f84dc9ee0938d69f17037dc53f97778ed2721d65c1fc3c73ac","2018-09-29");
		invoiceDocumentReference.setDocumentTypeCode("Code");
		debitNote.setAdditionalDocumentReference(invoiceDocumentReference);

		debitNote.setAccountingSupplierParty(new AccountingSupplierParty());
		debitNote.getAccountingSupplierParty().setAdditionalAccountID("1");
		debitNote.setLineCountNumeric("2");
		debitNote.getAccountingSupplierParty().setParty(
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
		debitNote.setAccountingCustomerParty(new AccountingCustomerParty());
		debitNote.getAccountingCustomerParty().setAdditionalAccountID("1");
		debitNote.getAccountingCustomerParty().setParty(
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
		debitNote.setTaxRepresentativeParty(new TaxRepresentativeParty(new ID(1234567,0,13)));
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
		debitNote.setPrepaidPayment(prepaidPayments);
		List<AllowanceCharge> allowanceCharges = new ArrayList<>();
		allowanceCharges.add(new AllowanceCharge(
				"1",
				true,
				"CODE",
				"Descuento",
				10.00,
				new Money(100.00),
				new Money(1000.00)
		));
		debitNote.setAllowanceCharges(allowanceCharges);
		List<TaxTotal> taxTotals = new ArrayList<>();
		List<TaxSubtotal> taxSubtotals = new ArrayList<>();
		taxSubtotals.add(new TaxSubtotal(
				new Money(100.00),
				new Money(100.00),
				new Unit(100,"20"),
				new Money(100.00),
				new TaxCategory(
						100.00,
						new TaxScheme("01","IVA")
				)
		));
		taxTotals.add(new TaxTotal(
				new Money(100.00),
				new Money(100.00),
				taxSubtotals
		));
		debitNote.setTaxTotal(taxTotals);
		debitNote.setLegalMonetaryTotal(new LegalMonetaryTotal(
				new Money(100.00),
				new Money(100.00),
				new Money(10.00),
				new Money(10.00),
				new Money(150.00),
				new Money(10.00),
				new Money(150.00)
		));
		List<DebitNoteLine> debitNoteLines = new ArrayList<>();
		debitNoteLines.add(new DebitNoteLine(
				new LineID("1",null),
				"note",
				new Unit(2,"10"),
				new Money(100.00),
				new PricingReference(new AlternativeConditionPrice(new Money(100.00))),
				allowanceCharges,
				taxTotals,
				new Item("description", 1, "Marca", "modelo", null, null),
				new Price(new Money(100.00),new Unit(1,"10"))
		));
		debitNote.setDebitNoteLines(debitNoteLines);
		//try {
		//	electronicDocumentService.debitNoteToXML(electronicDocumentService.generateElectronicDocument(debitNote, new DebitNoteBuilder()));
		//} catch (JAXBException e) {
		//	throw new RuntimeException(e);
		//}
	}
	@Test
	void generateApplicationResponseXml(){
		Invoice invoice = this.getInvoice();
		PartyTaxScheme reciberParty = new PartyTaxScheme("FACTURADOR DE EJEMPLO",new ID(12345667,6,31),"0-99",
						null,
						new TaxScheme("ZZ","No aplica")
		);
		List<Response> responseList = new ArrayList<>();
		responseList.add(new Response("02","Validado"));
		DocumentResponse response = new DocumentResponse(
				new Response("02","Validado"),
				new InvoiceDocumentReference("ST2","ikujsdfguisdf7s5fs787s7896", DataFormatService.setDateFormat(new Date())),
				new LineResponse(
						new LineReference(1),
						responseList
				)
		);
		//try {
		//	electronicDocumentService.applicationResponseToXML(electronicDocumentService.generateApplicationResponse(invoice, reciberParty,response));
		//} catch (JAXBException e) {
		//	throw new RuntimeException(e);
		//}
	}
	@Test
	void generateAttachedDocumentXml(){
		Invoice invoice = (Invoice) electronicDocumentService.generateElectronicDocument(this.getInvoice(),new InvoiceBuilder());
		PartyTaxScheme reciberParty = new PartyTaxScheme("FACTURADOR DE EJEMPLO",new ID(12345667,6,31),"0-99",
				null,
				new TaxScheme("ZZ","No aplica")
		);
		List<Response> responseList = new ArrayList<>();
		responseList.add(new Response("02","Validado"));
		DocumentResponse response = new DocumentResponse(
				new Response("02","Validado"),
				new InvoiceDocumentReference(invoice.getID(),invoice.getCUDE().getValue(),invoice.getIssueDate()),
				new LineResponse(
						new LineReference(1),
						responseList
				)
		);
		try {
			String documentXML = electronicDocumentService.getInvoiceRootNode(invoice);
			AttachedDocument attachedDocument = electronicDocumentService.generateAttachedDocument(invoice,documentXML);
			ApplicationResponse applicationResponse = electronicDocumentService.generateApplicationResponse(invoice,reciberParty,reciberParty,response);
			attachedDocument = electronicDocumentService.generateAttachedDocumentResponse(attachedDocument,invoice,
					electronicDocumentService.getApplicationResponseRootNode(applicationResponse),"02");
			//electronicDocumentService.attachedDocumentToXML(attachedDocument);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}*/
}
