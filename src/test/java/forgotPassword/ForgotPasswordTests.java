package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassowrd();
        forgotPasswordPage.setEmail("menna@example.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrieveEmailButton();
        assertTrue(emailSentPage.getContentText().contains("Your e-mail's been sent!"), "Incorrect display message");
    }
}