package tests.login;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecurePage;
import tests.BaseTest;
import utils.ConfigReader;

public class BaseLoginTest extends BaseTest {
    protected static final String LOGIN_URI = "/login";
    protected static final String LOGIN_PAGE_TITlE = "Login Page";
    protected static final String SECURE_PAGE_TITLE = "Secure Area";

    protected static String validUserName;
    protected static String validPassword;
    protected static String invalidUserName;
    protected static String invalidPassword;

    protected static LoginPage loginPage;
    protected static SecurePage securePage;
    
    @BeforeAll
    static void before() {
        loginPage = new LoginPage(webDriver);
        securePage = new SecurePage(webDriver);

        validUserName = ConfigReader.getProperty("validUserName");
        validPassword = ConfigReader.getProperty("validPassword");
        invalidUserName = ConfigReader.getProperty("invalidUserName");
        invalidPassword = ConfigReader.getProperty("invalidPassword");

        webDriver.get(baseUrl + LOGIN_URI);
    }

    @Test
    @Order(1)
    void validateLoginPage() {
          /*
            Test that validates elements on the login page.
            We're making sure all elements displayed correctly.
         */
        loginPage.assertPageTitle(LOGIN_PAGE_TITlE);
        loginPage.assertElementsAreDisplayed();
    }
}
