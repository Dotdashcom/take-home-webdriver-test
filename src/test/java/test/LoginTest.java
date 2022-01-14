package test;

import methods.LoginPageMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

// contains two tests, is-login-success test and is-login-fail test.
// loginPageSuccessTest should be true whereas loginPageFailedTest should be false.
public class LoginTest extends LoginPageMethod {

    @Test
    public void loginPageSuccessTest() {
        final String username = "tomsmith";
        final String password = "SuperSecretPassword!";
        startLoginTest(username, password);
        assertTrue(isLoginSuccess(), "Login failed, please check your credentials and try again!");
    };

    @Test
    public void loginPageFailedTest() {
        final String username = "testname";
        final String password = "SuperSecretPassword";
        startLoginTest(username, password);
        assertFalse(isLoginSuccess());
    };
}
