package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes extends TestBase {
    @Test(testName = "check and uncheck checkboxes")
    public void checkAndUncheckBoxes() {
        CommonMethods.navigateTo("checkboxes");

        CommonMethods.click(checkBoxesPage.checkBoxLocator("checkbox 1"));
        Assert.assertTrue(CommonMethods.isSelected(checkBoxesPage.checkBoxLocator("checkbox 1")));

        CommonMethods.click(checkBoxesPage.checkBoxLocator("checkbox 1"));
        Assert.assertTrue(!CommonMethods.isSelected(checkBoxesPage.checkBoxLocator("checkbox 1")));

        CommonMethods.click(checkBoxesPage.checkBoxLocator("checkbox 2"));
        Assert.assertTrue(!CommonMethods.isSelected(checkBoxesPage.checkBoxLocator("checkbox 2")));

        CommonMethods.click(checkBoxesPage.checkBoxLocator("checkbox 2"));
        Assert.assertTrue(CommonMethods.isSelected(checkBoxesPage.checkBoxLocator("checkbox 2")));
    }
}