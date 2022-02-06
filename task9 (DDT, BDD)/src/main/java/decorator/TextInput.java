package decorator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextInput extends Element {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeysInEmptyField(CharSequence keyToSend) {
        waitVisibilityOfElement();
        webElement.clear();
        webElement.sendKeys(keyToSend, Keys.ENTER);
    }
}
