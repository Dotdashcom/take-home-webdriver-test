package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BasePageTest {

    protected LoginPage loginPage;

    @BeforeMethod
    public void loginSetUp() {
        goToPage("login");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(priority = 1)
    public void validCredentialsTest() {
        loginPage.loginSucess(correctUserName, correctPassword);
        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
    }

    @Test(priority = 2)
    public void invalidCredentialsTest() {
        Assert.assertTrue(loginPage.loginWithInvalidUsername(incorrectUserName, correctPassword));
        Assert.assertTrue(loginPage.loginWithInvalidPassword(correctUserName, incorrectPassword));
    }
}
