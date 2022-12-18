package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.LoginPage;
import theinternet.pages.Navigation;


public class LoginPageTests extends BaseTest{
    private LoginPage loginPage;
    private Navigation navigation;

    @BeforeClass
    private void initialize(){
        loginPage = new LoginPage();
        navigation = new Navigation();
    }
    @Test(priority = 0)
    public void navigateToLoginPage(){
        Assert.assertTrue(navigation.navigateToLoginPage());
    }
    @Test(priority = 1)
    public void testLoginPageElementsLoaded(){
        Assert.assertTrue(loginPage.validatePageLanding());
    }

    @Test(priority = 2)
    public void testLoginSuccess(){
        Assert.assertTrue(loginPage.login());
    }

    @Test(priority = 3)
    public void testLogOutSuccess(){
        Assert.assertTrue(loginPage.logout());
    }

    @Test(priority = 4)
    public void testLoginFailed(){
        Assert.assertTrue(loginPage.loginFailed());
    }

}
