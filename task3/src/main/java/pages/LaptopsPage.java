package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LaptopsPage extends BasePage {
    @FindBy(xpath = "//div[@data-filter-name='producer']//input[@type='search']")
    private WebElement searchBrandField;

    @FindBy(xpath = "//div[@data-filter-name='producer']//li[contains(@class,'checkbox-filter__item')][1]")
    private WebElement firstFoundBrandByKeywordCheckbox;

    @FindBy(css = "option[value='2: expensive']")
    private WebElement fromExpensiveToCheapOption;

    @FindBy(xpath = "(//span[@class=\"goods-tile__title\"])[1]")
    private WebElement firstProduct;

    public By getXpathOfFirstLetterOfProduct() {
        return By.xpath("//p[@class='checkbox-filter__glyph ng-star-inserted']");
    }

    public By getXpathFirstProduct() {
        return By.xpath("(//span[@class=\"goods-tile__title\"])[1]");
    }

    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    public void searchBrandByKeyword(String keyword) {
        searchBrandField.clear();
        searchBrandField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnFirstFoundBrandByKeywordCheckbox() {
        firstFoundBrandByKeywordCheckbox.click();
    }

    public void clickOnFromExpensiveToCheapOption() {
        fromExpensiveToCheapOption.click();
    }

    public void clickOnFirstProduct() {
        this.waitIgnoringStaleElementExceptionAndClick(30, getXpathFirstProduct());
    }
}
