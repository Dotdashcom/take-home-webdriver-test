package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenu extends TestBase {
    @Test(testName = "validate menu is floating")
    public void validateMenuFloats(){
        CommonMethods.navigateTo("floating_menu");
        CommonMethods.scrollToMiddleViewOfElement(floatingMenuPage.scroll);
        Assert.assertTrue(CommonMethods.isDisplayed(floatingMenuPage.floatingMenu));
    }
}