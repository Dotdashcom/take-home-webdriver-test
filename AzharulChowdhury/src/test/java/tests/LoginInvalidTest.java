package tests;

import Utility.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginInvalidTest {

    private LoginPage login;


    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        login = new LoginPage(Driver.getDriver());
        Driver.getDriver().navigate().to("http://localhost:7080/login");
    }


    @Test
    public void failed() {
        login.login("failed", "failed", true);
        Assert.assertEquals(login.getLoginStatus(), "Your username is invalid!×");
        login.login("tomsmith", "failed", true);
        Assert.assertEquals(login.getLoginStatus(), "Your password is invalid!×");
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
