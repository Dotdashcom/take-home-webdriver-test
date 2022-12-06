package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.LoginSuccessPage;

public class LoginSuccessTest extends TestBase{
    LoginSuccessPage loginPage;

    public LoginSuccessTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get(prop.getProperty("url"));
        loginPage = new LoginSuccessPage();
    }

    @Test()
    public void loginSuccessTest() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(loginPage.validateLoginPageTitle(), "Secure Area");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
