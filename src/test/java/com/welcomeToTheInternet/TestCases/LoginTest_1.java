package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest_1 extends BaseClass{

    @Test
    public void LoginTest() throws IOException {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.setUserName(username);
        logger.info("Valid username provided");
        loginPage.setUserPassword(password);
        logger.info("Valid password provided");
        loginPage.clickSubmit();
        logger.info("Submit button clicked");

        boolean isLoggedOn = driver.getPageSource().contains("You logged into a secure area!");
        if (isLoggedOn) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Success login procedure");
            Assert.fail();
        }
    }
}
