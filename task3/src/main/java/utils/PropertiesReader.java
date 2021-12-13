package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesReader {
    Properties property = new Properties();
    private static Logger log = Logger.getLogger(PropertiesReader.class.getName());

    public PropertiesReader() {
        FileInputStream file;
        try {
            file = new FileInputStream("src/main/resources/config.properties");
            property.load(file);
            file.close();
        } catch (FileNotFoundException e) {
            log.log(Level.SEVERE, "Error message", e);
            System.out.println(e.getMessage());
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error message", e);
            System.out.println(e.getMessage());
        }
    }

    public String getURL() {
        return property.getProperty("URL");
    }

    public String getChromeDrivenName() {
        return property.getProperty("CHROME_DRIVER_NAME");
    }

    public String getChromeDrivenLocation() {
        return property.getProperty("CHROME_DRIVER_LOCATION");
    }
}
