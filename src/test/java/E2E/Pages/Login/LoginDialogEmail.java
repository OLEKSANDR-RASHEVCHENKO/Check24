package E2E.Pages.Login;

import E2E.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginDialogEmail extends StartPage {
    public LoginDialogEmail(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[class='c24-uli-body']")
    WebElement headerOnLoginDialog;
    @FindBy(xpath = "//*[@class='c24-uli-input-wrapper c24-uli-input-wrapper-email c24-uli-input-info']")
    WebElement emailAddressInputField;
    @FindBy(xpath = "//*[@id='c24-uli-login-btn']")
    WebElement weiterButton;

    public void waiteForLoading(){
        getWait().forVisibility(headerOnLoginDialog);
        getWait().forVisibility(emailAddressInputField);
        getWait().forClickable(weiterButton);
    }
//    public void switchToNewWindow() {
//        for (String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//            if (headerOnLoginDialog.isDisplayed()) {
//                return;
//            }
//        }
//        throw new RuntimeException("Window with title not found.");
//    }

    public void inputEmail(String email){
        setInput(emailAddressInputField,email);
    }
    public void clickOnWeiterButton(){
        weiterButton.click();
    }
    public void takeScreenshotOnLoginEmailDialog(){
        takeAndCompareScreenshot("Entered_Email_On_Login_Dialog",null);
    }


}
