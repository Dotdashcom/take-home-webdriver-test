package com.dotdash.tests;

import com.dotdash.pages.LoginPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test02_LoginFailure {

    /**
     * Page Object Model for the login page should be used.
     * Test is not able to login with wrong credentials.
     * Test uses assertions to check Login failed for incorrect user and password.
     */

    @Test
    public void loginWithWrongCredentialsTest(){

        LoginPage loginPage = new LoginPage();

        String url = ConfigurationReader.getProperty("base.url") + "/login";
        Driver.getDriver().get(url);

        loginPage.username.sendKeys("WRONGusername");
        loginPage.password.sendKeys("WRONGpassword");
        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.resultMsg.getText().contains("Your username is invalid!"));

        Driver.closeDriver();

    }

    @Test
    public void loginWithWrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        String url = ConfigurationReader.getProperty("base.url") + "/login";
        Driver.getDriver().get(url);

        loginPage.username.sendKeys("WRONGusername");
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.resultMsg.getText().contains("Your username is invalid!"));

        Driver.closeDriver();

    }

    @Test
    public void loginWithWrongPasswordTest() {

        LoginPage loginPage = new LoginPage();

        String url = ConfigurationReader.getProperty("base.url") + "/login";
        Driver.getDriver().get(url);

        loginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys("WRONGpassword");
        loginPage.loginBtn.click();

        Assert.assertTrue(loginPage.resultMsg.getText().contains("Your password is invalid!"));

        Driver.closeDriver();

    }

}
