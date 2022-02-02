package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CertainLetterPage extends BasePage {
    @FindBy(id = "delete")
    private WebElement deleteButton;

    public void clickOnDeleteButton() {
        deleteButton.click();
    }
}
