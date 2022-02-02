package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenuPage extends BasePage {
    @FindBy(xpath = "//*[@text='Sent']")
    private WebElement sentLettersButton;

    @FindBy(xpath = "//*[@text='Drafts']")
    private WebElement draftsButton;

    @FindBy(xpath = "//*[@text='Trash']")
    private WebElement trashButton;

    public void clickOnSentLettersButton() {
        sentLettersButton.click();
    }

    public void clickOnDraftsButton() {
        draftsButton.click();
    }

    public void clickOnTrashButton() {
        trashButton.click();
    }
}
