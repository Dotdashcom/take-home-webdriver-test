package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JS extends TestBase {
    @Test(testName = "validate JS Alert")
    public void validateJsAlert() {
        CommonMethods.navigateTo("javascript_alerts");
        CommonMethods.click(jsPage.button("Click for JS Alert"));
        Assert.assertEquals(CommonMethods.switchToAlert().getText(), "I am a JS Alert");
        CommonMethods.switchTo().alert().accept();
    }

    @Test(testName = "validate JS Confirm")
    public void validateJsConfirm() {
        CommonMethods.navigateTo("javascript_alerts");
        CommonMethods.click(jsPage.button("Click for JS Confirm"));
        Assert.assertEquals(CommonMethods.switchToAlert().getText(), "I am a JS Confirm");
        CommonMethods.switchTo().alert().accept();
    }

    @Test(testName = "validate JS Prompt")
    public void validateJsPrompt() {
        CommonMethods.navigateTo("javascript_alerts");
        CommonMethods.click(jsPage.button("Click for JS Prompt"));
        Assert.assertEquals(CommonMethods.switchToAlert().getText(), "I am a JS prompt");
        CommonMethods.switchTo().alert().accept();
    }

    @Test(testName = "validate JS Error")
    public void validateJsError() {
        CommonMethods.navigateTo("javascript_error");
        Assert.assertEquals(CommonMethods.getText(jsPage.js).trim(), "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
    }
}