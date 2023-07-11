package com.takehome.test;

import com.takehome.BaseWeb;
import com.takehome.page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.takehome.config.ConfigurationManager.configuration;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginFailureTests extends BaseWeb {

    @BeforeMethod
    public void openPath() {
        open("login");
    }

    @Test(description = "Test is not able to login with wrong credentials.")
    public void TestIsNotAbleToLoginWithWrongCredentials() {

        var loginPage = new LoginPage();
        loginPage.fillUsername(configuration().username());
        loginPage.fillPassword("fsdfsd!");
        loginPage.clickLogin();

        assertThat(loginPage.isLoginErrorBannerDisplayed()).withFailMessage("Login error banner is not present!")
                .isTrue();

    }
}
