package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.*;
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
        bobi.clicksOn(HomePage.SIGNIN_BUTTON_LINK);
        bobi.waitsForElementToBeVisible(SignInPage.SUBMIT_SIGNIN_BUTTON);
    }

    public void navigatesToMusalaSoftPageThroughFooterLink()
    {
        bobi.clicksOn(HomePage.MUSALASOFT_FOOTER_LINK);
        bobi.switchesToNextTab();
        bobi.waitsForPageTitleToContainText(MusalaSoftPage.TITLE);
    }

    public void navigatesToFacebookPage()
    {
        bobi.clicksOn(HomePage.FACEBOOK_FOOTER_LINK);
        bobi.switchesToNextTab();
        bobi.waitsForPageTitleToContainText(FacebookPage.TITLE);
        bobi.waitsForPageURLToBe(FacebookPage.URL);
    }

    public void navigatesToArchivePage()
    {
        bobi.clicksOn(HomePage.ARCHIVE_BUTTON_LINK);
        bobi.waitsForPageURLToContain(ArchivePage.URL);
        bobi.waitsForElementToBeVisible(ArchivePage.SCHEDULE_IMAGE);
    }
}
