package com.takehome.test;

import com.takehome.BaseWeb;
import com.takehome.page.LoginPage;
import com.takehome.page.SecureAreaPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.takehome.config.ConfigurationManager.configuration;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSuccessTests extends BaseWeb {

    @BeforeMethod
    public void openPath() {
        open("login");
    }

    @Test(description = "Test is able to login successfully")
    public void tesIsAbleToLoginSuccessfully() {

        var loginPage = new LoginPage();
        loginPage.fillUsername(configuration().username());
        loginPage.fillPassword(configuration().password());
        loginPage.clickLogin();

        var secureAreaPage = new SecureAreaPage();

        assertThat(secureAreaPage.isLoginSuccessBannerDisplayed()).withFailMessage("Login success banner is not present!")
                .isTrue();

    }
}
