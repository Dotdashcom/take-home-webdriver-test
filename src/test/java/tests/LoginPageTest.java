package tests;

import utils.ConfigReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BasePageTest {
    protected LoginPage loginPage;

    @BeforeMethod
    public void loginSetUp(){
        goToPage("login");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(priority = 0)
    public void validCredentialsTest(){
        loginPage.loginSucess(ConfigReader.getApplicationProperty("username"), ConfigReader.getApplicationProperty("password"));
        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
    }

    @Test(priority = 1)
    public void invalidCredentialsTest(){
        Assert.assertTrue(loginPage.loginWithInvalidUsername("Sean", ConfigReader.getApplicationProperty("password")));
        Assert.assertTrue(loginPage.loginWithInvalidPassword(ConfigReader.getApplicationProperty("username"), "123123Aa@ "));
    }
}
