package com.musala.selenium.page_objects;

import org.openqa.selenium.By;

public class SignInPage {

    //locators
    public final static By USERNAME_FIELD = By.id("login-form_username");
    public final static By PASSWORD_FIELD = By.id("login-form_password");
    public final static By SUBMIT_SIGNIN_BUTTON = By.id("btn-sign-in");
    public final static By ERROR_MESSAGE = By.xpath("//*[@id='login-form']/div/div[2]/p");

    //error text
    public final static String ERROR_MESSAGE_TEXT = "Wrong user or password.";
}
