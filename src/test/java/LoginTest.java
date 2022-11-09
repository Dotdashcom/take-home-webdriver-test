import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void UserLoginTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        LoginPage loginPage = new LoginPage();
        boolean login = loginPage.navigatetoLoginpage().loginHeader();
        Assert.assertTrue(login, "login page is not navigated");
        boolean logged = loginPage.LoginApplication().secureHeader();
        Assert.assertTrue(logged, "login is not successful");
        boolean logout = loginPage.LogoutApplication().loginHeader();
        Assert.assertTrue(logout, "logout is not successful");

    }

    @Test
    public void UserLoginFailedTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        LoginPage loginPage = new LoginPage();
        boolean login = loginPage.navigatetoLoginpage().loginHeader();
        Assert.assertTrue(login, "login page is not navigated");
        boolean loginerror = loginPage.InvalidLoginApplication().invalidpassword();
        Assert.assertTrue(loginerror, "login is successful");

    }

}
