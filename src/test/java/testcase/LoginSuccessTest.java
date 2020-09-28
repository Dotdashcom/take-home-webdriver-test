package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.LoginPage;

public class LoginSuccessTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

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
