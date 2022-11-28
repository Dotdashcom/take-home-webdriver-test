package com.dotdash.selenium;

import com.dotdash.selenium.pages.HomePage;
import com.dotdash.selenium.pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTests extends SetUpTearDown {
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
        loginPage.loginUser("invaliduser", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.getLoginNotificationBanner().contains("Your username is invalid!"));
    }

    @Test
    public void verifyLoginPasswordFailure(){
        homePage.clickFormAuthLink();
        loginPage.loginUser("tomsmith", "invalidpassword!");
        Assert.assertTrue(loginPage.getLoginNotificationBanner().contains("Your password is invalid!"));
    }

}
