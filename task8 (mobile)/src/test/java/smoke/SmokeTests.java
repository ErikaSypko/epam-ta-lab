package smoke;

import business.GmailBO;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import util.Constants;

public class SmokeTests extends BaseTest {
    private final GmailBO gmailBO = new GmailBO();

    @BeforeSuite
    public void skipGreetings() {
        gmailBO.skipGreetings();
    }

    @Test
    public void isLetterSentAndArrivedTest() throws InterruptedException {
        gmailBO.writeLetter()
                .sendLetter()
                .checkIfLetterIsSent()
                .switchAccountTo(Constants.RECIPIENT)
                .checkIfAccountIsSwitched(Constants.RECIPIENT)
                .checkIfLetterIsArrived()
                .switchAccountTo(Constants.EMAIL_OWNER)
                .checkIfAccountIsSwitched(Constants.EMAIL_OWNER);
    }

    @Test
    public void isLetterMovedToDraft() {
        gmailBO.writeLetter()
                .exitPageWithWrittenLetter()
                .checkIfLetterIsMovedToDraft();
    }

    @Test
    public void isDeletedLetterMovedToBin() {
        gmailBO.writeLetter()
                .sendLetter()
                .checkIfLetterIsSent()
                .deleteLetter()
                .checkIfDeletedLetterMovedToTrash();
    }
}
