package com.automation.tests;

import org.testng.annotations.Test;

public class OpenNewTabTest extends BaseTest{

    @Test
    public void test(){
        openNewTabPage.clickOnLink();
        openNewTabPage.openNewTab();
    }
}
