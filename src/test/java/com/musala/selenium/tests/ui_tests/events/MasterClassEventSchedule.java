package com.musala.selenium.tests.ui_tests.events;

import com.musala.selenium.page_objects.EventPage;
import com.musala.selenium.tests.libraries.*;
import com.musala.selenium.tests.ui_tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MasterClassEventSchedule extends BaseTest {

    private WebDriver driver;
    private BasicActions bobi;
    private HomePageActions dobri;
    private ArchiveActions niki;
    private EventActions sara;

    @BeforeTest
    public void testSetUp()
    {
        driver = getDriver();
        bobi = new BasicActions(driver);
        dobri = new HomePageActions(driver);
        niki = new ArchiveActions(driver);
        sara = new EventActions(driver);
    }

    @Test
    public void MasterClassScheduleIsPrintedOut_When_NavigatingToEvent()
    {
        dobri.navigatesToArchivePage();
        niki.clicksOnLastEventInList();
        sara.validatesEventNameIs(EventPage.MASTER_CLASS_EVENT_NAME);
        sara.printsEventSchedule();
    }
}
