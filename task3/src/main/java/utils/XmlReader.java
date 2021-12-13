package utils;

import models.FilterRozetka;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlReader {
    private static Logger log = Logger.getLogger(XmlReader.class.getName());

    public FilterRozetka getData() {
        try {
            String filePath = "src/main/resources/filterRozetka.xml";
            File file = new File(filePath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbf.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            String product = doc.getElementsByTagName("product").item(0).getTextContent();
            String company = doc.getElementsByTagName("company").item(0).getTextContent();
            int price = Integer.parseInt(doc.getElementsByTagName("price").item(0).getTextContent());
            return new FilterRozetka(product, company, price);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error message", e);
            System.out.println(e.getMessage());
        }
        return null;
    }
}
