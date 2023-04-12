package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.SecurePage;
import utilities.DriverUtilities;

public class LoginTestSuccess extends DriverUtilities {

    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/login");
    }
    @Test
    public void LoginTestSuccess() {
        LoginPage loginPage = new LoginPage();
        SecurePage securePage = new SecurePage();
        loginPage.verifyLoginPage();
        loginPage.enterValidUsername();
        loginPage.enterValidPassword();
        loginPage.clickLoginBtn();
        securePage.verifyUserSuccessfullyLogged();
    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}

