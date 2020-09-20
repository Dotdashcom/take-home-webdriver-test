package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigurationReader;
import utils.Driver;
import utils.TestBase;

import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase {
    LoginPage loginPage=new LoginPage();
    String url="/login";
    @BeforeTest
    public void setUrl(){
        Driver.setUp(url);
    }

    @Test
    public void loginSuccess(){
        loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("userName"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("passWord"));
        loginPage.loginButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("secure"));
        }

    @Test
    public void loginFailure(){
        loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("passWord"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("userName"));
        loginPage.loginButton.click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='flash error']")).isDisplayed());
    }


}
