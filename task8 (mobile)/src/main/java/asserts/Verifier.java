package asserts;

import org.openqa.selenium.By;
import org.testng.Assert;
import page.SearchBarPage;
import page.SelectAccountPage;
import driver.AndroidDriverSingleton;
import util.Constants;

public class Verifier {
    private static SelectAccountPage selectAccountPage = new SelectAccountPage();
    private static SearchBarPage searchBarPage = new SearchBarPage();

    public static void checkEmailOnSelectAccountPage(String emailExpected) {
        Assert.assertEquals(selectAccountPage.getAccountAddress(), emailExpected);
    }

    public static void checkEmailOnSearchBarPage(String emailExpected) {
        Assert.assertEquals(searchBarPage.getAccountGmail(), emailExpected);
    }

    public static void isLetterDisplayed() {
        String letter = String.format("//android.view.View[contains(@content-desc, '%s, %s')]", Constants.SUBJECT, Constants.BODY);
        Assert.assertTrue(AndroidDriverSingleton.getDriver().findElement(By.xpath(letter)).isDisplayed());
    }

}
