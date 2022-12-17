package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import Utils.Config.ConfigurationReader;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageSuccess extends BasePage {
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/login");
    }

    @Test
    public void TC1LoginWithCorrectCredentials() throws IOException {
        loginPage.LoginWithCorrectCredentials(ConfigurationReader.getProperties("validUserName"),
                ConfigurationReader.getProperties("validPassword"));
        HelpfulMethods.staticWait(2);
        Assert.assertEquals(loginPage.successMessage(), "You logged into a secure area!\n" +
                "×");
        loginPage.logOut();
        HelpfulMethods.takeScreenShot("LoginVerification");


    }


}