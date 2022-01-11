package com.example.demo;

import pages.DynamicControlsPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T08DynamicControls extends TestMain{
    DynamicControlsPage dynamicControlsPage;

    @Test
    public void testDynamicControls(){
        dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.clickRemoveButton();
        Assert.assertFalse(dynamicControlsPage.isCheckBoxPresent());
        dynamicControlsPage.clickAddButton();
        Assert.assertTrue(dynamicControlsPage.isCheckBoxPresent());
        dynamicControlsPage.clickEnableButton();
        Assert.assertTrue(dynamicControlsPage.isTextBoxEnabled());
        dynamicControlsPage.clickDisableButton();
        Assert.assertFalse(dynamicControlsPage.isTextBoxEnabled());
    }
}
