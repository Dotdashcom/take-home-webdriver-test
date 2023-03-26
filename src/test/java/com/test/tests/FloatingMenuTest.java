package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.test.pages.FloatingMenuPage;

public class FloatingMenuTest extends TestBase {

    private FloatingMenuPage floatingMenuPage;

    @Test
    public void testFloatingMenu() {
        floatingMenuPage = new FloatingMenuPage(driver);
        float initialYOffset = floatingMenuPage.getFloatingMenuYOffset();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
        float newOffset = floatingMenuPage.getFloatingMenuYOffset();
        assertTrue(initialYOffset < newOffset);
        driver.quit();
    }
}
