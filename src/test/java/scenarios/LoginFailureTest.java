package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.ConfigReader;

public class LoginFailureTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = homePage.gotoLoginPage();
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.enterUsername(null)
                .enterPassword(null)
                .clickLoginButton();

        Assert.assertEquals(loginPage.getFailedLoginMessage(), "Your username is invalid!");

    }

    @Test
    public void loginWithInvalidUsername() {
        loginPage.enterUsername(null)
                .enterPassword(ConfigReader.getPassword())
                .clickLoginButton();

        Assert.assertEquals(loginPage.getFailedLoginMessage(), "Your username is invalid!");

    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.enterUsername(ConfigReader.getUsername())
                .enterPassword(null)
                .clickLoginButton();

        Assert.assertEquals(loginPage.getFailedLoginMessage(), "Your password is invalid!");
    }
}