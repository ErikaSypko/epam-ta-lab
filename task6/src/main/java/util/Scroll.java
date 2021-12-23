package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scroll {
    public static void scrollToTheTop() {
        WebElement element = WebDriverSingleton.getInstance().findElement(By.tagName("rz-header"));
        JavascriptExecutor js = (JavascriptExecutor) WebDriverSingleton.getInstance();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
