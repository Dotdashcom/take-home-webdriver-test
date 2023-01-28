package tests.login;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositiveLoginTest extends BaseLoginTest {
    private static final String WELCOME_MESSAGE =
            "Welcome to the Secure Area. When you are done click logout below.";

    @Test
    @Order(1)
    void verifyLoginBehaviorWithValidCredentials() {
        loginPage.authorize(validUserName, validPassword);

        securePage.assertElementsAreDisplayed();
        securePage.assertPageTitle(SECURE_PAGE_TITLE);
        securePage.assertWelcomeMessage(WELCOME_MESSAGE);
    }

    @Test
    @Order(2)
    void logout() {
        securePage.logout();
        loginPage.assertElementsAreDisplayed();
    }
}
