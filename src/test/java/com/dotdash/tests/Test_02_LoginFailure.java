package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_02_LoginFailure extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest_negative1() {

        loginPage.navigatePages("Form Authentication");
        loginPage.userName.sendKeys("tomsmith");
        loginPage.password.sendKeys("Secret");
        loginPage.loginBtn.click();

        Assertions.assertTrue(loginPage.errorMsg.getText().contains("Your password is invalid!"));
    }

    @Test
    public void loginTest_negative2() {

        loginPage.navigatePages("Form Authentication");
        loginPage.userName.sendKeys("**");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginBtn.click();

        Assertions.assertTrue(loginPage.errorMsg.getText().contains("Your username is invalid!"));
    }

}
