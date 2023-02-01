package com.academy.techcenture;

import com.academy.techcenture.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassTest {

    @Test
    public void login(){
        LoginPage loginPage = new LoginPage(driver,softAssert);
        loginPage.login();
    }

    @Test
    public void loginNegative(){
        LoginPage loginPage = new LoginPage(driver,softAssert);
        loginPage.loginNegative();
    }
}
