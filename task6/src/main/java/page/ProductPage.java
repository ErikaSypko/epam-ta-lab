package page;

import decorator.Button;
import decorator.TextArea;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'button_with_icon button_color_green')]")
    private Button buyButton;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private TextArea productPrice;

    @FindBy(xpath = "//a[contains(@class,'button_size_medium button_color_gray')]")
    private Button continueShoppingButton;

    @FindBy(tagName = "rz-cart")
    private Button cartButton;

    public ProductPage() {
        super();
    }

    public int getProductPrice() {
        return Integer.valueOf(productPrice.getText());
    }

    public void clickOnBuyButton() {
        buyButton.safeClick();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.safeClick();
    }

    public void clickOnCartButton() {
        cartButton.safeClick();
    }
}
