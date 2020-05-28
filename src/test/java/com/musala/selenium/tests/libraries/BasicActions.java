package com.musala.selenium.tests.libraries;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasicActions {

    private WebDriver driver;
    private static final int MAX_WAIT_TIME = 6000;
    private static final int POLL_INTERVAL = 500;

    public BasicActions(WebDriver driver)
    {
        this.driver = driver;
    }


    public void clicksOn(By elementLocator)
    {
        driver.findElement(elementLocator).click();
    }

    public void waitsForElementToBeClickable(By elementLocator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void waitsForElementToBeVisible(By elementLocator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(POLL_INTERVAL))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
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
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

        wait.until(ExpectedConditions.textToBePresentInElementValue(elementLocator, ""));
    }
}
