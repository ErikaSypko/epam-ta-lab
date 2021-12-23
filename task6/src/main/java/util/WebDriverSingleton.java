package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    final static Logger log = Logger.getLogger(WebDriverSingleton.class.getName());
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }

        WebDriver instance;
        PropertiesReader propertiesReader = new PropertiesReader();
        String driverName = propertiesReader.getChromeDriverName();
        String driverLocation = propertiesReader.getChromeDriverLocation();
        System.setProperty(driverName, driverLocation);
        instance = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        };
        webDriverThreadLocal.set(instance);
        return webDriverThreadLocal.get();
    }

    public static void close() {
        try {
            if (webDriverThreadLocal != null) {
                webDriverThreadLocal.get().quit();
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}
