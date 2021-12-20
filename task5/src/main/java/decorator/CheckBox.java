package decorator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverSingleton;


public class CheckBox extends Element {
    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    public void setCheckBox() {
        try {
            if (!webElement.isSelected())
                webElement.click();
        } catch (ElementNotInteractableException e) {
            clickWithJSExecutor();
        }

    }

    private void clickWithJSExecutor() {
        ((JavascriptExecutor) WebDriverSingleton.getInstance()).executeScript(
                "arguments[0].click()", webElement
        );
    }

    public void waitNumberOfElementsToBeLess(By locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, 5));
    }
}
