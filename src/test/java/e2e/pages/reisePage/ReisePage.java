package e2e.pages.reisePage;

import e2e.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ReisePage extends BasePage {
    public ReisePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='c24-header']")
    WebElement headerOnReisePage;
    @FindBy(xpath = "//*[@id='c24-travel-bubble-ele-package']")
    WebElement resieHeader;

    @FindBy(xpath = "//*[@id='c24-travel-destination-element']")
    WebElement reiseZielField;
    @FindBy(xpath = "//*[@class='c24-travel-reset-input']")
    WebElement resetReiseZiel;
    @FindBy(xpath = "//*[@class='c24-travel-regionfilter-item c24-travel-visible-filter ui-menu-item']")
    WebElement clickOnFirstElementReiseZiel;
    @FindBy(xpath = "//*[@id='c24-travel-airport-root']")
    WebElement clickOnFlugAbField;
    @FindBy(xpath = "//*[@class='textInput']")
    WebElement inputAbflugHäfenField;
    @FindBy(xpath = "//*[@class='deleteLink']")
    WebElement alleAbflugHäfenLöshen;
    @FindBy(xpath = "//*[@for='c24-travel-ac-airport-list-item0-0']")
    WebElement scrollContent;
    @FindBy(xpath = "//*[text()='Dresden']")
    WebElement clickOnFirstElementFlugAb;
    @FindBy(xpath = "//*[@class='c24-travel-single-date-input-overlay c24-travel-hidden']")
    WebElement reiseDatumButton;

    @FindBy(xpath = "//*[@class='c24-travel-js-control-slide-prev c24-travel-control-slide-prev']")
    WebElement prevMonthButton;
    @FindBy(xpath = "//*[@class='c24-travel-js-control-slide-next c24-travel-control-slide-next']")
    WebElement nextMonthButton;
    @FindBy(xpath = "//*[@id='c24-travel-travel-day-element']")
    WebElement reiseDauerButton;
    @FindBy(xpath = "//*[@id='c24-travel-duration-1']")
    WebElement exakteReisedatenRadioButton;
    @FindBy(xpath = "//*[@id='c24-travel-duration-2']")
    WebElement eineWocheRadioButton;
    @FindBy(xpath = "//*[@id='c24-travel-duration-3']")
    WebElement zweiWochenRadioButton;
    @FindBy(xpath = "//*[@id='c24-travel-duration-3']")
    WebElement dreiWochenRadioButton;
    @FindBy(xpath = "//*[@data-id='c24-travel-custom-duration-input']")
    WebElement genauRadioButton;
    @FindBy(xpath = "//*[@id='c24-travel-custom-range']")
    WebElement vonRadioBatton;
    @FindBy(xpath = "//*[@id='c24-travel-custom-range-to']")
    WebElement bisRadioBatton;
    @FindBy(xpath = "//*[@id='c24-travel-traveler-detail-btn']")
    WebElement reisendeButton;
    @FindBy(xpath = "//*[@class='c24-travel-select-less']")
    WebElement erwachseneLess;
    @FindBy(xpath = "//*[@class='c24-travel-adults-selection c24-travel-selection']//*[@class='c24-travel-select-more']")
    WebElement erwachseneMore;
    @FindBy(xpath = "//*[@class='c24-travel-children-selection c24-travel-selection']//*[@class='c24-travel-select-more']")
    WebElement kinderMore;
    @FindBy(xpath = "//*[@class='c24-travel-rooms-selection c24-travel-selection']//*[@class='c24-travel-select-more']")
    WebElement zummerMore;
    @FindBy(xpath = "//*[@id='c24-travel-js-get-amzb-traveler-btn']")
    WebElement übernehmenBatton;
    @FindBy(xpath = "//*[@id='c24-travel-search-button-element']")
    WebElement suchenButton;


    public void waiteForLoadingReisePage() {
        getWait().forVisibility(headerOnReisePage);
        getWait().forVisibility(resieHeader);
        getWait().forVisibility(reiseZielField);
        getWait().forVisibility(clickOnFlugAbField);
        getWait().forVisibility(reiseDatumButton);
        getWait().forVisibility(reiseDauerButton);
        getWait().forVisibility(suchenButton);
        getWait().forClickable(suchenButton);
        getWait().forClickable(resetReiseZiel);
    }


    public void clickOnReiseZielField(String reiseZiel) {
        resetReiseZiel.click();
        reiseZielField.sendKeys(reiseZiel);
    }

    public void clickOnFirstElementReiseZiel() {
        clickOnFirstElementReiseZiel.click();
    }


    public void vonAbFlugFieldClick(String vonWo) {
        clickOnFlugAbField.click();
        alleAbflugHäfenLöshen.click();
        slowType(inputAbflugHäfenField,vonWo);
    }

    public void setClickOnFirstElementFlugAb() {
        getWait().forClickable(clickOnFirstElementFlugAb);
        clickOnFirstElementFlugAb.click();
    }

    private void slowType(WebElement element, String text) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < text.length(); i++) {
            actions.sendKeys(element, String.valueOf(text.charAt(i))).pause(100).perform();
        }
    }

















    public void hoverOverElementOnReisePageVonAnFlug(WebDriver driver) {
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id='c24-travel-react-airport-layer']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }


    public void clickOnReiseZeitReaumButton() {
        reiseDauerButton.click();
    }

    public void hoverOverElementOnReisePageReiseZeitRaum(WebDriver driver) {
        WebElement elementToHover = driver.findElement(By.xpath("//*[@class='c24-travel-js-datefinder c24-travel-datefinder c24-travel-datepicker-instance-element c24-travel-c24-hidden']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }

    public void clickOnReiseDauer() {
        reiseDauerButton.click();
    }

    public void hoverOverElementOnReisePageReiseDauer(WebDriver driver) {
        WebElement elementToHover = driver.findElement(By.xpath("//*[@class='c24-travel-duration-layer c24-travel-c24-hidden c24-travel-pos-arrow-bottom']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }

    public void chooseOptionsOnReiseDauer() {
        exakteReisedatenRadioButton.click();
    }

    public void clickOnReisende() {
        reisendeButton.click();
        erwachseneLess.click();
        übernehmenBatton.click();
    }

    public void clickOnSuchenButton() {
        suchenButton.click();
    }


}
