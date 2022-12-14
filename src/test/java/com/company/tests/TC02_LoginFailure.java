package com.company.tests;

import com.company.pages.LoginPage;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class TC02_LoginFailure {

    @Test
    public void loginFailureUserName() {

        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
        LoginPage loginPage = new LoginPage();

        loginPage.inputUserName.sendKeys(ConfigurationReader.getProperty("usernamewrong"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

        assertTrue("Your username is invalid!", loginPage.invalidUsernameMsg.getText().contains("Your username is invalid!"));

        Driver.closeDriver();
    }
        @Test
        public void loginFailurePassword() {

            Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
            LoginPage loginPage = new LoginPage();

            loginPage.inputUserName.sendKeys(ConfigurationReader.getProperty("username"));
            loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("passwordwrong"));
            loginPage.loginBtn.click();

        assertTrue("Your password is invalid!", loginPage.invalidPasswordMsg.getText().contains("Your password is invalid!"));

            Driver.closeDriver();
    }
}