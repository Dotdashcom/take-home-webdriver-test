package com.ddm.testcases;

import com.ddm.pageobjects.JSErrorPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSErrorTests extends BaseTestClass {

    protected JSErrorPage jsErrorPage;

    @BeforeMethod
    public void setUpMethodJSError() {
        jsErrorPage = landingPage.goTo("/javascript_error", JSErrorPage.class);
    }

    @Test
    public void JsErrorTest() {
        Assert.assertTrue(jsErrorPage.doesJSErrorsExist(), "JS Errors doesn't exist.");
    }
}
