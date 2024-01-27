package E2E.Pages;

import E2E.Pages.BasePage;
import E2E.Pages.LoginDialogPassword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='c24-header-content clearfix']")
    WebElement header;

    @FindBy(xpath = "//*[@class='wireframeCustomerAreaGuest']//*[@class='c24-customer-layer c24-header-hover-layer']//*[@id='c24-meinkonto-anmelden']")
    WebElement anmeldenButton;
    @FindBy(xpath = "//*[text()='Geht klar']")
    WebElement cookiesAgreement;



    public void waitForLoadingStartPage(){
        getWait().forVisibility(header);
    }
    public void waitForVisibilityAnmeldenButton(){
        getWait().forVisibility(anmeldenButton);
    }
    public void clickOncookiesAgreement(){
        cookiesAgreement.click();
    }
    public void hoverOverElement(WebDriver driver){
        WebElement elementToHover = driver.findElement(By.xpath("//*[@class='c24-customer-icon c24-customer-icon-lo c24-header-hover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        getWait().forVisibility(anmeldenButton);
    }

    public LoginDialogPassword loggingInSystemWithCreatedUser(){
        anmeldenButton.click();
        return new LoginDialogPassword(driver);
    }

}
