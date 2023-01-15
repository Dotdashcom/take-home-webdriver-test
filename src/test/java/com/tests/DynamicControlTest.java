package com.tests;

import com.assignments.pages.DynamicControlPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.DYNAMIC_CONTROL;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public final class DynamicControlTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private DynamicControlTest() {

    }

    @Test(description = "Validate Dynamic Content on the page after specific action",
            testName = "Dynamic Control Validation")
    public void validateDragAndDrop() {
        new HomePage().clickOnLink(DYNAMIC_CONTROL);
        DynamicControlPage dynamicControlPage = new DynamicControlPage();
        assertFalse(dynamicControlPage.clickOnRemove().isCheckBoxDisplayed());
        assertTrue(dynamicControlPage.clickOnAdd().isCheckBoxDisplayed());
        assertTrue(dynamicControlPage.clickOnEnableButton().isEnabledMessageDisplayed());
        assertTrue(dynamicControlPage.isTextBoxEnabled());
        assertTrue(dynamicControlPage.clickOnDisabledButton().isDisabledMessageDisplayed());
        assertFalse(dynamicControlPage.isTextBoxEnabled());
    }
}
