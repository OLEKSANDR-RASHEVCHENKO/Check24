package e2e.seartchPage;

import e2e.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.naming.directory.SearchResult;
import java.util.List;

public class SeartchPage extends BasePage {
    public SeartchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='_Header_1cvg3_74']")
    WebElement headerOnSearchPage;
    @FindBy(xpath = "//*[@class='_Item_1mqed_99']")
    WebElement waitForLoadingPage;











    public void waiteForLoadingSearchPage(){
        getWait().forVisibility(headerOnSearchPage);
        getWait().forVisibility(waitForLoadingPage);
    }
    public void assertHeaderVisibility() {
        Assert.assertTrue(headerOnSearchPage.isDisplayed(),"Header on search page is not visible!");
    }

    public List<WebElement> getSearchResult(){
        List<WebElement> searchResultElements = driver.findElements(By.xpath("//*[text()='Berlin, Berlin']"));
        return searchResultElements;
    }
    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
