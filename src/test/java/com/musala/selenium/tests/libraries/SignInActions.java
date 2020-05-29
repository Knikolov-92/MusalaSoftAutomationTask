package com.musala.selenium.tests.libraries;

import com.musala.selenium.page_objects.HomePage;
import com.musala.selenium.page_objects.SignInPage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class SignInActions {

    private WebDriver driver;
    private BasicActions bobi;

    public SignInActions(WebDriver driver)
    {
        this.driver = driver;
        bobi = new BasicActions(this.driver);
    }

    public List<String> getsSignInCredentialsFromExcelFile(String filePath, String sheetName, int rowNumber)
            throws IOException
    {
        String userName = null;
        String password = null;
        List<String> signInCredentials = new ArrayList<>();

        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook excelFile = new XSSFWorkbook(inputStream);
        
        Sheet sheet = excelFile.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);

        //get username cell value
        Cell cellUserName = row.getCell(1);

            if (cellUserName.getCellType().equals(NUMERIC)) {
                userName = Integer.toString((int)cellUserName.getNumericCellValue());
    
            } else if (cellUserName.getCellType().equals(STRING)) {
                userName = cellUserName.getStringCellValue();
            }

        //get password cell value
        Cell cellPassword = row.getCell(2);

            if (cellPassword.getCellType().equals(NUMERIC)) {
                password = Integer.toString((int)cellPassword.getNumericCellValue());
    
            } else if (cellPassword.getCellType().equals(STRING)) {
                password = cellPassword.getStringCellValue();
            }

        //add username, password to list
        signInCredentials.add(userName);
        signInCredentials.add(password);
        
        return signInCredentials;
    }

    public void entersAccountData(String name, String password)
    {
        bobi.fillsFieldWithText(SignInPage.USERNAME_FIELD, name);
        bobi.fillsFieldWithText(SignInPage.PASSWORD_FIELD, password);
    }

    public void submitsAccountData()
    {
        bobi.clicksOn(SignInPage.SUBMIT_SIGNIN_BUTTON);
    }

    public void clearsSignInFields()
    {
        bobi.clearsTextOfField(SignInPage.USERNAME_FIELD);
        bobi.clearsTextOfField(SignInPage.PASSWORD_FIELD);
        bobi.waitsForElementTextToBeEmpty(SignInPage.USERNAME_FIELD);
    }

    public void validatesErrorMessageIsDisplayed()
    {
        String actualErrorText;
        String expectedErrorText = SignInPage.ERROR_MESSAGE_TEXT;

        bobi.waitsForElementToBeVisible(SignInPage.ERROR_MESSAGE);
        actualErrorText = driver.findElement(SignInPage.ERROR_MESSAGE).getText();

        Assert.assertEquals(actualErrorText, expectedErrorText);
    }

    public void resetsSignInForm()
    {
        bobi.waitsForElementToBeClickable(HomePage.SIGNIN_BUTTON_LINK);
        bobi.clicksOn(HomePage.SIGNIN_BUTTON_LINK);
        bobi.waitsForElementToBeVisible(SignInPage.SUBMIT_SIGNIN_BUTTON);
    }
}
