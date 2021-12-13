package SmokeTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LaptopsPage;
import pages.ProductPage;
import utils.PropertiesReader;

import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    private PropertiesReader propertiesReader = new PropertiesReader();

    public BaseTests() throws IOException {
    }

    @BeforeTest
    public void profileSetUp() {
        System.setProperty(propertiesReader.getChromeDrivenName(), propertiesReader.getChromeDrivenLocation());
    }

    @BeforeMethod
    public void testsSetUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(propertiesReader.getURL());
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public LaptopsPage getLaptopsPage() {
        return new LaptopsPage(getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }
}
