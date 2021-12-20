package SmokeTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;
import page.ProductsPage;
import page.ProductPage;
import util.PropertiesReader;
import util.WebDriverSingleton;


public class BaseTests {
    private PropertiesReader propertiesReader = new PropertiesReader();

    @BeforeMethod
    public void testsSetUP() {
        WebDriverSingleton.getInstance().manage().window().maximize();
        WebDriverSingleton.getInstance().get(propertiesReader.getURL());
    }

    @AfterMethod
    public void tearDown() {
        //WebDriverSingleton.close();
    }

    public HomePage getHomePage() {
        return new HomePage();
    }

    public ProductsPage getProductsPage() {
        return new ProductsPage();
    }

    public ProductPage getProductPage() {
        return new ProductPage();
    }
}
