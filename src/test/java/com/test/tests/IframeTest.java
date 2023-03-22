package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.test.pages.IframePage;

public class IframeTest extends TestBase {

    private IframePage iframePage;

    @Test
    public void testIframe() {
        String expectedText = "This is some text inside the iframe!";
        iframePage = new IframePage(driver);
        driver.switchTo().frame(0); // switch to the first iframe on the page
        iframePage.typeText(expectedText);
        driver.switchTo().defaultContent(); // switch back to the main page
        assertEquals(expectedText, iframePage.getTypedText());
        driver.quit();
    }
}
