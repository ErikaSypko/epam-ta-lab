package decorator;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverSingleton;

public class Button extends Element {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void safeClick(long timeToWait) {
        try {
            super.click();
        } catch (Exception e) {
            waitUntilElementIsClickableAndVisible(timeToWait);
            super.click();
        }
    }

    private void waitUntilElementIsClickableAndVisible(long timeToWait) {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), timeToWait);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(webElement),
                ExpectedConditions.visibilityOf(webElement)));
    }
}
