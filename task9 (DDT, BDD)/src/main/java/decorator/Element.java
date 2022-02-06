package decorator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverSingleton;

import java.util.List;

public class Element implements WebElement, IElement {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    protected void waitUntilElementIsClickable() {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitVisibilityOfElement() {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void clickWithJSExecutor() {
        ((JavascriptExecutor) WebDriverSingleton.getInstance()).executeScript(
                "arguments[0].click()", webElement
        );
    }

    public static void waitNumberOfElementsToBeLess(By locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 15);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, 15));
    }
}
