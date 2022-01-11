package com.example.demo;

import pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T01LoginSuccess extends TestMain {
    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isLoginSuccess());
    }


}