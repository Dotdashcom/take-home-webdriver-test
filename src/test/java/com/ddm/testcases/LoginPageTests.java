package com.ddm.testcases;

import com.ddm.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTestClass {

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUpMethodLoginPage() {
        loginPage = landingPage.goTo("/login", LoginPage.class);
    }

    @Test(priority = 0)
    public void LoginFailWrongUserName() {
        loginPage.login(invalidUsername, password);

        String statusText = loginPage.getStatusText();
        Assert.assertTrue(statusText.contains("Your username is invalid!"), "Login is NOT failed.");
    }

    @Test(priority = 1)
    public void LoginFailWrongPassword() {
        loginPage.login(username, invalidPassword);

        String statusText = loginPage.getStatusText();
        Assert.assertTrue(statusText.contains("Your password is invalid!"), "Login is NOT failed.");
    }

    @Test(priority = 2)
    public void LoginSuccess() {
        loginPage.login(username, password);

        String statusText = loginPage.getStatusText();
        Assert.assertTrue(statusText.contains("You logged into a secure area!"), "Login failed.");
    }
}
