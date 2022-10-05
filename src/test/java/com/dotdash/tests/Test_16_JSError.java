package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.JSErrorPage;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_16_JSError extends TestBase {
    @Test
    public void js_error_test() throws Exception {
        JSErrorPage jsErrorPage = new JSErrorPage();
        jsErrorPage.navigatePages("JavaScript onload event error");

        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("p")));
        Assertions.assertTrue(jsErrorPage.jsErrorMsg.isDisplayed());
        Assertions.assertFalse(jsErrorPage.jsErrorMsg.getText().isBlank());
        Assertions.assertFalse(jsErrorPage.jsErrorMsg.getText().isEmpty());
        Assertions.assertEquals(jsErrorPage.jsErrorMsg.getText(), "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
    }

}


