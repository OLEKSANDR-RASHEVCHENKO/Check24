package e2e;

import e2e.enums.DaysOnTheCalendar;
import e2e.enums.MonthsOnTheCalendar;
import e2e.enums.Name_MonthsOnTheCalendar;
import e2e.pages.homePage.HomePage;
import e2e.pages.loggingInSystemPage.AccProtectionPage;
import e2e.pages.loggingInSystemPage.LoginDialogEmail;
import e2e.pages.loggingInSystemPage.LoginDialogPassword;
import e2e.pages.loggingInSystemPage.StartPage;
import e2e.pages.reisePage.ReisePage;
import e2e.seartchPage.SeartchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.directory.SearchResult;
import java.util.List;

public class UserCanSeartchAnTravel extends BaseTest{
    StartPage startPage;
    LoginDialogEmail loginDialogEmail;
    LoginDialogPassword loginDialogPassword;
    AccProtectionPage accProtectionPage;
    HomePage homePage;
    ReisePage reisePage;
    SeartchPage seartchPage;

    public void testSearchResultsLocations() {
        List<WebElement> searchResults = seartchPage.getSearchResult();
        Assert.assertFalse(searchResults.isEmpty(), "Search results list is empty");
        String expectedLocation = "Berlin, Berlin";
        for (WebElement resultElement : searchResults) {
            WebElement locationElement = resultElement.findElement(By.xpath("//*[text()='Berlin, Berlin']"));
            String location = locationElement.getText();
            Assert.assertEquals(location, expectedLocation, "Unexpected location in search results");
//            if (location.equals(expectedLocation)) {
//                System.out.println("Location matches expected: " + location);
//            } else {
//                System.out.println("Location does not match expected: " + location);
//            }
        }
    }


    @Test
    public void userCanSeartchAndChooseAnTravel() throws InterruptedException {
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";
        String country = "Berlin";
        String vonWoFligeIch = "Dresden";


        startPage = new StartPage(app.driver);
        startPage.clearSearchHistory();
        startPage.clickOncookiesAgreement();
        startPage.waitForLoadingStartPage();
        startPage.hoverOverElement(app.driver);
        startPage.loggingInSystemWithCreatedUser();

        loginDialogEmail = new LoginDialogEmail(app.driver);
        loginDialogEmail.switchToIframe();
        loginDialogEmail.inputEmail(email);
        loginDialogEmail.takeScreenshotOnLoginEmailDialog();
        loginDialogEmail.clickOnWeiterButton();
        loginDialogPassword = new LoginDialogPassword(app.driver);
        loginDialogPassword.waiteForLoading();
        loginDialogPassword.takeScreenshotOnLoginPasswordDialog();
        loginDialogPassword.inputPasswordAndLoggingInSystem(password);
        accProtectionPage = new AccProtectionPage(app.driver);
        accProtectionPage.waiteForLoadingOnAccProtectionPage();
        accProtectionPage.assertHeaderVisibility();
        accProtectionPage.clickOnRemindMeLaterButton();
        homePage = new HomePage(app.driver);
        homePage.waitForLoadingOnHomePage();
        homePage.assertHeaderVisibility();
        homePage.takeScreenshotOnHomePage();
        homePage.clickOnReiseButton();
        reisePage = new ReisePage(app.driver);
        reisePage.waiteForLoadingReisePage();
        reisePage.clickOnReiseZielField(country);
        reisePage.clickOnFirstElementReiseZiel();
        reisePage.vonAbFlugFieldClick(vonWoFligeIch);
        reisePage.setClickOnFirstElementFlugAb();
        reisePage.clickOnReiseZeitReaumButton();
        reisePage.waitForVisabilityOfData();
//        reisePage.prevMonthButtonClick();
        reisePage.chooseTheDayAndMonthOfTravelStart(DaysOnTheCalendar.Enamuary_5th, Name_MonthsOnTheCalendar.August,MonthsOnTheCalendar.AUGUST);
//        reisePage.waitForVisabilityOfData();
//        reisePage.chooseTheDayAndMonthOfTravelFinish(DaysOnTheCalendar.Enamuary_9th,MonthsOnTheCalendar.APRIL);
//        reisePage.clickOnSuchenButton();
//        seartchPage = new SeartchPage(app.driver);
//        seartchPage.waiteForLoadingSearchPage();
//        testSearchResultsLocations();














    }
}
