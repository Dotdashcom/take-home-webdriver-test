package tests.dynamic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.DynamicContentPage;
import tests.BaseTest;

import java.util.List;

public class DynamicContentTest extends BaseTest {
    private static final String DYNAMIC_CONTENT_URI = "/dynamic_content";
    private static final String PAGE_TITLE = "Dynamic Content";
    private static final int EXPECTED_ROWS_COUNT = 3;

    private static DynamicContentPage dynamicContentPage;

    @BeforeAll
    static void before() {
        dynamicContentPage = new DynamicContentPage(webDriver);
        webDriver.get(baseUrl + DYNAMIC_CONTENT_URI);
    }

    @Test
    @Order(1)
    void validateDynamicContentPage() {
        dynamicContentPage.assertElementsAreDisplayed();
        dynamicContentPage.assertPageTitle(PAGE_TITLE);
        dynamicContentPage.assertContentCount(EXPECTED_ROWS_COUNT);
    }

    @Test
    @Order(2)
    void verifyContentRefresh() {
        List<String> oldImagesRefs = dynamicContentPage.getImageRefs();
        List<String> descriptions = dynamicContentPage.getDescriptions();
        refreshPage();
        dynamicContentPage.assertImageRefs(oldImagesRefs);
        dynamicContentPage.assertDescriptions(descriptions);
    }
}
