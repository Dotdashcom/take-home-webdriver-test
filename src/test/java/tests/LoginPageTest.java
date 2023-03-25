package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "loginUrl", "username", "password", "secureUrl", "homePageMessage"})
    public void login_Success_Test(String baseUrl, String loginUrl, String username, String password, String secureUrl, String homePageMessage) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.goToUrl(baseUrl , loginUrl);

        loginPage.login(username, password);
        Assert.assertEquals(homePage.getUrl(), secureUrl);
        Assert.assertTrue(homePage.getHomePageMessage().contains(homePageMessage));
    }

    @Test
    @Parameters({"baseUrl", "loginUrl", "invalidUsername", "password", "invalidUsernameMessage", "username", "invalidPassword", "invalidPasswordMessage"})
    public void login_Failure_Test(String baseUrl, String loginUrl, String invalidUsername, String password, String invalidUsernameMessage, String username, String invalidPassword, String invalidPasswordMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToUrl(baseUrl , loginUrl);

        //test invalid username
        loginPage.login(invalidUsername, password);
        Assert.assertTrue(loginPage.getLoginMessage().contains(invalidUsernameMessage));

        //test invalid password
        loginPage.login(username, invalidPassword);
        Assert.assertTrue(loginPage.getLoginMessage().contains(invalidPasswordMessage));

    }
}
