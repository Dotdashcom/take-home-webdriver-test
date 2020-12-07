package dotDash;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginPage;
import utilities.BaseClass;

import java.util.HashMap;

public class TC01_LoginSuccess extends BaseClass {

    @Test
    public void loginsuccess(){

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx","LoginSuccess");
        //Launch browser
        driver.get(baseURL+testData.get("URL"));
        //Validate page is displayed successfully
        Assert.assertEquals(driver.getTitle(),"The Internet","Page failed to open successfully");
        //Create object of LoginPage class
        LoginPage l = new LoginPage(driver);
        //Set Username
        l.setUsername(testData.get("Username"));
        //Set Password
        l.setPassword(testData.get("Password"));
        //Click LoginPage
        l.clickLogin();
        //Validate login was successful
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(l.getLoginSuccessMsg(),"You logged into a secure area!\n"+"×","Login failed!");
        softAssert.assertAll();
    }
}
