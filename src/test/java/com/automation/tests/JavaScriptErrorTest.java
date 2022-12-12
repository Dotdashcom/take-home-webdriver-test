package com.automation.tests;

import org.testng.annotations.Test;

public class JavaScriptErrorTest extends BaseTest {

    @Test
    public void test() {
        javaScriptErrorPage.clickOnLink();
        javaScriptErrorPage.verifyError();
    }
}
