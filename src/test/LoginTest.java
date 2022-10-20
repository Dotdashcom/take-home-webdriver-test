package src.test;

import org.testng.annotations.*;
import src.main.pages.LoginPage;
import src.main.utilities.Browser;
import src.main.utilities.CommonMethods;

import static org.testng.AssertJUnit.assertTrue;


public class LoginTest extends  BaseTest{

    private LoginPage loginPage;

    @Test
    public void loginSuccessTest() {
        loginPage = Browser.open(baseURL + "login", LoginPage.class);
        String username = CommonMethods.getUserDetails("username");
        String password = CommonMethods.getUserDetails("correctPassword");
        assertTrue(loginPage.successLogin(username, password).contains("You logged into a secure area!"));
    }

    @Test
    public void loginFailTest() {
        loginPage = Browser.open(baseURL + "login", LoginPage.class);
        String username = CommonMethods.getUserDetails("username");
        String wrongPassword = CommonMethods.getUserDetails("wrongPassword");
        assertTrue(loginPage.failLogin(username, wrongPassword).contains("Your password is invalid!"));
    }


}
