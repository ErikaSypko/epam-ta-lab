package googleTest;

import Utils.TakeScreenshots;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class SeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
    public void verifyPhoto() {
        WebElement webElement = driver.findElement(By.xpath("//a[contains(@href, 'img')]"));
        webElement.click();
        WebElement webElement2 = driver.findElement(By.name("q"));
        webElement2.click();
        webElement2.clear();
        webElement2.sendKeys("cheese" + Keys.ENTER);
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@alt,'How cheddar cheese')]")));
        Boolean imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", result);
        if (!imagePresent) System.out.println("Image not displayed.");
        else {
            System.out.println("Image displayed.");
            TakeScreenshots.takeScreens(driver);
        }
        String text = result.getAttribute("src");
        System.out.println(text);
        assertFalse(text.isEmpty());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
