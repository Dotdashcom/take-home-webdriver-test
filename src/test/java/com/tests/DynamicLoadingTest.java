package com.tests;

import com.assignments.pages.DynamicContentPage;
import com.assignments.pages.DynamicLoadingPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.DYNAMIC_LOADING;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public final class DynamicLoadingTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private DynamicLoadingTest() {

    }

    @Test(description = "Validate test waits for Dynamic Text to load",
            testName = "Dynamic Loading Validation")
    public void validateDynamicLoading() {
        new HomePage().clickOnLink(DYNAMIC_LOADING);
        assertTrue(new DynamicLoadingPage().clickOnHiddenElements().clickOnStartButton().isHelloWorldTextVisible());
    }
}
