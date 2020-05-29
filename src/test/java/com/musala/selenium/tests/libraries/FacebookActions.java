package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.FacebookPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FacebookActions {

    private WebDriver driver;
    private BasicActions bobi;

    public FacebookActions(WebDriver driver)
    {
        this.driver = driver;
        bobi = new BasicActions(this.driver);
    }

    public void verifiesFacebookURLisLoaded()
    {
        String expectedURL = FacebookPage.URL;
        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedURL));
    }

    public void verifiesFacebookProfilePictureIsDisplayed()
    {
        bobi.waitsForElementToBeVisible(FacebookPage.PROFILE_PICTURE);
        WebElement profilePicture = driver.findElement(FacebookPage.PROFILE_PICTURE);
        String expectedPicturePath = FacebookPage.PROFILE_PICTURE_PATH;
        String actualPicturePath = profilePicture.getAttribute("href");

        Assert.assertTrue(profilePicture.isDisplayed() );
        Assert.assertEquals(actualPicturePath, expectedPicturePath);
    }
}
