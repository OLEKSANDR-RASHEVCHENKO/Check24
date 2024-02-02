package e2e;

import e2e.pages.homePage.HomePage;
import e2e.pages.loggingInSystemPage.AccProtectionPage;
import e2e.pages.loggingInSystemPage.LoginDialogEmail;
import e2e.pages.loggingInSystemPage.LoginDialogPassword;
import e2e.pages.loggingInSystemPage.StartPage;
import e2e.pages.reisePage.ReisePage;
import org.testng.annotations.Test;

public class USerCanSeartchAndChooseAnTravel extends BaseTest{
    StartPage startPage;
    LoginDialogEmail loginDialogEmail;
    LoginDialogPassword loginDialogPassword;
    AccProtectionPage accProtectionPage;
    HomePage homePage;
    ReisePage reisePage;


    @Test
    public void userCanSeartchAndChooseAnTravel() {
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";
        String country = "Berlin";
        String vonWoFligeIch = "Dresden";

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
        homePage.clickOnReiseButton();
        reisePage = new ReisePage(app.driver);
        reisePage.waiteForLoadingReisePage();
        reisePage.clickOnReiseZielField(country);
        reisePage.clickOnFirstElementReiseZiel();
        reisePage.vonAbFlugFieldClick(vonWoFligeIch);
        reisePage.setClickOnFirstElementFlugAb();











    }
}
