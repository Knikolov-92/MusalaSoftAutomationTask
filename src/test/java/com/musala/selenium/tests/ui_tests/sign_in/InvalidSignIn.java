package com.musala.selenium.tests.ui_tests.sign_in;

import com.musala.selenium.tests.libraries.BasicActions;
import com.musala.selenium.tests.libraries.HomePageActions;
import com.musala.selenium.tests.libraries.SignInActions;
import com.musala.selenium.tests.ui_tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class InvalidSignIn extends BaseTest {

    private WebDriver driver;
    private BasicActions bobi;
    private HomePageActions dobri;
    private SignInActions mimi;
    private static String excelFilePath = System.getProperty("user.dir")
                            + "\\src\\test\\java\\com\\musala\\selenium\\tests\\ui_tests\\sign_in\\SignInData.xlsx";
    private static String excelDataSheetName = "InvalidData";


    @BeforeTest
    public void testSetUp()
    {
        driver = getDriver();
        bobi = new BasicActions(driver);
        dobri = new HomePageActions(driver);
        mimi = new SignInActions(driver);
    }
    @Test
    public void CorrectErrorMessageIsDisplayed_When_SigningInWithInvalidData() throws IOException
    {
        String userName;
        String password;
        int numberOfTimesToSignIn = 5;
        int numberOfInvalidCombinations = 5;

        dobri.navigatesToSignInPage();

        for (int i = 1; i < numberOfInvalidCombinations + 1; i++)
        {
            for (int j = 1; j < numberOfTimesToSignIn + 1; j++)
            {
                userName = mimi.getsSignInCredentialsFromExcelFile(excelFilePath, excelDataSheetName, i).get(0);
                password = mimi.getsSignInCredentialsFromExcelFile(excelFilePath, excelDataSheetName, i).get(1);

                mimi.entersAccountData(userName, password);
                System.out.print("attempt " + j + ", uname: " + userName + ", pass: " + password +"\n");
                mimi.submitsAccountData();
                mimi.validatesErrorMessageIsDisplayed();
                //mimi.clearsSignInFields();
                mimi.resetsSignInForm();
            }
        }
    }
}