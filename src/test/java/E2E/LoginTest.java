package E2E;

import E2E.Pages.BasePage;
import E2E.Pages.Login.LoginDialogEmail;
import E2E.Pages.Login.LoginDialogPassword;
import E2E.Pages.Login.StartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        loginDialogEmail = new LoginDialogEmail(app.driver);
//        loginDialogEmail.inputEmail(email);
//        loginDialogEmail.takeScreenshotOnLoginEmailDialog();
        loginDialogEmail.clickOnWeiterButton();
        loginDialogPassword = new LoginDialogPassword(app.driver);
        loginDialogPassword.waiteForLoading();
        loginDialogPassword.takeScreenshotOnLoginPasswordDialog();
        loginDialogPassword.inputPasswordAndLoggingInSystem(password);


    }

}
