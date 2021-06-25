package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.EndPoints;

public class LoginFailure extends TestBase {

    @Test(description = "Verify that page message is is a 'Your username is invalid!'")
    public void loginSuccess(){

        //create page object
        LoginPage loginPage = new LoginPage();
        extentTest = extentReports.createTest("Unsuccessful Login Test");
        extentTest.info("Navigate To Login Page");
        loginPage.navigateTo(EndPoints.LOGIN);

        loginPage.failedLogin();
        extentTest.info("Logged in with Invalid Credentials");

        String failedMessage = loginPage.getFailedMessage();
        Assert.assertTrue(failedMessage.contains("Your username is invalid!"));
        extentTest.info(" 'Your username is invalid!' Message is Appeared");
        extentTest.pass("Log in is Unsuccessful");
    }
}
