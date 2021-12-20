package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverSingleton;

import static java.awt.SystemColor.window;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public void scrollToTheTop() {
        WebElement element = driver.findElement(By.tagName("rz-header"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitClickableOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitNumberOfElementsToBeLess(long timeToWait, By locator, int count) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, count));
    }

    public void waitIgnoringStaleElementExceptionAndClick(long timeToWait, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.ignoring(StaleElementReferenceException.class)
                .until(driver -> {
                    driver.findElement(locator).click();
                    return true;
                });
    }
}
