package com.example.demo;

import pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T02LoginFailure extends TestMain {
    LoginPage loginPage;

    @Test
    public void testLoginFailure(){
        loginPage = new LoginPage(driver);
        loginPage.setUsername("wrongUsername");
        loginPage.setPassword("wrongPassword");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isLoginFailure());
    }

}