package tests.dynamic;

import org.junit.jupiter.api.*;
import pages.DynamicLoadingPage;
import tests.BaseTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DynamicLoadingTest extends BaseTest {
    private static final String DYNAMIC_LOADING_URI = "/dynamic_loading/2";
    private static final String PAGE_TITLE = "Dynamically Loaded Page Elements";
    private static final String EXPECTED_MESSAGE = "Hello World!";

    private static DynamicLoadingPage dynamicLoadingPage;

    @BeforeAll
    static void before() {
        dynamicLoadingPage = new DynamicLoadingPage(webDriver);
        webDriver.get(baseUrl + DYNAMIC_LOADING_URI);
    }

    @Test
    @Order(1)
    void validateDynamicLoadingPage() {
        dynamicLoadingPage.assertElementsAreDisplayed();
        dynamicLoadingPage.assertPageTitle(PAGE_TITLE);
    }

    @Test
    @Order(2)
    void validateDynamicLoading() {
        dynamicLoadingPage.assertDynamicLoadingBehavior(EXPECTED_MESSAGE);
    }
}
