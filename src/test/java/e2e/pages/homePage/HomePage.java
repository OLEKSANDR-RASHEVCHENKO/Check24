package e2e.pages.homePage;

import e2e.enums.Pauschalreisen;
import e2e.pages.BasePage;
import e2e.pages.reisePage.ReisePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='c24-search']")
    WebElement headerOnHomePage;
    @FindBy(xpath = "//*[@class='c24-customer c24-customer-user']")
    WebElement userDataHeader;
    @FindBy(xpath = "//*[@title='Reise']")
    WebElement reiseButton;
    public void hoverOverElementOnHomePageReise(WebDriver driver){
        WebElement elementToHover = driver.findElement(By.xpath("//*[@title='Reise']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }
    public void chooseAnTravel(Pauschalreisen pauschalreisen ){
        WebElement choseTheTypeOfTravel = driver.findElement(By.xpath(pauschalreisen.getListOfPauschalreisen()));
        choseTheTypeOfTravel.click();
    }
    public ReisePage clickOnReiseButton(){
        reiseButton.click();
        return new ReisePage();
    }


    public void waitForLoadingOnHomePage(){
        getWait().forVisibility(userDataHeader);
    }
    public void assertHeaderVisibility() {
        Assert.assertTrue( headerOnHomePage.isDisplayed(),"Header on home page is not visible!");
    }





    public void takeScreenshotOnHomePage(){
        takeAndCompareScreenshot("HomePageScreenshotPage",headerOnHomePage);
    }

}
