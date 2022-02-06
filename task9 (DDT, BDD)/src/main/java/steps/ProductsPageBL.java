package steps;

import page.ProductsPage;
import util.Scroll;

public class ProductsPageBL {
    private ProductsPage productsPage;

    public ProductsPageBL() {
        this.productsPage = new ProductsPage();
    }

    public ProductsPageBL searchBrand(String keyword) {
        productsPage.searchBrandByKeyword(keyword);
        productsPage.clickOnBrandsFiltersCheckbox();
        return this;
    }

    public ProductsPageBL clickOnFromExpensiveToCheapOption() {
        productsPage.clickOnFromExpensiveToCheapOption();
        return this;
    }

    public ProductPageBL clickOnFirstProduct() {
        Scroll.scrollToTheTop();
        productsPage.clickOnFirstProduct();
        return new ProductPageBL();
    }


}
