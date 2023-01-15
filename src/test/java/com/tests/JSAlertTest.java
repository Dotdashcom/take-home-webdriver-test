package com.tests;

import com.assignments.pages.HomePage;
import com.assignments.pages.JSAlertPage;
import com.assignments.pages.MouseHoverPage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.JAVASCRIPT_ALERTS;
import static org.testng.Assert.assertTrue;

public final class JSAlertTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private JSAlertTest() {

    }

    @Test(description = "Validate test can accept JS Alert and enter text in JS Alert prompt",
            testName = "JavaScript Alert Validation")
    public void validateJavaScriptAlert() {
        new HomePage().clickOnLink(JAVASCRIPT_ALERTS);
        assertTrue(new JSAlertPage().validateJSAlertResult().contains("You successfuly clicked an alert"));
        assertTrue(new JSAlertPage().validateJSConfirmResult().contains("You clicked: Ok"));
        assertTrue(new JSAlertPage().validateJSPromptResult("random").contains("random"));
    }
}
