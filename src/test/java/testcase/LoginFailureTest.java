package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.LoginPage;

public class LoginFailureTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "123";

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.loginPage = new LoginPage(driver);

    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void loginSuccessfully() {
        loginPage.fillUsername(USERNAME);
        loginPage.fillPassword(PASSWORD);
        loginPage.clickOnLogin();
        Assert.assertTrue(loginPage.isLoginFail());
    }

}
