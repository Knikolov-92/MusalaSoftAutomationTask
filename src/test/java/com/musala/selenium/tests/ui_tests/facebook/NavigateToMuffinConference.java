package com.musala.selenium.tests.ui_tests.facebook;

import com.musala.selenium.tests.libraries.BasicActions;
import com.musala.selenium.tests.libraries.FacebookActions;
import com.musala.selenium.tests.libraries.HomePageActions;
import com.musala.selenium.tests.libraries.MusalaSoftActions;
import com.musala.selenium.tests.ui_tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigateToMuffinConference extends BaseTest {

    private WebDriver driver;
    private BasicActions bobi;
    private HomePageActions dobri;
    private MusalaSoftActions joro;
    private FacebookActions kolio;


    @BeforeTest
    public void testSetUp()
    {
        driver = getDriver();
        bobi = new BasicActions(driver);
        dobri = new HomePageActions(driver);
        joro = new MusalaSoftActions(driver);
        kolio = new FacebookActions(driver);
    }

    @Test
    public void CorrectPageIsLoaded_When_NavigatingThroughFacebook()
    {
        dobri.navigatesToMusalaSoftPageThroughFooterLink();
        joro.verifiesMusalaSoftURLisLoaded();
        joro.verifiesMusalaSoftLogoIsDisplayed();
        joro.navigatesBackToHomePage();
        dobri.navigatesToFacebookPage();
        kolio.verifiesFacebookURLisLoaded();
        kolio.verifiesFacebookProfilePictureIsDisplayed();
    }
}
