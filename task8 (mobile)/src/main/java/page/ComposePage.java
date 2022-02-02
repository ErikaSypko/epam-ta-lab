package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposePage extends BasePage {
    @FindBy(id = "android:id/button1")
    private WebElement gotItButton;

    @FindBy(id = "to")
    private WebElement toField;

    @FindBy(id = "subject")
    private WebElement subjectField;

    @FindBy(xpath = "//android.webkit.WebView//android.widget.EditText")
    private WebElement textField;

    @FindBy(id = "send")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private WebElement goBackButton;

    public void clickOnGotItButton() {
        gotItButton.click();
    }

    public void setRecipientField(String recipient) {
        toField.sendKeys(recipient);
    }

    public void setSubjectField(String subject) {
        subjectField.sendKeys(subject);
    }

    public void setTextField(String text) {
        textField.sendKeys(text);
    }

    public void clickOnSendButton() {
        sendButton.click();
    }

    public void clickOnGoBackButton() {
        goBackButton.click();
    }

}
