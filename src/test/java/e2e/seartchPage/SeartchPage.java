package e2e.seartchPage;

import e2e.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    WebElement firstMinPriceOnHotel;
    @FindBy(xpath = "//*[@class='select-element js-result-list-sorting-action-content js-result-list-sorting-select']")
    WebElement sortDropDown;
    @FindBy(xpath = "//*[@data-selected='price']")
    WebElement minPrice;


public void hotelMinimumPriceComparison(){
        String getPrice = price.getText();
        String[] prices = getPrice.split("-");
        String firstPrice = prices[0].trim();
        firstPrice = firstPrice.replaceAll("[^0-9.,]", "");
        System.out.println(firstPrice);

        String getPriceOnHotel = firstMinPriceOnHotel.getText();
        String[] price = getPriceOnHotel.split("\\s+");
        String firstPriceOnHotel = price[1];
        System.out.println(firstPriceOnHotel);
        Assert.assertEquals(firstPrice,firstPriceOnHotel,"Min Price is not equal to hotepPrice");

    }
    public void setMinPriceOnSortDropDown(){
        sortDropDown.click();
        minPrice.click();
    }

    public double extractMinPrice(String headerText){
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(headerText);
        double minPrise = 0.0;
        if (matcher.find()){
            minPrise = Double.parseDouble(matcher.group());
        }
        return minPrise;
    }
    public String getMinPriceOnSearchPage(){
        WebElement header = driver.findElement(By.xpath("//*[@class='_Heading_clvgd_94']"));
        String headerText = header.getText();
        double minPrice = extractMinPrice(headerText);
        System.out.println("Минимальная цена: " + minPrice + " €");
        return headerText;
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
