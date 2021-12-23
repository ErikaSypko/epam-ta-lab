package util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    Properties property = new Properties();
    final static Logger log = Logger.getLogger(PropertiesReader.class.getName());

    public PropertiesReader() {
        FileInputStream file;
        try {
            file = new FileInputStream("src/main/resources/config.properties");
            property.load(file);
            file.close();
        } catch (FileNotFoundException e) {
           log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
    }

    public String getURL() {
        return property.getProperty("URL");
    }

    public String getChromeDriverName() {
        return property.getProperty("CHROME_DRIVER_NAME");
    }

    public String getChromeDriverLocation() {
        return property.getProperty("CHROME_DRIVER_LOCATION");
    }
}

