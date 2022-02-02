package page;

import driver.AndroidDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Constants;

public class SentLettersPage extends BasePage {
    @FindBy(xpath = "//*[@content-desc='Open navigation drawer']")
    private WebElement hamburgerMenuButton;

    public void clickOnSentLetter() {
        String letter = String.format("//android.view.View[contains(@content-desc, '%s, %s')]",
                Constants.SUBJECT, Constants.BODY);
        AndroidDriverSingleton.getDriver().findElement(By.xpath(letter)).click();
    }

    public void clickOnHamburgerMenuButton() {
        hamburgerMenuButton.click();
    }
}
