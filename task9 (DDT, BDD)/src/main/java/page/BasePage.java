package page;

import decorator.CustomFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import util.WebDriverSingleton;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverSingleton.getInstance()), this);
    }
}
