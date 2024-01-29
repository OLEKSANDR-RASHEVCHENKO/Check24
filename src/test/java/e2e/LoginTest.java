package e2e;

import e2e.enums.Pauschalreisen;
import e2e.pages.homePage.HomePage;
import e2e.pages.loggingInSystemPage.AccProtectionPage;
import e2e.pages.loggingInSystemPage.LoginDialogEmail;
import e2e.pages.loggingInSystemPage.LoginDialogPassword;
import e2e.pages.loggingInSystemPage.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    StartPage startPage;
    LoginDialogEmail loginDialogEmail;
    LoginDialogPassword loginDialogPassword;
    AccProtectionPage accProtectionPage;
    HomePage homePage;

    @Test
    public void userCanLoginInSystem() {
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";

        startPage = new StartPage(app.driver);
        startPage.clickOncookiesAgreement();
        startPage.waitForLoadingStartPage();
        startPage.hoverOverElement(app.driver);
        startPage.loggingInSystemWithCreatedUser();

        loginDialogEmail = new LoginDialogEmail(app.driver);
        loginDialogEmail.switchToIframe();
        loginDialogEmail.inputEmail(email);
        loginDialogEmail.takeScreenshotOnLoginEmailDialog();
        loginDialogEmail.clickOnWeiterButton();
        loginDialogPassword = new LoginDialogPassword(app.driver);
        loginDialogPassword.waiteForLoading();
        loginDialogPassword.takeScreenshotOnLoginPasswordDialog();
        loginDialogPassword.inputPasswordAndLoggingInSystem(password);
        accProtectionPage = new AccProtectionPage(app.driver);
        accProtectionPage.waiteForLoadingOnAccProtectionPage();
        accProtectionPage.clickOnRemindMeLaterButton();
        homePage = new HomePage(app.driver);
        homePage.waitForLoadingOnHomePage();
        homePage.assertHeaderVisibility();
        homePage.takeScreenshotOnHomePage();





    }

}
