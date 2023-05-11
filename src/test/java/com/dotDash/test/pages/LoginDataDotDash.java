package com.dotDash.test.pages;

import org.testng.annotations.DataProvider;

public class LoginDataDotDash {

    @DataProvider(name = "loginParameters")
    public Object[][] loginData() {
        return new Object[][] {
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},
                {"", "SuperSecretPassword!", "Your username is invalid!"},
                {"tomsmith", "", "Your password is invalid!"},
                {"tomsmith", "SuperSecretPassword!!", "Your password is invalid!"},
                {"tomsmith!!", "SuperSecretPassword!", "Your username is invalid!"},
        };
    }
}
