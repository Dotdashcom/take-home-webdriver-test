package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.rmi.log.LogInputStream;
import webdrivertestpages.LoginSuccess;

public class LoginSuccessTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/login");
    }

    @Test
    public void loginSuccess(){
        LoginSuccess ls = new LoginSuccess(driver);
        ls.loginTest("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(ls.getLoginText(), "You logged into a secure area!\n" +
                "×");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
