package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LogingPage;
import testComponents.BaseTest;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @Test
    public void  loginSucces() throws IOException {
        LogingPage loginPage=new LogingPage(driver);
        loginPage.goTo();
        loginPage.signin( "tomsmith","SuperSecretPassword!");
        String actualtext=loginPage.getText();
        Assert.assertEquals( actualtext,"You logged into a secure area!\n" + "×");
    }
    @Test
    public void loginFailur() throws IOException {
        LogingPage loginPage = new LogingPage(driver);
        loginPage.goTo();
        loginPage.signin("tomsm", "SuperSecretPass");
        String actualtext = loginPage.getText();
        System.out.println(actualtext);
        Assert.assertEquals(actualtext,"Your username is invalid!\n" + "×");
    }
}
