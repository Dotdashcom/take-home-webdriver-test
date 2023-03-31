package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest extends TestBase {
    @Test
    public void testSuccess() {
        driver.get("http://localhost:7080/login ");
        Login success = new Login(driver);
        success.enterDetails("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals("You logged into a secure area!\n" +
                "×", success.message());


    }

}
