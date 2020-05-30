package com.musala.selenium.tests.libraries;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BasicActions {

    private WebDriver driver;
    public static final int MAX_WAIT_TIME = 10000;
    public static final int POLL_INTERVAL = 500;

    public BasicActions(WebDriver driver)
    {
        this.driver = driver;
    }


    public void clicksOn(By elementLocator)
    {
        //waitsForElementToBeClickable(elementLocator);
        driver.findElement(elementLocator).click();
    }

    public void clicksOn(WebElement element)
    {
        //waitsForElementToBeClickable(element);
        element.click();
    }

    public void waitsForElementToBeClickable(By elementLocator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void waitsForElementToBeClickable(WebElement element)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitsForElementToBeVisible(By elementLocator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void waitsForPageTitleToContainText(String title)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitsForPageURLToBe(String url)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void waitsForPageURLToContain(String url)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.urlContains(url));
    }

    public void fillsFieldWithText(By fieldLocator, String text)
    {
        driver.findElement(fieldLocator).sendKeys(text);
    }

    public void clearsTextOfField(By fieldLocator)
    {
        driver.findElement(fieldLocator).clear();
    }

    public void waitsForElementTextToBeEmpty(By elementLocator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, ""));
    }

    public void waitsForWindowTabsToBeMoreThan(int numberOfTabs)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until((condition) ->
        {
            if( driver.getWindowHandles().size() > numberOfTabs)
            {
                return true;
            }
            else{
                return false;
            }
        });
    }

    public void switchesToNextTab()
    {
        waitsForWindowTabsToBeMoreThan(1);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        //System.out.println("tabs size = " + tabs.size() );

        driver.switchTo().window(tabs.get(1));
    }

    public void switchesToPreviousTab()
    {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        closesCurrentTab();

        driver.switchTo().window(tabs.get(0));
    }

    public void closesCurrentTab()
    {
        driver.close();
    }
}
