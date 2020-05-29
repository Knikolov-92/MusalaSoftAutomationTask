package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.EventPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class EventActions {

    private WebDriver driver;
    private BasicActions bobi;

    public EventActions(WebDriver driver)
    {
        this.driver = driver;
        bobi = new BasicActions(this.driver);
    }

    public void validatesEventNameIs(String eventName)
    {
        bobi.waitsForElementToBeVisible(EventPage.EVENT_NAME);
        String expectedName = eventName;
        String actualName = driver.findElement(EventPage.EVENT_NAME).getText().substring(5);

        Assert.assertEquals(actualName, expectedName);
    }
    public void printsEventSchedule()
    {
        String day;
        String event;
        String elementText;

        bobi.waitsForElementToBeVisible(EventPage.GOOGLE_MAPS_LOCATOR);
        List<WebElement> eventDays = driver.findElements(EventPage.EVENT_DAYS_BOX_LOCATOR);
        List<WebElement> day1Schedule = driver.findElements(EventPage.EVENT_DAY1_SPEAKER_INFO);
        List<WebElement> day2Schedule = driver.findElements(EventPage.EVENT_DAY2_SPEAKER_INFO);
        List<WebElement> day3Schedule = driver.findElements(EventPage.EVENT_DAY3_SPEAKER_INFO);

        for (int i = 1; i < eventDays.size() + 1; i++)
        {
            switch(i)
            {
                case 1:
                    day = eventDays.get(i - 1).getText().trim();
                    System.out.println(day + ":");

                    for (int j = 0; j < day1Schedule.size(); j++)
                    {
                        elementText = day1Schedule.get(j).getText().trim();
                        event = getsEventNameFromSpeakerInfo(elementText);
                        System.out.println(event);
                    }
                    break;

                case 2:
                    day = eventDays.get(i - 1).getText().trim();
                    System.out.println("\n" + day + ":");

                    for (int j = 0; j < day2Schedule.size(); j++)
                    {
                        elementText = day2Schedule.get(j).getText().trim();
                        event = getsEventNameFromSpeakerInfo(elementText);
                        System.out.println(event);
                    }
                    break;

                case 3:
                    day = eventDays.get(i - 1).getText().trim();
                    System.out.println("\n" + day + ":");

                    for (int j = 0; j < day3Schedule.size(); j++)
                    {
                        elementText = day3Schedule.get(j).getText().trim();
                        event = getsEventNameFromSpeakerInfo(elementText);
                        System.out.println(event);
                    }
                    break;
            }
        }

    }

    public String getsEventNameFromSpeakerInfo(String rawText)
    {
        return rawText.substring(rawText.lastIndexOf("\n")).trim();
    }

}
