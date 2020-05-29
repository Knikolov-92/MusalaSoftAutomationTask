package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.ArchivePage;
import org.openqa.selenium.*;

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
        //commented code doesn't work on page, elements are not interactable, cannot click on them
        //-----------------------------------------------------------------------------------------------
        //List<WebElement> eventList = driver.findElements(ArchivePage.EVENT_LIST_LOCATOR);
        //WebElement lastEventInList = eventList.get(eventList.size() - 1);
        //Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //noinspection unchecked
        List<WebElement> elemList =
                (List<WebElement>) js.executeScript("var results = new Array();"
                        + "var element = document.evaluate(\"//*[@id='events-cont']/div/div/div[1]\""
                        + ", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);"
                        + "for ( var i = 0 ; i < element.snapshotLength ; i++ )"
                        + "{"
                        + "results.push(element.snapshotItem(i));"
                        + "}"
                        + "return results;", "");

        bobi.waitsUntilNumberOfElementsInListIsEqualOrGreaterThan(elemList, ArchivePage.MAX_EXPECTED_EVENTS_PER_PAGE);
        WebElement lastEventInList = elemList.get(elemList.size() - 1);

        js.executeScript("arguments[0].scrollIntoView(true);", lastEventInList);
        //actions.moveToElement(lastEventInList)
                //.click()
                //.build()
                //.perform();

        js.executeScript("arguments[0].click();", lastEventInList);
        //bobi.clicksOn(lastEventInList);
    }
}
