package com.test.tests;

import org.junit.jupiter.api.Test;
import com.test.pages.OpenInNewTabPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenInNewTabTest extends TestBase {

    @Test
    public void testOpenInNewTab() {
        OpenInNewTabPage openInNewTabPage = new OpenInNewTabPage(driver);
        assertTrue(openInNewTabPage.isPageLoaded());
        openInNewTabPage.clickHereLink();
        assertTrue(openInNewTabPage.isNewTabOpened());
        assertTrue(openInNewTabPage.getNewTabText().contains("New Window"));
    }
}
