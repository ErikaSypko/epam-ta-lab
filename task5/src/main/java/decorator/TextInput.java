package decorator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverSingleton;

public class TextInput extends Element {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeysInEmptyField(CharSequence keyToSend) {
        waitUntilElementIsClickable();
        webElement.clear();
        webElement.sendKeys(keyToSend, Keys.ENTER);
    }

    private void waitUntilElementIsClickable() {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webElement));
    }
}
