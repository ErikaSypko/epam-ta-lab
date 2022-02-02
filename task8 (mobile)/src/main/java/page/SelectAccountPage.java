package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectAccountPage extends BasePage {
    @FindBy(id = "action_done")
    private WebElement goToGmailButton;

    @FindBy(id = "account_address")
    private WebElement accountAddress;

    public void clickOnGoToGmailButton() {
        goToGmailButton.click();
    }

    public String getAccountAddress() {
        waitUntilVisibilityOfElement(accountAddress);
        return accountAddress.getText();
    }
}
