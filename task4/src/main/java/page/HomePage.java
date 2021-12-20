package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(name = "search")
    private WebElement searchField;

    public HomePage() {
        super();
    }

    public void searchByKeyword(String keyword) {
        searchField.sendKeys(keyword, Keys.ENTER);
    }
}
