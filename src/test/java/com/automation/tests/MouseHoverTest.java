package com.automation.tests;

import org.testng.annotations.Test;

public class MouseHoverTest extends BaseTest {

    @Test
    public void test() {
        mouseHoverPage.clickOnLink();
        mouseHoverPage.hoverMouse();
    }
}
