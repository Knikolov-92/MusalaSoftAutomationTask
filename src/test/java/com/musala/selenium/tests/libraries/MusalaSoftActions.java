package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.MusalaSoftPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MusalaSoftActions {

    private  WebDriver driver;
    private BasicActions bobi;

    public MusalaSoftActions(WebDriver driver)
    {
        this.driver = driver;
        bobi = new BasicActions(this.driver);
    }

    public void verifiesMusalaSoftURLisLoaded()
    {
        String expectedURL = MusalaSoftPage.URL;
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }

    public void verifiesMusalaSoftLogoIsDisplayed()
    {
        bobi.waitsForElementToBeVisible(MusalaSoftPage.LOGO);
        WebElement logo = driver.findElement(MusalaSoftPage.LOGO);

        Assert.assertTrue(logo.isDisplayed());
    }

    public void navigatesBackToHomePage()
    {
        bobi.switchesToPreviousTab();
    }
}
