package page;

import decorator.Button;
import decorator.TextArea;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[@class='product__buy']//button")
    private Button buyButton;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private TextArea productPrice;

    public ProductPage() {
        super();
    }

    public int getProductPrice() {
        return Integer.valueOf(productPrice.getText());
    }

    public void clickOnBuyButton() {
        buyButton.safeClick();
    }
}
