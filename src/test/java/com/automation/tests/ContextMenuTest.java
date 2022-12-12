package com.automation.tests;

import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void test() {
        contextMenuPage.clickOnContextLink();
        contextMenuPage.rightClick();
    }
}
