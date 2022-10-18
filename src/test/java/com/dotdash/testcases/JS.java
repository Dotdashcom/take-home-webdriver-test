package com.dotdash.testcases;

import com.dotdash.pageObject.JSPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class JS extends Setup {
    JSPage jsPage;

    public JS() {
        this.jsPage = MyTestClasses.getObject(JSPage.class);
    }

    @Test(testName = "validate JS Alert")
    public void validateJsAlert() {
        navigateTo("javascript_alerts");
        jsPage.clickJsButton("Click for JS Alert");
        jsPage.assertJsAlert("I am a JS Alert");
    }

    @Test(testName = "validate JS Confirm")
    public void validateJsConfirm() {
        navigateTo("javascript_alerts");
        jsPage.clickJsButton("Click for JS Confirm");
        jsPage.assertJsAlert("I am a JS Confirm");
    }

    @Test(testName = "validate JS Prompt")
    public void validateJsPrompt() {
        navigateTo("javascript_alerts");
        jsPage.clickJsButton("Click for JS Prompt");
        jsPage.assertJsAlert("I am a JS prompt");
    }

    @Test(testName = "validate JS Error")
    public void validateJsError() {
        navigateTo("javascript_error");
        jsPage.assertJsError("This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
    }
}
