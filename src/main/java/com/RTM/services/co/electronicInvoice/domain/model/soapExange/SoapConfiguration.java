package com.RTM.services.co.electronicInvoice.domain.model.soapExange;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.RTM.services.co.electronicInvoice.wsdl");
        return marshaller;
    }
    @Bean
    public SendBillSyncClient sendBillSyncClient(Jaxb2Marshaller marshaller) {
        SendBillSyncClient client = new SendBillSyncClient();
        client.setDefaultUri("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    @Bean
    public SendBillAsyncClient sendBillAsyncClient(Jaxb2Marshaller marshaller) {
        SendBillAsyncClient client = new SendBillAsyncClient();
        client.setDefaultUri("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    @Bean
    public GetStatusClient getStatusClient(Jaxb2Marshaller marshaller) {
        GetStatusClient client = new GetStatusClient();
        client.setDefaultUri("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
    @Bean
    public GetStatusZipClient getStatusZipClient(Jaxb2Marshaller marshaller) {
        GetStatusZipClient client = new GetStatusZipClient();
        client.setDefaultUri("https://vpfe-hab.dian.gov.co/WcfDianCustomerServices.svc?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
