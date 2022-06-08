package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.domain.model.util.DefaultNamespacePrefixMapper;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;

@Service
public class XMLCastService {
    public Marshaller marshallXML(JAXBContext jaxbContext) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
        marshaller.setProperty(CharacterEscapeHandler.class.getName(),
                (CharacterEscapeHandler) (ch, start, length, isAttVal, out) -> out.write(ch, start, length));
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }
    public Unmarshaller unmarshallXML(JAXBContext jaxbContext) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller;
    }
    public void toFile(JAXBContext jaxbContext, Object obj, String filePath){
        try {
            this.marshallXML(jaxbContext).marshal(obj, new File(filePath));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString(JAXBContext jaxbContext, Object obj){
        StringWriter sw = new StringWriter();
        try {
            this.marshallXML(jaxbContext).marshal(obj, sw);
            return sw.toString().replaceAll("\n[ ]{1,}","");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public Object unmarshall(JAXBContext jaxbContext, InputStream file){
        try {
            return this.unmarshallXML(jaxbContext).unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
