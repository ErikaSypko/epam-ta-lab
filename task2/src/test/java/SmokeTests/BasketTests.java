package SmokeTests;

import Utils.TakeScreenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasketTests {
    private WebDriver driver;
    private int indicatedPrice = 319999;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkIfSumOfThreeItemsLessThenIndicated() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.xpath("//*[@class='sidebar sidebar_type_main']" +
                "//a[contains(@href,'computers-notebooks')]")).click();
        driver.findElement(By.cssSelector("a[title='Ноутбуки']")).click();
        driver.findElement(By.xpath("//label[@for='Apple']")).click();
        driver.findElement(By.cssSelector("option[value='2: expensive']")).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'p284631368')]/span[@class='goods-tile__title']"))).click();
        driver.findElement(By.xpath("//ul[@class='product-buttons']//button[contains(@class,' button button_with_icon')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'button_size_medium button_color_gray')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Rozetka Logo']"))).click();

        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Смарт"))).click();
        driver.findElement(By.linkText("Мобильные телефоны")).click();
        driver.findElement(By.name("searchline")).sendKeys("Apple");
        driver.findElement(By.xpath("//label[@for='Apple']")).click();
        driver.findElement(By.cssSelector("option[value='2: expensive']")).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'p318463294')]/span[@class='goods-tile__title']"))).click();
        try {
            driver.findElement(By.className("buy-button")).click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.findElement(By.className("buy-button")).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'button_size_medium button_color_gray')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Rozetka Logo']"))).click();

        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Смарт"))).click();
        driver.findElement(By.partialLinkText("Телев")).click();
        driver.findElement(By.id("LG")).findElement(By.xpath("./parent::a")).click();
        driver.findElement(By.cssSelector("option[value='2: expensive']")).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'p292190983')]/span[@class='goods-tile__title']"))).click();
        driver.findElement(By.xpath("//ul[@class='product-buttons']//button[contains(@class,' button button_with_icon')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'button_size_medium button_color_gray')]"))).click();

        driver.findElement(By.tagName("rz-cart")).click();
        TakeScreenshots.takeScreens(driver);
        int receivedPrice = Integer.valueOf(driver.findElement(By.xpath("//div[@class='cart-receipt__sum-price']/span")).getText());
        Assert.assertTrue(indicatedPrice > receivedPrice);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
