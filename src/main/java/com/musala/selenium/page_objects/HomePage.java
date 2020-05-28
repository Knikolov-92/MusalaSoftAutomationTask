package com.musala.selenium.page_objects;

import org.openqa.selenium.By;

public class HomePage {

    public final static By SIGNIN_BUTTON_LINK = By.cssSelector("#desktopNavBtns > " +
            "nav.collapse.navbar-collapse.bs-navbar-collapse.navbar-menu-desktop > ul > li:nth-child(5) > a");
}
