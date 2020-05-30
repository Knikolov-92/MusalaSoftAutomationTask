package com.musala.selenium.page_objects;

import org.openqa.selenium.By;

public class ArchivePage {

    public final static String URL = "https://masters.musala.com/archive";

    public final static By EVENT_LIST_LOCATOR = By.cssSelector("#events-cont .event-box-home");
    public final static By SCHEDULE_IMAGE = By.className("shedule-image-container");
    public final static By HEADER_BACKGROUND_IMAGE = By.cssSelector("#container > div");
    public final static By BOTTOM_ELEMENT_ON_PAGE = By.cssSelector(".centerPartFooter a");

    public final static int MAX_EXPECTED_EVENTS_PER_PAGE = 38;
}
