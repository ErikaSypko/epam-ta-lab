package page;

import decorator.Button;
import decorator.CheckBox;
import decorator.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//input[@type='search']")
    private TextInput searchBrandField;

    @FindBy(css = "option[value='2: expensive']")
    private Button fromExpensiveToCheapOption;

    @FindBy(xpath = "(//span[@class=\"goods-tile__title\"])[1]")
    private Button firstProduct;

    @FindBy(xpath = "//div[@data-filter-name='producer']//input[@type='checkbox']/..")
    private List<CheckBox> brandsFiltersCheckbox;

    private By brandCheckbox() {
        return By.xpath("//div[@data-filter-name='producer']//input[@class='custom-checkbox']");
    }

    public ProductsPage() {
        super();
    }

    public void searchBrandByKeyword(String keyword) {
        searchBrandField.sendKeysInEmptyField(keyword);
    }

    public void clickOnBrandsFiltersCheckbox() {
        CheckBox.waitNumberOfElementsToBeLess(brandCheckbox());
        brandsFiltersCheckbox.get(0).setCheckBox();
    }

    public void clickOnFromExpensiveToCheapOption() {
        fromExpensiveToCheapOption.safeClick();
    }

    public void clickOnFirstProduct() {
        firstProduct.safeClick();
    }
}
