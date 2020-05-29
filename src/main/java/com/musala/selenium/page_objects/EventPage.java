package com.musala.selenium.page_objects;

import org.openqa.selenium.By;

public class EventPage {

    public final static String MASTER_CLASS_EVENT_NAME = "Master Class";
    public final static By EVENT_NAME = By.cssSelector(".event-body");
    public final static By EVENT_DAYS_BOX_LOCATOR = By.xpath
                            ("//*[@id='content']/ul[position()>0]/li/*[text()[contains(.,'Day')]]");
    public final static By EVENT_DAY1_SPEAKER_INFO = By.xpath
                            ("//*[@id='content']/ul[position()>1 and position()<6]/div/li/div[1]/div[2]");
    public final static By EVENT_DAY2_SPEAKER_INFO = By.xpath
                         ("//*[@id='content']/ul[position()>6 and position()<12]/div/li/div[1]/div[2]");
    public final static By EVENT_DAY3_SPEAKER_INFO = By.xpath
                         ("//*[@id='content']/ul[position()>12 and position()<16]/div/li/div[1]/div[2]");
    public final static By GOOGLE_MAPS_LOCATOR = By.cssSelector
                        ("#map-canvas > div:nth-child(1) > div > div:nth-child(1) > div:nth-child(3)");
}
