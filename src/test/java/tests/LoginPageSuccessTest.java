package tests;

import model.LoginPage;
import model.SecureAreaPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import runner.BaseTest;

public class LoginPageSuccessTest extends BaseTest {

    @Test
    public void testIsUserLoggedIn() {
        String expectedUrlEndpoint = "secure";
        String expectedHeader = "Secure Area";

         SecureAreaPage successfulLogin = new LoginPage(getDriver())
                .getLoginPage()
                .inputCorrectUsername()
                .inputCorrectPassword()
                .clickLoginButton();

        String actualUrlEndpoint = successfulLogin.getCurrentUrl();
        String actualHeader = successfulLogin.getSecureAreaHeader();
        Assert.assertTrue(actualUrlEndpoint.endsWith(expectedUrlEndpoint));
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void testLoginSuccessNotification() {
        boolean isSuccessNotificationDisplayed = new LoginPage(getDriver())
                .getLoginPage()
                .inputCorrectUsername()
                .inputCorrectPassword()
                .clickLoginButton()
                .isNotificationSuccessLoginDisplayed();

        Assert.assertTrue(isSuccessNotificationDisplayed);
    }

    @Test
    public void testLogoutButton() {
        boolean isLogoutButtonDisplayed = new LoginPage(getDriver())
                .getLoginPage()
                .inputCorrectUsername()
                .inputCorrectPassword()
                .clickLoginButton()
                .isLogoutButtonDisplayed();

        Assert.assertTrue(isLogoutButtonDisplayed);
    }
}