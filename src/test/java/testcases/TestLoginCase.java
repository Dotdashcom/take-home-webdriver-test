package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;


public class TestLoginCase {
    LoginPage loginPage = new LoginPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "login";
        Driver.getDriver().get(url);
    }

    @Test
    public void testLoginSuccess() {
        BrowserUtils.highlightElement(loginPage.userName);
        loginPage.userName.sendKeys(ConfigReader.readProperty("username"));
        BrowserUtils.highlightElement(loginPage.passWord);
        loginPage.passWord.sendKeys(ConfigReader.readProperty("password"));
        loginPage.loginBtn.click();

        String actualAlertMsg = loginPage.alertMsg.getText().replace("×", "").trim();
        Assert.assertEquals("You logged into a secure area!", actualAlertMsg);
        Assert.assertEquals("Secure Area", loginPage.title.getText().trim());
    }

    @Test
    public void testLoginFailure() {
        BrowserUtils.highlightElement(loginPage.userName);
        loginPage.userName.sendKeys("johndoe");
        BrowserUtils.highlightElement(loginPage.passWord);
        loginPage.passWord.sendKeys("abc11");
        loginPage.loginBtn.click();

        String actualAlertMsg = loginPage.alertMsg.getText().replace("×", "").trim();
        Assert.assertEquals("Your username is invalid!", actualAlertMsg);
        Assert.assertEquals("Login Page", loginPage.title.getText().trim());
    }


    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
