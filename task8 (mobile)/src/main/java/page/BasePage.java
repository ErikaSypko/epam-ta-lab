package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.AndroidDriverSingleton;

import java.time.Duration;

public class BasePage {
    private WebDriverWait wait;
    private TouchAction touchAction = new TouchAction(AndroidDriverSingleton.getDriver());


    public BasePage() {
        wait = new WebDriverWait(AndroidDriverSingleton.getDriver(), 10);
        PageFactory.initElements(AndroidDriverSingleton.getDriver(), this);
    }

    public void waitUntilVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilPresenceOfElementLocated(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void slideDown() {
        var size = AndroidDriverSingleton.getDriver().manage().window().getSize();
        int startY = (int) (size.height * 0.20);
        int endY = (int) (size.height * 0.60);
        int startX = size.width / 2;
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
                .moveTo(PointOption.point(startX, endY)).release().perform();
    }

    public void slideUp() {
        var size = AndroidDriverSingleton.getDriver().manage().window().getSize();
        int startY = (int) (size.height * 0.60);
        int endY = (int) (size.height * 0.20);
        int startX = size.width / 2;
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
                .moveTo(PointOption.point(startX, endY)).release().perform();
    }
}
