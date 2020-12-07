package dotDash;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginPage;
import utilities.BaseClass;

import java.util.HashMap;

public class TC02_LoginFailure extends BaseClass {

    @Test
    public void loginFailure(){

        //Fetch data from Excel
        HashMap<String, String> testData = fnReadTestDataFromExcel("dotdashDatasheet.xlsx","LoginFailure");
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
        //Validate login failed
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(l.getLoginFailureMsg(),"Your username is invalid!\n"+"×","Login did not fail");
        softAssert.assertAll();
    }
}
