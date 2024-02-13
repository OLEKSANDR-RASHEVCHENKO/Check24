package e2e.seartchPage;

import e2e.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SeartchPage extends BasePage {
    public SeartchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='_Heading_clvgd_94']")
    WebElement headerOnSearchPage;
    @FindBy(xpath = "//*[@class='_Item_1mqed_99']")
    WebElement waitForLoadingPage;
    @FindBy(xpath = "//*[@id='destination-element']")
    WebElement reisezielOnSearchPage;
    @FindBy(css = "h3 > span:nth-of-type(1):not(:empty):not(:only-child):not([class]):not([id])")
    WebElement price;
    @FindBy(xpath = "//*[@class='_Item_5i3dt_113'][1]//*[@class='_Price_v01qf_88 _TotalPrice_1kq0a_115']")
    WebElement minPriceOnHotel;
    @FindBy(xpath = "//*[@class='_Item_5i3dt_113'][1]//*[@class='_Price_v01qf_88 _TotalPrice_1kq0a_115']")
    WebElement maxPriceOnHotel;


    @FindBy(xpath = "//*[@class='select-element js-result-list-sorting-action-content js-result-list-sorting-select']")
    WebElement sortDropDown;
    @FindBy(xpath = "//*[@data-selected='price']")
    WebElement minPriceDropDown;
    @FindBy(xpath = "//*[@id='min-price']")
    WebElement minPriceInputField;


public void hotelMinimumPriceComparison(){
        String getPrice = price.getText();
        String[] prices = getPrice.split("-");
        String minPrice = prices[0].trim();
        minPrice = minPrice.replaceAll("[^0-9.,]", "");
        System.out.println(minPrice);

        String getPriceOnHotel = minPriceOnHotel.getText();
        String[] price = getPriceOnHotel.split("\\s+");
        String priceOnHotel = price[1];
        System.out.println(priceOnHotel);
        Assert.assertEquals(minPrice,priceOnHotel,"Min Price is not equal to hotelPrice");
    }
    public void hotelMaximumPriceComparison() throws InterruptedException {
        String getPrice = price.getText();
        String[] prices = getPrice.split("-");
        String maxPrice = prices[1].trim();
        maxPrice = maxPrice.replaceAll("[^0-9.,]", "");
        System.out.println(maxPrice);
        minPriceInputField.sendKeys(maxPrice + Keys.ENTER);
        scrollUpPage();

        getWait().forVisibility(headerOnSearchPage);
        Thread.sleep(1000);
        String getPriceOnExpensiveHotel = maxPriceOnHotel.getText();
        String[] price = getPriceOnExpensiveHotel.split("\\s+");
        String priceOnExpensiveHotel = price[1];
        System.out.println(priceOnExpensiveHotel);
        Assert.assertEquals(maxPrice,priceOnExpensiveHotel,"Max Price is not equal to hotelPrice");
    }


    public void setMinPriceOnSortDropDown(){
        sortDropDown.click();
        minPriceDropDown.click();
    }

    public void waiteForLoadingSearchPage(){
        getWait().forVisibility(headerOnSearchPage);
        getWait().forVisibility(reisezielOnSearchPage);

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
    public void scrollUpPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }
    public void scrollDownAndUp() throws InterruptedException {
        scrollDownPage();
        Thread.sleep(1000);
        scrollUpPage();
    }

}
