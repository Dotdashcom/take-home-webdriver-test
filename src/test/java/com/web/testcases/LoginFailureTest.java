package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.LoginFailurePage;

public class LoginFailureTest extends TestBase{
    LoginFailurePage loginFailurePage;

    public LoginFailureTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get(prop.getProperty("url"));
        loginFailurePage = new LoginFailurePage();
    }


    @Test()
    public void loginFailureTest()
    {
        loginFailurePage.login(prop.getProperty("Fusername"), prop.getProperty("Fpassword"));
        Assert.assertTrue(loginFailurePage.validateLoginFailure().contains("Your password is invalid!"));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
