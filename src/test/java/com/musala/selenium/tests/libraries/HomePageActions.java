package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.HomePage;
import com.musala.selenium.page_objects.SignInPage;
import org.openqa.selenium.WebDriver;

public class HomePageActions {

    private WebDriver driver;
    private BasicActions bobi;

    public HomePageActions(WebDriver driver)
    {
        this.driver = driver;
        bobi = new BasicActions(this.driver);
    }

    public void navigatesToSignInPage()
    {
        bobi.waitsForElementToBeClickable(HomePage.SIGNIN_BUTTON_LINK);
        bobi.clicksOn(HomePage.SIGNIN_BUTTON_LINK);
        bobi.waitsForElementToBeVisible(SignInPage.SUBMIT_SIGNIN_BUTTON);
    }

}
