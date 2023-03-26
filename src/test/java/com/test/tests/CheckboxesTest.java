package com.test.tests;

import org.junit.jupiter.api.Test;

import com.test.pages.CheckboxesPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxesTest  extends TestBase {

    @Test
    public void testCheckboxes() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.clickCheckbox1();
        assertTrue(checkboxesPage.isCheckbox1Checked());

        checkboxesPage.clickCheckbox2();
        assertFalse(checkboxesPage.isCheckbox2Checked());

        checkboxesPage.clickCheckbox1();
        assertFalse(checkboxesPage.isCheckbox1Checked());

        checkboxesPage.clickCheckbox2();
        assertTrue(checkboxesPage.isCheckbox2Checked());
    }

}
