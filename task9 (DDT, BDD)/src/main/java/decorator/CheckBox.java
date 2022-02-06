package decorator;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

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
}