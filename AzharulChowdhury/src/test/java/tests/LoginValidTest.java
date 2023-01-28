package tests;

import Utility.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginValidTest {

    private LoginPage login;


    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        login = new LoginPage(Driver.getDriver());
        Driver.getDriver().navigate().to("http://localhost:7080/login");
    }


    @Test
    public void success() {
        login.login("tomsmith", "SuperSecretPassword!", true);
        Assert.assertEquals( login.getLoginStatus(), "You logged into a secure area!×");
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }

}
