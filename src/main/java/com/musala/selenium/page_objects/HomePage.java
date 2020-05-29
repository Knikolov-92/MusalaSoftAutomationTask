package com.musala.selenium.page_objects;

import org.openqa.selenium.By;

public class HomePage {

    public final static By SIGNIN_BUTTON_LINK = By.linkText("Sign In");
    public final static By ARCHIVE_BUTTON_LINK = By.linkText("Archive");
    public final static By MUSALASOFT_FOOTER_LINK = By.cssSelector(".leftPartFooter a");
    public final static By FACEBOOK_FOOTER_LINK = By.cssSelector(".rightPartFooter a.pull-right");
}
