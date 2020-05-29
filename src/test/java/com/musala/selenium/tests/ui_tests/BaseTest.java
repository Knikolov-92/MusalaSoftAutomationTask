package com.musala.selenium.tests.ui_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseTest {

    private WebDriver driver;
    private static String driverPath = System.getProperty("user.dir") + "/webdrivers/";


    @Parameters({ "browser", "baseURL" })
    @BeforeTest(alwaysRun = true)
    public void initializeDriver(String browser, String baseURL)
    {
        try
        {
            setDriverAndNavigateToBaseURL(browser, baseURL);

        } catch(Exception e)
        {
            System.out.println("Error, driver initialization failed.." + e.getStackTrace() );
        }
    }


    private void setDriverAndNavigateToBaseURL(String browser, String baseURL)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            this.driver = initChrome();

        } else if (browser.equalsIgnoreCase("firefox"))
        {
            this.driver = initFirefox();

        } else
            {
                System.out.println("Default option selected: initializing Chrome driver..");
                this.driver = initChrome();
            }
        this.driver.manage().window().maximize();
        this.driver.navigate().to(baseURL);
    }


    private static WebDriver initChrome()
    {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        return driver;
    }


    private static WebDriver initFirefox()
    {
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        return driver;
    }


    public WebDriver getDriver()
    {
        return this.driver;
    }

    @AfterTest
    public void closeBrowserWindow()
    {
        this.driver.quit();
    }

}
