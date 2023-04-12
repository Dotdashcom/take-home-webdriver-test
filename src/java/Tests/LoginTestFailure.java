package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import utilities.DriverUtilities;

public class LoginTestFailure extends DriverUtilities {
    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/login");
    }
    @Test
    public void LoginTestFailure() {
        LoginPage loginPage = new LoginPage();

        loginPage.verifyLoginPage();
        loginPage.enterInvalidUsername();
        loginPage.enterInvalidPassword();
        loginPage.clickLoginBtn();
        loginPage.verifyUserIsNotLogged();
    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}
