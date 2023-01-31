package tests.login;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NegativeLoginTest extends BaseLoginTest {
    private static final String ERROR_MESSAGE = "Your username is invalid!";

    @Test
    @Order(1)
    void verifyLoginBehaviorWithInvalidCredentials() {
        loginPage.authorize(invalidUserName, invalidPassword);
        loginPage.assertErrorMessage(ERROR_MESSAGE);
        loginPage.assertInputsAreCleared();
    }
}
