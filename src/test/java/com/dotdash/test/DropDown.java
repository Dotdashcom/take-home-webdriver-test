package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown extends TestBase {
    @Test(testName ="Click And Select ta value from dropdown")
    public void clickAndSelectFromDropdown(){
        CommonMethods.navigateTo("dropdown");
        CommonMethods.click(dropDownPage.dropDown);
        CommonMethods.dropDown(dropDownPage.dropDown).selectByVisibleText("Option 2");
        Assert.assertTrue(CommonMethods.isSelected(dropDownPage.dropDownAssert));
    }
}
