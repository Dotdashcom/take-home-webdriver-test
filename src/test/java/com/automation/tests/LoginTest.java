package com.automation.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void test(){
        loginPage.clickOnLink();
        loginPage.loginWithValidCredentials();
        loginPage.loginWithInvalidCredentials();
    }

}
