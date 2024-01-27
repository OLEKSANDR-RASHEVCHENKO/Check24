package E2E;

import E2E.Pages.LoginDialogEmail;
import E2E.Pages.LoginDialogPassword;
import E2E.Pages.StartPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    StartPage startPage;
    LoginDialogEmail loginDialogEmail;
    LoginDialogPassword loginDialogPassword;

    @Test
    public void userCanLoginInSystem() {
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";

        startPage = new StartPage(app.driver);
        startPage.clickOncookiesAgreement();
        startPage.waitForLoadingStartPage();
        startPage.hoverOverElement(app.driver);
        startPage.loggingInSystemWithCreatedUser();
        startPage.switchToIframe();
        loginDialogEmail = new LoginDialogEmail(app.driver);
        loginDialogEmail.inputEmail(email);
        loginDialogEmail.takeScreenshotOnLoginEmailDialog();
        loginDialogEmail.clickOnWeiterButton();
        loginDialogPassword = new LoginDialogPassword(app.driver);
        loginDialogPassword.waiteForLoading();
        loginDialogPassword.takeScreenshotOnLoginPasswordDialog();
        loginDialogPassword.inputPasswordAndLoggingInSystem(password);


    }

}
