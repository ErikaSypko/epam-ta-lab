package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage {
    @FindBy(id = "welcome_tour_got_it")
    private WebElement gotItButton;

    public void clickOnGotItButton() {
        gotItButton.click();
    }
}
