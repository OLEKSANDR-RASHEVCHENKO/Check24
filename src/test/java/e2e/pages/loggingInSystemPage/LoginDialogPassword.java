package e2e.pages.loggingInSystemPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginDialogPassword extends LoginDialogEmail {
    public LoginDialogPassword(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@data-tid='page-title']")
    WebElement headerWillkomen;
    @FindBy(xpath = "//*[@data-tid='user-data']")
    WebElement userData;
    @FindBy(xpath = "//*[text()='ändern']")
    WebElement ändernButton;
    @FindBy(xpath = "//*[@id='cl_pw_login']")
    WebElement passwordInputField;
    @FindBy(xpath = "//*[@id='c24-uli-pw-btn']")
    WebElement anmeldenButtonInLoginDialog;
    @FindBy(xpath = "//*[text()='ohne Passwort anmelden']")
    WebElement ohnePasswordAnmeldenButton;


    public void waiteForLoading(){
        getWait().forVisibility(headerWillkomen);
        getWait().forVisibility(passwordInputField);
        getWait().forClickable(anmeldenButtonInLoginDialog);
    }

    public void inputPasswordAndLoggingInSystem(String password){
        passwordInputField.sendKeys(password);
        anmeldenButtonInLoginDialog.click();
    }
    public void takeScreenshotOnLoginPasswordDialog(){
        takeAndCompareScreenshot("Comparison_Email_With_Entered",userData);
    }
}
