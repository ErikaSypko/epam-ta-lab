package page;

import decorator.TextInput;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(name = "search")
    private TextInput searchField;

    public HomePage() {
        super();
    }

    public void searchByKeyword(String keyword) {
        searchField.sendKeysInEmptyField(keyword);
    }
}
