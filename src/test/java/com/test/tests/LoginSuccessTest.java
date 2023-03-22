package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.test.pages.LoginPage;

public class LoginSuccessTest extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        String successMessage = loginPage.getSuccessMessage();
        assertTrue(successMessage.contains("You logged into a secure area!"));
    }

}
