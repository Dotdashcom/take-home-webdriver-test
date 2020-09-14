package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.LoginFailure;
import webdrivertestpages.LoginSuccess;

public class LoginFailureTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/login");
    }

    @Test
    public void loginSuccess(){
        LoginFailure ls = new LoginFailure(driver);
        ls.loginFailure("tomsmith", "SuperWrongPassword!");
        Assert.assertEquals(ls.getLoginText(), "Your password is invalid!\n" +
                "×");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
