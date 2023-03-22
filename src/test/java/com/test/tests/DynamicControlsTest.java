package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.test.pages.DynamicControlsPage;

public class DynamicControlsTest extends TestBase {
	@Test
    public void testRemoveAdd() {
        DynamicControlsPage page = new DynamicControlsPage(driver);

        // Click on Remove Button and wait for the checkbox to disappear
        page.clickRemoveButton();
        assertFalse(page.isCheckboxDisplayed());

        // Click on Add Button and wait for the checkbox to appear
        page.clickAddButton();
        assertTrue(page.isCheckboxDisplayed());

        // Click on Enable Button and wait for the input field to be enabled
        page.clickToggleButton();
        assertTrue(page.isInputFieldEnabled());

        // Click on Disable Button and wait for the input field to be disabled
        page.clickToggleButton();
        assertFalse(page.isInputFieldEnabled());
    }
}