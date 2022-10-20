package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls extends TestBase {

    @Test(testName = "validate dynamic controls")
    public void validateDynamicControls() {
        CommonMethods.navigateTo("/dynamic_controls");

        CommonMethods.click(dynamicControlsPage.remove);
        boolean flag = false;
        try {
            CommonMethods.isDisplayed(dynamicControlsPage.checkBox);
        } catch (NoSuchElementException noSuchElementException) {
            flag = true;
        }
        Assert.assertTrue(flag);

        CommonMethods.click(dynamicControlsPage.add);

        Assert.assertTrue(CommonMethods.isDisplayed(dynamicControlsPage.checkBox));

        CommonMethods.click(dynamicControlsPage.enable);

        Assert.assertTrue(CommonMethods.isDisplayed(dynamicControlsPage.input));
        CommonMethods.click(dynamicControlsPage.disable);
        Assert.assertTrue(CommonMethods.isDisplayed(dynamicControlsPage.inputDisabled));
    }
}
