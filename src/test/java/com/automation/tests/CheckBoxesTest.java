package com.automation.tests;

import org.testng.annotations.Test;

public class CheckBoxesTest extends BaseTest{

    @Test
    public void test(){
    checkBoxesPage.clickOnCheckBoxesLink();
    checkBoxesPage.selectAndDeselectCheckBoxes();
    }
}
