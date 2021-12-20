package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBrandField;

    @FindBy(xpath = "//div[@data-filter-name='producer']//li[contains(@class,'checkbox-filter__item')][1]")
    private WebElement firstFoundBrandByKeywordCheckbox;

    @FindBy(css = "option[value='2: expensive']")
    private WebElement fromExpensiveToCheapOption;

    @FindBy(xpath = "(//span[@class=\"goods-tile__title\"])[1]")
    private WebElement firstProduct;

    public WebElement getFirstProduct() {
        return firstProduct;
    }

    public By getXpathOfFirstLetterOfProduct() {
        return By.xpath("//p[@class='checkbox-filter__glyph ng-star-inserted']");
    }

    public By getXpathFirstProduct() {
        return By.xpath("(//span[@class=\"goods-tile__title\"])[1]");
    }

    public ProductsPage() {
        super();
    }

    public void searchBrandByKeyword(String keyword) {
        searchBrandField.clear();
        try {
            searchBrandField.sendKeys(keyword, Keys.ENTER);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            searchBrandField.sendKeys(keyword, Keys.ENTER);
        }
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
