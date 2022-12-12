package com.automation.tests;

import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test
    public void test() {
        iframePage.clickOnLink();
        iframePage.writeIntoIframe();
    }
}
