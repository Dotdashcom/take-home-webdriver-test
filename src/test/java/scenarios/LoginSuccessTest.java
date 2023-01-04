package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SecurePage;
import utils.ConfigReader;


public class LoginSuccessTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = homePage.gotoLoginPage();
    }

    @Test
    public void loginWithValidCredentials() {
        SecurePage securePage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        Assert.assertEquals(securePage.getSuccessLoginMessage(), "You logged into a secure area!");
    }
}