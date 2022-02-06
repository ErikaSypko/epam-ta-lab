package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.PropertiesReader;
import util.WebDriverSingleton;

public class StepDefinitions {
    private PropertiesReader propertiesReader = new PropertiesReader();
    private HomePageBl homePageBl = new HomePageBl();
    private ProductsPageBL productsPageBL = new ProductsPageBL();
    private ProductPageBL productPageBL = new ProductPageBL();

    @Before
    public void testsSetUp() {
        WebDriverSingleton.getInstance().manage().window().maximize();
        WebDriverSingleton.getInstance().get(propertiesReader.getURL());
    }

    @Given("^User searches for the category (.*) of goods")
    public void userSearchesForTheCategoryOfGoods(String category) {
        homePageBl.searchByKeyword(category);
    }

    @When("^User filters goods by brand (.*)")
    public void userFiltersGoodsByBrand(String brand) {
        productsPageBL.searchBrand(brand);
    }

    @And("User sorts goods by price descending")
    public void userSortsGoodsByPriceDescending() {
        productsPageBL.clickOnFromExpensiveToCheapOption();
    }

    @And("User selects first good")
    public void userSelectsFirstGood() {
        productsPageBL.clickOnFirstProduct();
    }

    @And("User clicks Add to Bag button")
    public void userClicksAddToBagButton() {
        productPageBL.clickOnBuyButton();
    }

    @Then("^User checks price is less than the given price (.*)")
    public void userChecksPriceIsLessThanTheGivenPrice(String price) {
        productPageBL.checkPrice(price);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.getInstance().close();
    }
}
