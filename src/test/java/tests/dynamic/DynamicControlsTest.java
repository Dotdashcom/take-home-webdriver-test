package tests.dynamic;

import org.junit.jupiter.api.*;
import pages.DynamicControlsPage;
import tests.BaseTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DynamicControlsTest extends BaseTest {
    private static final String DYNAMIC_CONTROLS_URI = "/dynamic_controls";
    private static final String PAGE_TITLE = "Dynamic Controls";

    private static DynamicControlsPage dynamicControlsPage;

    @BeforeAll
    static void before() {
        dynamicControlsPage = new DynamicControlsPage(webDriver);
        webDriver.get(baseUrl + DYNAMIC_CONTROLS_URI);
    }

    @Test
    @Order(1)
    void validateDynamicControlsPage() {
        dynamicControlsPage.assertElementsAreDisplayed();
        dynamicControlsPage.assertPageTitle(PAGE_TITLE);
    }

    @Test
    @Order(2)
    void validateCheckBoxSwap() {
        dynamicControlsPage.assertCheckBoxRemoval(); // Remove checkbox
        dynamicControlsPage.assertCheckBoxAppearance(); // Add checkbox
    }

    @Test
    @Order(3)
    void validateInputDisableAndEnable() {
        dynamicControlsPage.assertInputEnable();
        dynamicControlsPage.assertInputDisable();
    }


}
