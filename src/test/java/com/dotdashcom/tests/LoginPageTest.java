package com.dotdashcom.tests;

import com.dotdashcom.MainTest;
import com.dotdashcom.pagemodels.LoginPageModel;
import com.dotdashcom.pagemodels.SecurePageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends MainTest {

    LoginPageModel page;
    SecurePageModel securePage;

    private void init() {
        page = new LoginPageModel(driver);
        driver.get(BASE_URL + LoginPageModel.PAGE_URL);
    }

    @Test(testName = "WHEN_correct_credentials_THEN_login_successful")
    void WHEN_correct_credentials_THEN_login_successful() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPageModel.PAGE_URL));

        page.enterUsername();
        page.enterPassword();
        page.pressLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(SecurePageModel.PAGE_URL));

        securePage = new SecurePageModel(driver);
        Assert.assertTrue(securePage.getMessageText().contains(SecurePageModel.LOGIN_SUCCESSFUL_MESSAGE));
    }

    @Test(testName = "WHEN_incorrect_username_THEN_login_fails")
    void WHEN_incorrect_username_THEN_login_fails() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPageModel.PAGE_URL));

        page.enterWrongUsername();
        page.enterPassword();
        page.pressLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().contains(SecurePageModel.PAGE_URL));
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPageModel.PAGE_URL));
        Assert.assertTrue(page.getMessageText().contains(LoginPageModel.INVALID_USERNAME_MESSAGE));
    }

    @Test(testName = "WHEN_incorrect_password_THEN_login_fails")
    void WHEN_incorrect_password_THEN_login_fails() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPageModel.PAGE_URL));

        page.enterUsername();
        page.enterWrongPassword();
        page.pressLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().contains(SecurePageModel.PAGE_URL));
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPageModel.PAGE_URL));
        Assert.assertTrue(page.getMessageText().contains(LoginPageModel.INVALID_PASSWORD_MESSAGE));
    }

    @Test(testName = "WHEN_empty_credentials_THEN_login_fails")
    void WHEN_empty_credentials_THEN_login_fails() {

        init();
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPageModel.PAGE_URL));

        page.pressLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().contains(SecurePageModel.PAGE_URL));
        Assert.assertTrue(driver.getCurrentUrl().contains(LoginPageModel.PAGE_URL));
        Assert.assertTrue(page.getMessageText().contains(LoginPageModel.INVALID_USERNAME_MESSAGE));
    }

}
