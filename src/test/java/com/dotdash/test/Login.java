package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test(testName = "Login Success", priority = 1)
    public void successfulLogin() {
        CommonMethods.navigateTo("login");
        CommonMethods.input(loginPage.userName, "tomsmith");
        CommonMethods.input(loginPage.password, "SuperSecretPassword!");
        CommonMethods.click(loginPage.submit);
        Assert.assertTrue(CommonMethods.isDisplayed(loginPage.loginSuccess));
    }

    @Test(testName = "Login Failure", priority = 2)
    public void failedLogin() {
        CommonMethods.navigateTo("login");
        CommonMethods.input(loginPage.userName, "tomsmith");
        CommonMethods.input(loginPage.password, "SuperSecretPassword");
        CommonMethods.click(loginPage.submit);
        Assert.assertTrue(CommonMethods.isDisplayed(loginPage.loginFailed));
    }
}
