package com.automation.tests;

import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseTest{

    @Test
    public void test(){
        floatingMenuPage.clickOnLink();
        floatingMenuPage.verifyFloatingMenu();
    }
}
