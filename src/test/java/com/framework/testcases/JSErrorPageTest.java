package com.framework.testcases;

import com.framework.pages.JSErrorPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class JSErrorPageTest extends TestBase {
    JSErrorPage jsErrorPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the js error page")
    public void user_is_on_context_menu_page() {
        jsErrorPage = new JSErrorPage(driver);
        jsErrorPage.navigate();
        String actualURL = jsErrorPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/javascript_error";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "js error is displayed")
    public void js_error_is_displayed_in_browser_console() {
        jsErrorPage = new JSErrorPage(driver);
        jsErrorPage.navigate();
        List<String> foundErrorsList = jsErrorPage.findErrors();
        String expectedError = "Cannot read properties of undefined (reading 'xyz')";
        Boolean isErrorFound = foundErrorsList.contains(expectedError);
        Assert.assertTrue(isErrorFound);
    }


}
