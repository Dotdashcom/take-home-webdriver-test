package e2e.tests;

import e2e.pages.LoginPage;
import org.junit.jupiter.api.*;

public class LoginTest extends BaseSpec {
    LoginPage loginPage;
    public final String validUsername = configReader.getValidUsername();
    public final String validPassword = configReader.getValidPassword();
    public final String loginSuccessMessage = configReader.getLoginSuccessMessage();
    public final String loginInvalidMessage = configReader.getLoginInvalidMessage();
    public final String loginEndpoint = configReader.getLoginEndpoint();

    @BeforeEach
    public void open(){
        loginPage = new LoginPage(driver);
        loginPage.visit(loginEndpoint);
    }

    @Test
    public void validateLoginSuccess(){
        loginPage.login(validUsername, validPassword);
        Assertions.assertTrue(loginPage.isLoginSuccessful());
        Assertions.assertTrue(loginPage.getFlashMessage().contains(loginSuccessMessage));
        // Check for false positives
        Assertions.assertFalse(loginPage.isLoginFailed());
        // We could also validate if cookies are setup and valid
    }

    @Test
    public void validateLoginInvalidCredentials(){
        loginPage.login("invalidUser", "wrongPassword");
        Assertions.assertTrue(loginPage.isLoginFailed());
        Assertions.assertTrue(loginPage.getFlashMessage().contains(loginInvalidMessage));
        // Check for false positives
        Assertions.assertFalse(loginPage.isLoginSuccessful());

    }

}
