package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.LoginFormPage;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends UITest {

    //private final String username;
    private final String DEFAULT_USERNAME  = "tomsmith";
    //private final String password;
    private final String DEFAULT_PASSWORD = "SuperSecretPassword!";
    //private final String invalid;

    public LoginTest() {}

    @Parameters({"username", "password"})
    @Test(description="Login form - Using valid Credentials", groups={ "loginForm" })
    public void successfulLogin(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
        LoginFormPage loginFormPage = new LoginFormPage(this);

        // Validate page loaded
        Assert.assertTrue(loginFormPage.isPageOpen(), "Page not open");

        // Validate login succeeded
        this.login(username, password);
        Assert.assertEquals(this.getDriver().getCurrentUrl(), loginFormPage.EXPECTED_LOGGED_IN_PAGE_URL);
    }

    @Parameters({"username", "password"})
    @Test(description="Login form - Using invalid Username", groups={ "loginForm" })
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
    @Test(description="Login form - Using invalid Password", groups={ "loginForm" })
    public void invalidPassword(@Optional(DEFAULT_USERNAME) String username, @Optional(DEFAULT_PASSWORD) String password) {
        String expectedPasswordErrorMessage = "Your password is invalid!";
        LoginFormPage loginFormPage = this.login(username, "invalidPassword");

        // Validate page loaded
        Assert.assertTrue(loginFormPage.isPageOpen(), "Page not open");

        // Validate login failed due to invalid password
        Assert.assertNotEquals(this.getDriver().getCurrentUrl(), loginFormPage.EXPECTED_LOGGED_IN_PAGE_URL);
        Assert.assertTrue(loginFormPage.getErrorMessage().contains(expectedPasswordErrorMessage), "expectedErrorMessage mismatch");
    }

    private @NotNull LoginFormPage login(String username, String password) {
        LoginFormPage loginFormPage = new LoginFormPage(this);
        loginFormPage.setUsername(username);
        loginFormPage.setPassword(password);
        loginFormPage.clickLoginButton();
        return loginFormPage;
    }
}