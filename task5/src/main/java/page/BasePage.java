package page;

import decorator.CustomFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import util.WebDriverSingleton;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverSingleton.getInstance()), this);
    }

    public void scrollToTheTop() {
        WebElement element = WebDriverSingleton.getInstance().findElement(By.tagName("rz-header"));
        JavascriptExecutor js = (JavascriptExecutor) WebDriverSingleton.getInstance();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
