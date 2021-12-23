package steps;

import page.HomePage;

public class HomePageBl {
    private HomePage homePage;

    public HomePageBl() {
        this.homePage = new HomePage();
    }

    public ProductsPageBL searchByKeyword(String keyword) {
        homePage.searchByKeyword(keyword);
        return new ProductsPageBL();
    }
}
