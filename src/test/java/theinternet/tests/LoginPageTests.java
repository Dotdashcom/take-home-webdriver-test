package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.LoginPage;


public class LoginPageTests extends BaseTest{

    LoginPage loginPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToLoginPage();
        loginPage = new LoginPage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testLoginPageLanding(){
        Assert.assertTrue(loginPage.validatePageLanding(), "Login page not loaded");
    }

    @Test(priority = 1)
    public void testLoginSuccess(){
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getBannerText().contains("You logged into a secure area!"), "Login failed");
    }

    @Test(priority = 2)
    public void testLogOutSuccess(){
        loginPage.logout();
        Assert.assertTrue(loginPage.getBannerText().contains("You logged out of the secure area!"), "Logout failed");

    }

    @Test(priority = 3)
    public void testLoginWrongUsername(){
        String username = "user";
        String password = properties.getProperty("password");
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getBannerText().contains("Your username is invalid!"), "Wrong username error failed");
    }

    @Test(priority = 4)
    public void testLoginWrongPassword(){
        String username = properties.getProperty("username");
        String password = "pass";
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getBannerText().contains("Your password is invalid!"), "Wrong username error failed");
    }

}
