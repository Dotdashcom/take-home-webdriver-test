package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DynamicContent extends TestBase {

    @Test(testName = "validate dynamic elements")
    public void validateDynamicElements() {
        CommonMethods.navigateTo("dynamic_loading/2");
        CommonMethods.click(dynamicContentPage.startButton);
        CommonMethods.waitForElementToDisappear(dynamicContentPage.loading);
        Assert.assertEquals(CommonMethods.getText(dynamicContentPage.helloWorld), "Hello World!");
    }

    @Test(testName = "Validate content changes dynamically")
    public void validateContentChangesDynamically() {
        CommonMethods.navigateTo("dynamic_content");
        ArrayList<String> initialContent = new ArrayList<>();
        ArrayList<String> afterClickContent = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            initialContent.add(CommonMethods.getText(dynamicContentPage.locator(i)));
        }
        CommonMethods.click(dynamicContentPage.clickHere);
        for (int i = 1; i < 4; i++) {
            afterClickContent.add(CommonMethods.getText(dynamicContentPage.locator(i)));
        }

        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (!initialContent.get(i).equals(afterClickContent.get(i))) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
        CommonMethods.threadWait(5000);
    }
}