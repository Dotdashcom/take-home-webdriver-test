package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import utilities.EndPoints;

public class LoginSuccess extends TestBase {

    @Test(description = "Verify that page message is  a 'Welcome to the Secure Area. When you are done click logout below.'")
    public void loginSuccess(){

        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Successful Login Test");
        extentTest.info("Navigate To Login Page");
        loginPage.navigateTo(EndPoints.LOGIN);


        loginPage.successfulLogin();
        extentTest.info("Logged in with Valid Credentials");


        String successMessage = loginPage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Welcome to the Secure Area. When you are done click logout below.");
        extentTest.info("After Login Welcome Message is Appeared As 'Welcome to the Secure Area...'");
        extentTest.pass("Logged in Successfully");
    }
}
