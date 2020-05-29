package com.musala.selenium.page_objects;

import org.openqa.selenium.By;

public class FacebookPage {

    public final static String URL = "https://www.facebook.com/MUFFINconference/";
    public final static String TITLE = "MUFFIN Conference - Home | Facebook";
    public final static String PROFILE_PICTURE_PATH =
                                        "https://www.facebook.com/294917594015893/photos/1113744822133162/";

    public final static By PROFILE_PICTURE = By.cssSelector("a[aria-label='Profile picture']");
}
