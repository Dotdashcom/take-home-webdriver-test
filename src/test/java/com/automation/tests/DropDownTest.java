package com.automation.tests;

import org.testng.annotations.Test;

public class DropDownTest extends BaseTest{

    @Test
    public void test(){
        dropDownPage.clickOnLink();
        dropDownPage.dropDown();
    }
}
