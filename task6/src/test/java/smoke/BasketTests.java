package smoke;

import org.testng.annotations.Test;
import steps.HomePageBl;
import steps.ProductsPageBL;


public class BasketTests extends BaseTests {
    @Test(dataProvider = "data")
    public void checkIfItemPriceLessThenIndicated(String product, String company, String price) {
        HomePageBl homePageBl = new HomePageBl();

        ProductsPageBL productsPageBL = homePageBl.searchByKeyword(product);

        productsPageBL
                .searchBrand(company)
                .clickOnFromExpensiveToCheapOption()
                .clickOnFirstProduct()
                .clickOnBuyButton()
                .clickOnContinueShoppingButton()
                .clickOnCartButton()
                .checkPrice(price);
    }
}
