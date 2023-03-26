package com.test.tests;

import org.junit.jupiter.api.Test;
import com.test.pages.JavaScriptErrorPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaScriptErrorTest extends TestBase {

    @Test
    public void testJavaScriptError() {
        JavaScriptErrorPage jsErrorPage = new JavaScriptErrorPage(driver);
        assertTrue(jsErrorPage.isPageLoaded());
        assertTrue(jsErrorPage.isJavaScriptErrorDisplayed());
        assertTrue(jsErrorPage.getJavaScriptErrorMessage().contains("Cannot read properties of undefined"));
    }
}
