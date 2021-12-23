package smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import util.PropertiesReader;
import util.WebDriverSingleton;
import util.XmlToObject;


public class BaseTests {
    private PropertiesReader propertiesReader = new PropertiesReader();

    @BeforeMethod
    public void testsSetUP() {
        WebDriverSingleton.getInstance().manage().window().maximize();
        WebDriverSingleton.getInstance().get(propertiesReader.getURL());
    }

    @DataProvider(name = "data", parallel = true)
    public static Object[][] getData() {
        return XmlToObject.convert().getFilters().stream()
                .map(product -> new Object[]{product.getProduct(),
                        product.getCompany(), product.getPrice()})
                .toArray(Object[][]::new);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.close();
    }
}
