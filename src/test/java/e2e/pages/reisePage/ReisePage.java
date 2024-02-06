package e2e.pages.reisePage;

import e2e.enums.DaysOnTheCalendar;
import e2e.enums.MonthsOnTheCalendar;
import e2e.enums.Name_MonthsOnTheCalendar;
import e2e.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ReisePage extends BasePage {
    public ReisePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='c24-header']")
    WebElement headerOnReisePage;
    @FindBy(xpath = "//*[@id='c24-travel-bubble-ele-package']")
    WebElement reiseHeader;

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
    @FindBy(xpath = "//*[@id='c24-travel-ac-airport-button']")
    WebElement übernehmenButtonOnFlugAbField;

    @FindBy(xpath = "//*[text()='Dresden']")
    WebElement clickOnFirstElementFlugAb;
    @FindBy(xpath = "//*[@class='c24-travel-single-date-input-overlay c24-travel-hidden']")
    WebElement reiseDatumButton;
    @FindBy(xpath = "//*[@class='c24-travel-js-datefinder c24-travel-datefinder c24-travel-datepicker-instance-element c24-travel-c24-hidden']")
    WebElement switchToWindowData;

    @FindBy(xpath = "//*[@class='c24-travel-js-control-slide-prev c24-travel-control-slide-prev']")
    WebElement prevMonthButton;
    @FindBy(xpath = "//*[@class='c24-travel-js-control-slide-next c24-travel-control-slide-next']")
    WebElement nextMonthButton;
    @FindBy(xpath = "//*[text()='Reisedauer']")
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
    @FindBy(xpath = "//*[@class='c24-travel-primary-cta-button c24-travel-duration-layer-button c24-travel-btn-use-duration-value']")
    WebElement reiseDauerÜbernehmenButton;
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
        getWait().forVisibility(reiseHeader);
        getWait().forVisibility(reiseZielField);
        getWait().forVisibility(clickOnFlugAbField);
        getWait().forVisibility(reiseDatumButton);
        getWait().forVisibility(reiseDauerButton);
        getWait().forVisibility(suchenButton);
        getWait().forClickable(suchenButton);
        getWait().forClickable(resetReiseZiel);
    }

    public void assertHeaderVisibility() {
        Assert.assertTrue(headerOnReisePage.isDisplayed(), "Header on reise Page is not visible!");
        Assert.assertTrue(reiseHeader.isDisplayed(), "Header on reise Page is not visible!");
        Assert.assertTrue(suchenButton.isDisplayed(), "Suchen button on reise Page is not visible!");
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
        slowType(inputAbflugHäfenField, vonWo);
    }

    public void setClickOnFirstElementFlugAb() {
        getWait().forClickable(clickOnFirstElementFlugAb);
        clickOnFirstElementFlugAb.click();
        übernehmenButtonOnFlugAbField.click();
    }

    private void slowType(WebElement element, String text) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < text.length(); i++) {
            actions.sendKeys(element, String.valueOf(text.charAt(i))).pause(100).perform();
        }
    }

    public void clickOnReiseZeitReaumButton() {
        reiseDatumButton.click();
    }

    public void waitForVisabilityOfData() {
        getWait().forVisibility(switchToWindowData);
        Assert.assertTrue(switchToWindowData.isDisplayed(), "Switch to window data is not visible!");
    }

    public void prevMonthButtonClick() throws InterruptedException {
        prevMonthButton.click();
        Thread.sleep(1000);

    }

    public void nextMonthButtonClick() throws InterruptedException {
        nextMonthButton.click();
        Thread.sleep(1000);
    }
//    public void chooseTheDayAndMonthOfTravelStart(DaysOnTheCalendar days, MonthsOnTheCalendar months){
//        driver.findElement(By.xpath("//*[@data-first-day='"+months.listOfMonths+"']//*[@data-day='"+days.listOfDays+"']")).click();
//    }
//    public void chooseTheDayAndMonthOfTravelFinish(DaysOnTheCalendar days, MonthsOnTheCalendar months){
//        driver.findElement(By.xpath("//*[@data-first-day='"+months.listOfMonths+"']//*[@data-day='"+days.listOfDays+"']")).click();
//
//    }


    public void chooseTheDayAndMonthOfTravelStart(DaysOnTheCalendar days, Name_MonthsOnTheCalendar months,MonthsOnTheCalendar chooseMonths) throws InterruptedException {
        String currentMonthDisplayed = getCurrentMonthDisplayed();
        int monthsToNavigate = calculateMonthsToNavigate(currentMonthDisplayed, months);
        for (int i = 0; i < Math.abs(monthsToNavigate); i++) {
            if (monthsToNavigate > 0) {
                nextMonthButtonClick();
            } else {
                prevMonthButtonClick();
            }
        }
        // Теперь выбираем день
        driver.findElement(By.xpath("//*[@data-first-day='"+chooseMonths.listOfMonths+"']//*[@data-day='"+days.listOfDays+"']"))
                .click();
    }





    public String getCurrentMonthDisplayed() {
        WebElement monthElement = driver.findElement(By.xpath("//*[@class='c24-travel-js-month c24-travel-month c24-travel-weekrow-count-6 c24-travel-js-first-visible-month']//*[@class='c24-travel-month-head']"));
        return monthElement.getText();
    }

    private int calculateMonthsToNavigate(String currentMonth, Name_MonthsOnTheCalendar targetMonth) {
        int currentMonthIndex = Name_MonthsOnTheCalendar.valueOf(currentMonth).ordinal();
        int targetMonthIndex = targetMonth.ordinal();
        int monthsToNavigate = targetMonthIndex - currentMonthIndex;
        if (monthsToNavigate < 0) {
            monthsToNavigate += Name_MonthsOnTheCalendar.values().length;
        }
        return monthsToNavigate;
    }


    public void clickOnReiseDauer() {
        reiseDauerButton.click();
    }

    public void inputGenauTage(int tage) {
        genauRadioButton.sendKeys(String.valueOf(tage));
        reiseDauerÜbernehmenButton.click();
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
