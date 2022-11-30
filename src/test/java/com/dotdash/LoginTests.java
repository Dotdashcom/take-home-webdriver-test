package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.GeneratePage;
import com.dotdash.pageobjects.LoginPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTests extends BaseTest {

    @Test
    public void mustLoginSuccessfully(){
        LoginPage loginPage = GeneratePage
                .loginPage()
                .goToLoginPage()
                .loginToApplication("tomsmith", "SuperSecretPassword!");

        assertThat(loginPage.getAlertMessage(), is("You logged into a secure area!"));
    }

    @Test
    public void mustFailLogin(){
        LoginPage loginPage = GeneratePage
                .loginPage()
                .goToLoginPage()
                .loginToApplication("InvalidUsername", "InvalidPassword");

        assertThat(loginPage.getAlertMessage(), is("Your username is invalid!"));
    }
}
