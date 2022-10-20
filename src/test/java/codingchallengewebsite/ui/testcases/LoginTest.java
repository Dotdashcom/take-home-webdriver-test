package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITests;
import codingchallengewebsite.ui.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends UITests {

    private static final String DEFAULT_USERNAME = "tomsmith";
    private static final String DEFAULT_PASSWORD = "SuperSecretPassword!";

    public LoginTest () {
    }

    @Parameters({"username", "password"})
    @Test(description="Successful login")
    public void loginSuccess(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
        String expectedLoggedInPage = new StringBuilder().append(DEFAULT_BASE_URL).append("/secure").toString();

        LoginPage loginPage = new LoginPage(this.driver, this);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(this.driver.getCurrentUrl(), expectedLoggedInPage);
    }

    @Parameters({"username", "password"})
    @Test(description="Failed login")
    public void loginFailure(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
        String expectedUserErrorMessage = "Your username is invalid!";
        String expectedPasswordErrorMessage = "Your password is invalid!";
        String expectedLoggedInPage = new StringBuilder().append(DEFAULT_BASE_URL).append("/secure").toString();

        LoginPage loginPage = new LoginPage(this.driver, this);
        Assert.assertTrue(loginPage.isPageOpen());

        // Invalid username
        loginPage.setUsername("invalidUsername");
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertNotEquals(this.driver.getCurrentUrl(), expectedLoggedInPage);
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedUserErrorMessage), "expectedErrorMessage mismatch");

        // Invalid password
        loginPage.setUsername(username);
        loginPage.setPassword("invalidPassword");
        loginPage.clickLoginButton();
        Assert.assertNotEquals(this.driver.getCurrentUrl(), expectedLoggedInPage);
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedPasswordErrorMessage), "expectedErrorMessage mismatch");
    }

}
