package steps;

import page.ProductPage;
import org.testng.Assert;


public class ProductPageBL {
    private ProductPage productPage;

    public ProductPageBL() {
        this.productPage = new ProductPage();
    }

    public ProductPageBL clickOnBuyButton() {
        productPage.clickOnBuyButton();
        return this;
    }

    public void checkPrice(String price) {
        Assert.assertTrue(productPage.getProductPrice() < Integer.valueOf(price));
    }


}
