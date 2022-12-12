package com.automation.tests;

import org.testng.annotations.Test;

public class DynamicContentTest extends BaseTest{

    @Test
    public void test(){
        dynamicContentPage.clickOnLink();
        dynamicContentPage.checkContent();
    }
}
