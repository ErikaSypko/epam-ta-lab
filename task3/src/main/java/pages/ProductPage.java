package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'button_with_icon button_color_green')]")
    private WebElement buyButton;

    @FindBy(xpath = "//button[contains(@class,'modal__close')]")
    private WebElement closeBasketButton;

    @FindBy(tagName = "rz-cart")
    private WebElement basketButton;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private WebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBuyButton() {
        return buyButton;
    }

    public WebElement getCloseBasketButton() {
        return closeBasketButton;
    }

    public int getProductPrice() {
        return Integer.valueOf(productPrice.getText());
    }

    public void clickOnBuyButton() {
        buyButton.click();
    }

    public void clickOnCloseBasketButton() {
        closeBasketButton.click();
    }

    public void clickOnBasketButton() {
        basketButton.click();
    }
}
