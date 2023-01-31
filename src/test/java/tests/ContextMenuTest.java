package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import pages.ContextMenuPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContextMenuTest extends BaseTest {
    private static final String CONTEXT_MENU_URI = "/context_menu";
    private static final String PAGE_TITLE = "Context Menu";
    private static final String ALERT_MESSAGE = "You selected a context menu";

    private static ContextMenuPage contextMenuPage;

    @BeforeAll
    static void before() {
        contextMenuPage = new ContextMenuPage(webDriver);
        webDriver.get(baseUrl + CONTEXT_MENU_URI);
    }

    @Test
    @Order(1)
    void validateContextMenuPage() {
        contextMenuPage.assertElementsAreDisplayed();
        contextMenuPage.assertPageTitle(PAGE_TITLE);
    }

    @Test
    @Order(2)
    void triggerContextMenuAndValidateAlert() {
        rightClick(contextMenuPage.getHotSpotBox());
        Alert alert = getAlert();
        Assertions.assertEquals(ALERT_MESSAGE, alert.getText());
        alert.dismiss();
    }

    @Test
    @Order(3)
    void validateAlertIsNotPresentWhenLeftClickPerformed() {
        contextMenuPage.getHotSpotBox().click();
        Assertions.assertThrows(NoAlertPresentException.class, this::getAlert);
    }
}
