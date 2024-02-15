package e2e.pages.loggingInSystemPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccProtectionPage extends LoginDialogPassword {
    public AccProtectionPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@data-tid='page-title']")
    WebElement headerOnAccProtectionPage;
    @FindBy(xpath = "//*[@data-tid='user-data']")
    WebElement userDataOnProtectionPage;
    @FindBy(xpath = "//*[@id='cl_sld_prefix']")
    WebElement countryCodePhoneField;
    @FindBy(xpath = "//*[@id='cl_sld']")
    WebElement phoneInput;
    @FindBy(xpath = "//*[text()='Mobiltelefonnummer hinzufügen']")
    WebElement addPhoneNumberButton;
    @FindBy(xpath = "//*[@data-tid='later-button']")
    WebElement remindMeLaterButton;

    public void waiteForLoadingOnAccProtectionPage(){
        getWait().forVisibility(headerOnAccProtectionPage);
        getWait().forVisibility(userDataOnProtectionPage);
        getWait().forClickable(addPhoneNumberButton);
        getWait().forClickable(remindMeLaterButton);
    }
    public void setPhoneInfo(String countryCode,String number){
        countryCodePhoneField.sendKeys(countryCode);
        phoneInput.sendKeys(number);
        addPhoneNumberButton.click();
    }

    public void clickOnRemindMeLaterButton(){
        remindMeLaterButton.click();
    }

    public void takeScreenshotUserDataOnAccProtectionPage(){
        takeAndCompareScreenshot("Comprasion_Email_With_Entered_On_AccProtectionPage",userDataOnProtectionPage);
    }
    public void assertHeaderVisibility() {
        Assert.assertTrue( headerOnAccProtectionPage.isDisplayed(),"Header on home page is not visible!");
    }

}
