package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.LoginFormPage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFormTest extends UITest {

    private final String DEFAULT_USERNAME  = "tomsmith";
    private final String DEFAULT_PASSWORD = "SuperSecretPassword!";

    public LoginFormTest() { }

    @Parameters({"username", "password"})
    @Test(description="Credentials validation - Valid Credentials")
    public void successfulLogin(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
        LoginFormPage loginFormPage = new LoginFormPage(this.getDriver(), this);

        // Validate page loaded
        Assert.assertTrue(loginFormPage.isPageOpen(), "Page not open");

        // Validate login succeeded
        this.login(username, password);
        Assert.assertEquals(this.getDriver().getCurrentUrl(), loginFormPage.EXPECTED_LOGGED_IN_PAGE_URL);
    }

    @Parameters({"username", "password"})
    @Test(description="Credentials validation - Invalid Username")
    public void invalidUsername(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
        String expectedUserErrorMessage = "Your username is invalid!";
        LoginFormPage loginFormPage = this.login("invalidUsername", password);

        // Validate page loaded
        Assert.assertTrue(loginFormPage.isPageOpen(), "Page not open");

        // Validate login failed due to invalid username
        Assert.assertNotEquals(this.getDriver().getCurrentUrl(), loginFormPage.EXPECTED_LOGGED_IN_PAGE_URL);
        Assert.assertTrue(loginFormPage.getErrorMessage().contains(expectedUserErrorMessage), "expectedErrorMessage mismatch");
    }

    @Parameters({"username", "password"})
    @Test(description="Credentials validation - Invalid Password")
    public void invalidPassword(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
        String expectedPasswordErrorMessage = "Your password is invalid!";
        LoginFormPage loginFormPage = this.login(username, "invalidPassword");

        // Validate page loaded
        Assert.assertTrue(loginFormPage.isPageOpen(), "Page not open");

        // Validate login failed due to invalid password
        Assert.assertNotEquals(this.getDriver().getCurrentUrl(), loginFormPage.EXPECTED_LOGGED_IN_PAGE_URL);
        Assert.assertTrue(loginFormPage.getErrorMessage().contains(expectedPasswordErrorMessage), "expectedErrorMessage mismatch");
    }

    private LoginFormPage login(String username, String password) {
        LoginFormPage loginFormPage = new LoginFormPage(this.getDriver(), this);
        loginFormPage.setUsername(username);
        loginFormPage.setPassword(password);
        loginFormPage.clickLoginButton();
        return loginFormPage;
    }
}