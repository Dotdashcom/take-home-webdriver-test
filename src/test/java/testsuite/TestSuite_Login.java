package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.SecurePage;

public class TestSuite_Login extends BaseTestClass {

    @Test(description = "Login Success")
    public void TC_Login_001_Validate_SuccessfulLogin() {
        String userName = "tomsmith";
        String password = "SuperSecretPassword!";
        ActionHelper.openUrl(Constants.LOGIN_PAGE_URL);
        LoginPage loginPage = LoginPage.getInstance();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        System.out.println(SecurePage.getInstance().getMessageText());
        Assert.assertTrue(SecurePage.getInstance().getMessageText().contains("You logged into a secure area!"),
                "Unable to Login SuccessFully");
    }

    @Test(description = "Login Success")
    public void TC_Login_002_Validate_InvalidLogin() {
        String userName = "abc";
        String password = "abc!";
        ActionHelper.openUrl(Constants.LOGIN_PAGE_URL);
        LoginPage loginPage = LoginPage.getInstance();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getMessageText().contains("Your username is invalid!"),
                "Unable to Login SuccessFully");
    }
}
