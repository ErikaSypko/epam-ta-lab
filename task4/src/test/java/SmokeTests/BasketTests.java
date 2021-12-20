package SmokeTests;

import model.FilterRozetka;
import model.FiltersRozetka;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.XmlToObject;


import java.util.List;

public class BasketTests extends BaseTests {
    @DataProvider(name = "data", parallel = true)
    public static Object[][] getData() {
        XmlToObject xmlToObject = new XmlToObject();
        FiltersRozetka filters = xmlToObject.convert();
        List<FilterRozetka> filter = filters.getFilters();
        Object[][] objects = new Object[filter.size()][3];
        for (int i = 0; i < filter.size(); i++) {
            objects[i][0] = filter.get(i).getProduct();
            objects[i][1] = filter.get(i).getCompany();
            objects[i][2] = filter.get(i).getPrice();
        }
        return objects;
    }

    @Test(dataProvider = "data")
    public void checkIfItemPriceLessThenIndicated(String product, String company, String price) throws InterruptedException {
        getHomePage().searchByKeyword(product);
        getProductsPage().waitForPageLoadComplete(30);
        getProductsPage().searchBrandByKeyword(company);
        getProductsPage().waitNumberOfElementsToBeLess(30, getProductsPage().getXpathOfFirstLetterOfProduct(), 7);
        getProductsPage().clickOnFirstFoundBrandByKeywordCheckbox();
        getProductsPage().clickOnFromExpensiveToCheapOption();
        getProductsPage().waitForPageLoadComplete(30);
        getProductsPage().scrollToTheTop();
        getProductsPage().waitClickableOfElement(30, getProductsPage().getFirstProduct());
        getProductsPage().clickOnFirstProduct();
        getProductPage().waitVisibilityOfElement(30, getProductPage().getBuyButton());
        getProductPage().clickOnBuyButton();
        getProductPage().waitVisibilityOfElement(30, getProductPage().getCloseBasketButton());
        getProductPage().clickOnCloseBasketButton();
        getProductPage().waitClickableOfElement(30, getProductPage().getBasketButton());
        getProductPage().clickOnBasketButton();
        Assert.assertTrue(getProductPage().getProductPrice() < Integer.valueOf(price));
    }
}
