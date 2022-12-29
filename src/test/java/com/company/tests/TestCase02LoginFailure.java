package com.company.tests;

import com.company.pages.LoginPage;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

/**
 Page Object Model for the login page should be used.
 Test is not able to log in with wrong credentials.
 Test uses assertions to check Login failed for incorrect user and password.
 */

public class TestCase02LoginFailure {

    @Test
    public void loginFailureUserName() {

        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
        LoginPage loginPage = new LoginPage();

        loginPage.inputUserName.sendKeys(ConfigurationReader.getProperty("username_wrong"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

        assertTrue("Your username is invalid!", loginPage.invalidUsernameMsg.getText().contains("Your username is invalid!"));

        loginPage.inputUserName.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password_wrong"));
        loginPage.loginBtn.click();

        assertTrue("Your password is invalid!", loginPage.invalidPasswordMsg.getText().contains("Your password is invalid!"));

        Driver.closeDriver();
    }
}