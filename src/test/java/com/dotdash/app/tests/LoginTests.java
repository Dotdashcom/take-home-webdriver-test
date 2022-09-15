package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.app.pageobjects.LoginPage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTests extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyLoginSuccess(){
        homePage.clickFormAuthLink();
        loginPage.loginUser("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isLoginSuccessful());
        Assert.assertTrue(loginPage.getLoginNotificationBanner().contains("You logged into a secure area!"));
    }

    @Test
    public void verifyLoginUsernameFailure(){
        homePage.clickFormAuthLink();
        loginPage.loginUser("smithtom", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.getLoginNotificationBanner().contains("Your username is invalid!"));
    }

    @Test
    public void verifyLoginPasswordFailure(){
        homePage.clickFormAuthLink();
        loginPage.loginUser("tomsmith", "NotSoSuperSecretPassword!");
        Assert.assertTrue(loginPage.getLoginNotificationBanner().contains("Your password is invalid!"));
    }

}
