package homework.tests;

import homework.pages.LoginPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.asynchttpclient.util.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginSteps extends TestBase {

    LoginPage loginPage = new LoginPage();



    @Test
    public void testLoginWithValidCredentials() {

        Driver.getDriver().get("http://localhost:7080/login");


        loginPage.userName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");

        loginPage.singInButton.click();


        Assert.assertTrue(loginPage.singInMessage.isDisplayed());


    }
}
