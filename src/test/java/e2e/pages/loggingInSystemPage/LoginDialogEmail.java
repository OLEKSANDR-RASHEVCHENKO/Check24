package e2e.pages.loggingInSystemPage;

import e2e.pages.loggingInSystemPage.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginDialogEmail extends StartPage {
    public LoginDialogEmail(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[class='c24-uli-body']")
    WebElement headerOnLoginDialog;
    @FindBy(xpath = "//*[@data-tid='input-login']")
    WebElement emailAddressInputField;
    @FindBy(xpath = "//*[@id='c24-uli-login-btn']")
    WebElement weiterButton;
    @FindBy(xpath = "//div[@class='c24-uli-loginlayer']//iframe")
    WebElement iframe;
    @FindBy(xpath = "//*[@class='c24-uli-input-wrapper c24-uli-input-wrapper-email c24-uli-input-info']//*[@class='c24-uli-error c24-uli-error-email']")
    WebElement errorMessageEmail;
    public void isErrorMessageDisplayed(){
        getWait().forVisibility(errorMessageEmail);
        Assert.assertTrue(errorMessageEmail.isDisplayed(), "ErrorMessageEmail is not visible!");
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }


    public void waiteForLoading(){
        getWait().forVisibility(headerOnLoginDialog);
        getWait().forVisibility(emailAddressInputField);
        getWait().forClickable(weiterButton);
    }
    public void inputEmail(String email){
        emailAddressInputField.sendKeys(email);
    }
    public void clickOnWeiterButton(){
        weiterButton.click();
    }
    public void takeScreenshotOnLoginEmailDialog(){
        takeAndCompareScreenshot("Entered_Email_On_Login_Dialog",emailAddressInputField);
    }


}
