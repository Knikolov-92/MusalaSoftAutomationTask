package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.ArchivePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.List;

public class ArchiveActions {

    private WebDriver driver;
    private BasicActions bobi;


    public ArchiveActions(WebDriver driver)
    {
        this.driver = driver;
        bobi = new BasicActions(this.driver);
    }


    public void clicksOnLastEventInList()
    {
        bobi.waitsForElementToBeVisible(ArchivePage.HEADER_BACKGROUND_IMAGE);
        bobi.waitsForElementToBeVisible(ArchivePage.BOTTOM_ELEMENT_ON_PAGE);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //commented code doesn't work on page, elements are not interactable, cannot click on them
        //-----------------------------------------------------------------------------------------------
        //List<WebElement> eventList = driver.findElements(ArchivePage.EVENT_LIST_LOCATOR);
        //WebElement lastEventInList = eventList.get(eventList.size() - 1);
        //Actions actions = new Actions(driver);

        //noinspection unchecked
        List<WebElement> elemList = (List<WebElement>) js.executeScript
                (
                        "var results = new Array();"
                        + "var element = document.evaluate(\"//*[@id='events-cont']/div/div/div[1]\""
                        + ", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);"
                        + "for ( var i = 0 ; i < element.snapshotLength ; i++ )"
                        + "{"
                        + "results.push(element.snapshotItem(i));"
                        + "}"
                        + "return results;", ""
                );

        waitsUntilNumberOfEventsInArchiveListIsEqualTo(ArchivePage.MAX_EXPECTED_EVENTS_PER_PAGE);
        WebElement lastEventInList = elemList.get(elemList.size() - 1);

        js.executeScript("arguments[0].scrollIntoView(true);", lastEventInList);
        //actions.moveToElement(lastEventInList)
                //.click()
                //.build()
                //.perform();

        js.executeScript("arguments[0].click();", lastEventInList);
        //bobi.clicksOn(lastEventInList);
    }

    public void waitsUntilNumberOfEventsInArchiveListIsEqualTo(int numberOfElements)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(BasicActions.MAX_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(BasicActions.POLL_INTERVAL))
                .ignoring(java.util.NoSuchElementException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until((condition) ->
        {
            try
            {
                List<WebElement> eventList = driver.findElements(ArchivePage.EVENT_LIST_LOCATOR);

                if (eventList.size() == numberOfElements)
                {
                    return true;

                } else {

                    return false;
                }
            } catch (Exception e)
            {
                Type exType = e.getClass();
                if (exType == StaleElementReferenceException.class || exType == java.util.NoSuchElementException.class)
                {
                    return false;
                } else {
                    throw e;
                }
            }
        });
    }
}
