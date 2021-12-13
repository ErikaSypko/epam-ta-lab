package SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import models.FilterRozetka;
import utils.XmlReader;

import java.io.IOException;

public class BasketTests extends BaseTests {
    FilterRozetka filter = new XmlReader().getData();

    public BasketTests() throws IOException {
    }

    @Test
    public void checkIfItemPriceLessThenIndicated() throws InterruptedException {
        getHomePage().searchByKeyword(filter.getProduct());
        getLaptopsPage().waitForPageLoadComplete(30);
        getLaptopsPage().searchBrandByKeyword(filter.getCompany());
        getLaptopsPage().waitNumberOfElementsToBeLess(30,getLaptopsPage().getXpathOfFirstLetterOfProduct(), 7);
        getLaptopsPage().clickOnFirstFoundBrandByKeywordCheckbox();
        getLaptopsPage().clickOnFromExpensiveToCheapOption();
        getLaptopsPage().waitForPageLoadComplete(30);
        getLaptopsPage().clickOnFirstProduct();
        getProductPage().waitVisibilityOfElement(30, getProductPage().getBuyButton());
        getProductPage().clickOnBuyButton();
        getProductPage().waitVisibilityOfElement(30, getProductPage().getCloseBasketButton());
        getProductPage().clickOnCloseBasketButton();
        getProductPage().clickOnBasketButton();
        Assert.assertTrue(getProductPage().getProductPrice() < filter.getPrice());
    }
}
