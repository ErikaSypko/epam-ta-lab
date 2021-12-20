package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    Properties property = new Properties();

    public PropertiesReader() {
        FileInputStream file;
        try {
            file = new FileInputStream("src/main/resources/config.properties");
            property.load(file);
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
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

