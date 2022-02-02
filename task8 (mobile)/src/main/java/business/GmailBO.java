package business;

import asserts.Verifier;
import driver.AndroidDriverSingleton;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import page.*;
import util.Constants;

public class GmailBO {
    private final InitialPage initialPage;
    private final SelectAccountPage selectAccountPage;
    private final PrimaryPage primaryPage;
    private final ComposePage composePage;
    private final HamburgerMenuPage hamburgerMenuPage;
    private final SearchBarPage searchBarPage;
    private final SentLettersPage sentLettersPage;
    private final CertainLetterPage certainLetterPage;
    private final TouchAction touchAction = new TouchAction(AndroidDriverSingleton.getDriver());


    public GmailBO() {
        this.initialPage = new InitialPage();
        this.selectAccountPage = new SelectAccountPage();
        this.primaryPage = new PrimaryPage();
        this.composePage = new ComposePage();
        this.hamburgerMenuPage = new HamburgerMenuPage();
        this.searchBarPage = new SearchBarPage();
        this.sentLettersPage = new SentLettersPage();
        this.certainLetterPage = new CertainLetterPage();
    }

    public GmailBO skipGreetings() {
        initialPage.clickOnGotItButton();
        Verifier.checkEmailOnSelectAccountPage(Constants.EMAIL_OWNER);
        selectAccountPage.clickOnGoToGmailButton();
        primaryPage.clickOnPopupButton();
        primaryPage.clickOnPopupButton();
        primaryPage.clickOnComposeButton();
        composePage.clickOnGotItButton();
        composePage.clickOnGoBackButton();
        return this;
    }

    public GmailBO writeLetter() {
        primaryPage.clickOnComposeButton();
        composePage.setRecipientField(Constants.RECIPIENT);
        composePage.setSubjectField(Constants.SUBJECT);
        composePage.setTextField(Constants.BODY);
        return this;
    }

    public GmailBO sendLetter() {
        composePage.clickOnSendButton();
        return this;
    }

    public GmailBO exitPageWithWrittenLetter() {
        composePage.clickOnGoBackButton();
        return this;
    }

    public GmailBO checkIfLetterIsSent() {
        primaryPage.clickOnHamburgerMenuButton();
        hamburgerMenuPage.clickOnSentLettersButton();
        Verifier.isLetterDisplayed();
        return this;
    }

    public GmailBO switchAccountTo(String email) {
        searchBarPage.clickOnAccountImage();
        searchBarPage.switchAccount(email);
        searchBarPage.clickOnAccountImage();
        return this;
    }


    public GmailBO deleteLetter() {
        sentLettersPage.clickOnSentLetter();
        certainLetterPage.clickOnDeleteButton();
        return this;
    }

    public GmailBO checkIfDeletedLetterMovedToTrash() {
        sentLettersPage.clickOnHamburgerMenuButton();
        hamburgerMenuPage.slideUp();
        hamburgerMenuPage.clickOnTrashButton();
        Verifier.isLetterDisplayed();
        return this;
    }

    public GmailBO checkIfAccountIsSwitched(String email) {
        Verifier.checkEmailOnSearchBarPage(email);
        touchAction.tap(PointOption.point(155, 114)).perform();
        return this;
    }

    public GmailBO checkIfLetterIsArrived() throws InterruptedException {
        Thread.sleep(5000);
        primaryPage.slideDown();
        Verifier.isLetterDisplayed();
        return this;
    }

    public GmailBO checkIfLetterIsMovedToDraft() {
        primaryPage.clickOnHamburgerMenuButton();
        hamburgerMenuPage.clickOnDraftsButton();
        Verifier.isLetterDisplayed();
        return this;
    }
}
