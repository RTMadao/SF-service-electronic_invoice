package com.RTM.services.co.electronicInvoice.domain.service;

import com.RTM.services.co.electronicInvoice.domain.model.PDGGenerator.DocumentPDFContext;
import com.RTM.services.co.electronicInvoice.domain.model.util.StaticParameter;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class DocumentGeneratorService {
    private static final String PDF_RESOURCES = "/pdf-resources/";
    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    StaticParameter staticParameter;
    private String loadAndFillTemplate(DocumentPDFContext documentContext) {
        return templateEngine.process(documentContext.getTemplate(), documentContext.getContext());
    }
    private File renderPdf(String html, String docName) throws IOException, DocumentException {
        File file = File.createTempFile(docName, ".pdf",new File(staticParameter.getXmlDirectoryPath()+File.separator+"pdf"));
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        return file;
    }
    public File generatePdf(DocumentPDFContext documentContext, String docname) throws IOException, DocumentException {
        String html = loadAndFillTemplate(documentContext);
        return renderPdf(html,docname);
    }
    public String generateZipFile(List<File> files, String fileName){
        String zipPath = staticParameter.getXmlDirectoryPath()+File.separator +"tmp"+File.separator+fileName;
        new File(zipPath).delete();

        try (FileOutputStream fos = new FileOutputStream(zipPath);
             ZipOutputStream zos = new ZipOutputStream(
                     new BufferedOutputStream(fos))) {
            zos.setLevel(9); //level of compression

            for (File file : files) {
                if (file.exists()) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipEntry entry = new ZipEntry(file.getName());
                        zos.putNextEntry(entry);
                        for (int c = fis.read(); c != -1; c = fis.read()) {
                            zos.write(c);
                        }
                        zos.flush();
                    }
                }
            }

            File zip = new File(zipPath);
            if (!zip.exists()) {
                throw new FileNotFoundException("The created zip file could not be found");
            }

            return zipPath;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
