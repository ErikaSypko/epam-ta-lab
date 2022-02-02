package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrimaryPage extends BasePage {
    @FindBy(id = "gm_dismiss_button")
    private WebElement popupButton;

    @FindBy(id = "compose_button")
    private WebElement composeButton;

    @FindBy(xpath = "//*[@content-desc='Open navigation drawer']")
    private WebElement hamburgerMenuButton;

    public void clickOnPopupButton() {
        popupButton.click();
    }

    public void clickOnComposeButton() {
        composeButton.click();
    }

    public void clickOnHamburgerMenuButton() {
        hamburgerMenuButton.click();
    }
}
