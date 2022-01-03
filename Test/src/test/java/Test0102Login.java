import pageObject.LoginPage;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Test0102Login extends TestBase{
    LoginPage loginPage;

    @Test
    public void test01LoginSuccess() throws InterruptedException{

        loginPage = new LoginPage(webDriver);
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginSuccess());
    }

    @Test
    public void test02LoginFailure() throws InterruptedException{

        loginPage = new LoginPage(webDriver);
        loginPage.setUsername("wrongUsername");
        loginPage.setPassword("wrongPassword");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginFailure());
    }

}
