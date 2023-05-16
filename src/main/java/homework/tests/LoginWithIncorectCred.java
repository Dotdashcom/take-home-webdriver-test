package homework.tests;

import homework.pages.LoginPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithIncorectCred extends TestBase {

    LoginPage loginPage=new LoginPage();

    @Test
    public void testLoginWithInvalidCred() {

        Driver.getDriver().get("http://localhost:7080/login");
        loginPage.userName.sendKeys("JustWithValidUserName");
        loginPage.password.sendKeys("JustWithValidPassword");

        loginPage.singInButton.click();

        Assert.assertTrue(loginPage.failureMessage.isDisplayed());

    }
}
