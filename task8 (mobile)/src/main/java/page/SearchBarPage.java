package page;

import driver.AndroidDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBarPage extends BasePage {
    @FindBy(id = "og_apd_internal_image_view")
    private WebElement accountImage;

    @FindBy(xpath = "//*[contains(@resource-id,'has_selected_account')]" +
            "//*[contains(@resource-id,'account_name')]")
    private WebElement accountGmail;

    public String getAccountGmail() {
        return accountGmail.getText();
    }

    public void clickOnAccountImage() {
        waitUntilPresenceOfElementLocated(By.id("og_apd_internal_image_view"));
        accountImage.click();
    }

    public void switchAccount(String email) {
        String xpath = String.format("//*[contains(@content-desc,'%s')]", email);
        AndroidDriverSingleton.getDriver().findElement(By.xpath(xpath)).click();
    }
}
