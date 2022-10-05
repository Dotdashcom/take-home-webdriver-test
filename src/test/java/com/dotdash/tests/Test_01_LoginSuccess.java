package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.LoginPage;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_01_LoginSuccess extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest_positive() {

        loginPage.navigatePages("Form Authentication");
        loginPage.userName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginBtn.click();

        Assertions.assertTrue(DriverUtils.getDriver().getCurrentUrl().contains("secure"));
        Assertions.assertTrue(loginPage.successMsg.getText().contains("You logged into a secure area!"));
    }
}
