package decorator;

import org.openqa.selenium.WebElement;

public class Button extends Element {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void safeClick() {
        try {
            super.click();
        } catch (Exception e) {
            waitVisibilityOfElement();
            waitUntilElementIsClickable();
            super.click();
        }
    }
}
