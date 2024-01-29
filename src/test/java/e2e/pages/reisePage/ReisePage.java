package e2e.pages.reisePage;

import e2e.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//*[@id='fake-ele']")
    WebElement vonWofield;
    @FindBy(xpath = "//*[@class='c24-travel-single-date-input-overlay c24-travel-hidden']")
    WebElement reiseDatumButton;
    @FindBy(xpath = "//*[@class='c24-travel-js-control-slide-prev c24-travel-control-slide-prev']")
    WebElement prevMonthButton;
    @FindBy(xpath = "//*[@class='c24-travel-js-control-slide-next c24-travel-control-slide-next']")
    WebElement nextMonthButton;



}
