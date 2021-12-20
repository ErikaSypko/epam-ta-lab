package page;

import decorator.Button;
import decorator.TextArea;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'button_with_icon button_color_green')]")
    private Button buyButton;

    @FindBy(xpath = "//button[contains(@class,'modal__close')]")
    private Button closeBasketButton;

    @FindBy(tagName = "rz-cart")
    private Button basketButton;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private TextArea productPrice;

    public ProductPage() {
        super();
    }

    public Button getBuyButton() {
        return buyButton;
    }

    public Button getCloseBasketButton() {
        return closeBasketButton;
    }

    public Button getBasketButton() {
        return basketButton;
    }

    public int getProductPrice() {
        return Integer.valueOf(productPrice.getText());
    }

    public void clickOnBuyButton() {
        buyButton.safeClick(30);
    }

    public void clickOnCloseBasketButton() {
        closeBasketButton.safeClick(30);
    }

    public void clickOnBasketButton() {
        basketButton.safeClick(30);
    }
}
