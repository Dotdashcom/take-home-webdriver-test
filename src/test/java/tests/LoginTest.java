package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{
    @Test
    public void verifySuccessLogin() {
        HomePage homepage = new HomePage(driver);
        LoginPage login = homepage.clickAuthenticationLink();
        login.login("tomsmith", "SuperSecretPassword!");
        assertTrue(login.getLoginMessage().contains("You logged into a secure area!"));
    }

    @Test
    public void verifyFailedLoginWithInvalidUsername() {
        HomePage homepage = new HomePage(driver);
        LoginPage login = homepage.clickAuthenticationLink();
        login.login("invalid", "SuperSecretPassword!");
        assertTrue(login.getLoginMessage().contains("Your username is invalid!"));
    }

    @Test
    public void verifyFailedLoginWithInvalidPassword() {
        HomePage homepage = new HomePage(driver);
        LoginPage login = homepage.clickAuthenticationLink();
        login.login("tomsmith", "fewfew!");
        assertTrue(login.getLoginMessage().contains("Your password is invalid!"));
    }

}
