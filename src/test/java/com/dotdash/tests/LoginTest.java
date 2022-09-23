package com.dotdash.tests;

import com.dotdash.pages.LoginPage;
import com.dotdash.pages.TestBase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest1() {

        loginPage.navigatePages("Form Authentication");
        loginPage.userName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginBtn.click();

        Assertions.assertTrue(loginPage.successMsg.getText().contains("You logged into a secure area!"));
    }

    @Test
    public void loginTest2() {

        loginPage.navigatePages("Form Authentication");
        loginPage.userName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPasswor");
        loginPage.loginBtn.click();

        Assertions.assertTrue(loginPage.errorMsg.getText().contains("Your password is invalid!"));
    }


    @Test
    public void loginTest3() {

        loginPage.navigatePages("Form Authentication");
        loginPage.userName.sendKeys("");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginBtn.click();

        Assertions.assertTrue(loginPage.errorMsg.getText().contains("Your username is invalid!"));
    }

}
