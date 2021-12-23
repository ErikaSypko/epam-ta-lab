package util;

import model.FiltersRozetka;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import org.apache.log4j.Logger;

public class XmlToObject {
    final static Logger log = Logger.getLogger(XmlToObject.class.getName());

    public static FiltersRozetka convert() {
        try {
            File file = new File("src/main/resources/filtersRozetka.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(FiltersRozetka.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            FiltersRozetka filters = (FiltersRozetka) jaxbUnmarshaller.unmarshal(file);
            return filters;
        } catch (JAXBException e) {
            log.error(e);
        }
        return null;
    }
}
