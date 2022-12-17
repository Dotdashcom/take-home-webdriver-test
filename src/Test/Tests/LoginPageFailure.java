package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageFailure extends BasePage {
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/login");
    }
    @Test
    public void TC1LoginWithInvalidCredentials() {
        loginPage.LoginWithInvalidCredentials("test","invalid");
        HelpfulMethods.staticWait(2);
        Assert.assertEquals(loginPage.getErrorMessage(), "Your username is invalid!\n" +
                "×");
    }

}
