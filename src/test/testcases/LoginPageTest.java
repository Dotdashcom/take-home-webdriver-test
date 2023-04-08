package com.framework.testcases;
import com.framework.pages.LoginPage;
import com.framework.pages.SecurePage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    SecurePage securePage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 2, description = "User can successfully login using valid credentials")
    public void user_login_success_valid_username_and_password() {
        loginPage = new LoginPage(driver);
        loginPage.navigate();
        securePage = loginPage.login("tomsmith", "SuperSecretPassword!");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/secure";

        Boolean isSuccessMessageDisplayed = securePage.validateSuccessMessage();
        Boolean isWelcomeAreaDisplayed = securePage.validateWelcomeArea();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(isSuccessMessageDisplayed);
        Assert.assertTrue(isWelcomeAreaDisplayed);

        securePage.logout();
    }

    @Test(priority = 2, description = "User enters valid username and invalid password")
    public void user_login_fail_invalid_password_only() {
        loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("tomsmith", "super");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/login";

        Boolean isInvalidPasswordMessage = loginPage.validateFailedMessage().contains("Your password is invalid!");

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(isInvalidPasswordMessage);
    }

    @Test(priority = 2, description = "User enters invalid username and valid password")
    public void user_login_fail_invalid_username_only() {
        loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("tom", "SuperSecretPassword!");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/login";

        Boolean isInvalidUsernameMessage = loginPage.validateFailedMessage().contains("Your username is invalid!");

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(isInvalidUsernameMessage);
    }

    @Test(priority = 2, description = "User enters invalid username and invalid password")
    public void user_login_fail_invalid_username_and_password() {
        loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login("", "");

        String actualURL = loginPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/login";

        Boolean isInvalidUsernameMessage = loginPage.validateFailedMessage().contains("Your username is invalid!");

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(isInvalidUsernameMessage);
    }
    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.navigate();
        String actualURL = loginPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/login";
        Assert.assertEquals(actualURL, expectedURL);
    }
}
