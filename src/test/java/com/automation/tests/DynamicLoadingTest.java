package com.automation.tests;

import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest{

    @Test
    public void test(){
        dynamicLoadingPage.clickOnLink();
        dynamicLoadingPage.waitUntilPresentText();
    }
}
