package com.tests;

import com.assignments.pages.HomePage;
import com.assignments.pages.JSAlertPage;
import com.assignments.pages.JSErrorPage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.JAVASCRIPT_ERROR;
import static org.testng.Assert.assertTrue;

public final class JSErrorTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private JSErrorTest() {

    }

    @Test(description = "Validate JavaScript Error on page",
            testName = "JavaScript Error Validation")
    public void validateJavaScriptError() {
        new HomePage().clickOnLink(JAVASCRIPT_ERROR);
        assertTrue(new JSErrorPage().getErrorText().contains("Cannot read properties of undefined (reading 'xyz')"));
    }
}
