package com.tests;

import com.assignments.pages.DropdownPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.DROPDOWN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public final class DropdownTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private DropdownTest() {

    }

    @Test(description = "Validate Different Options Selection in Drop Down",
            testName = "Drop Down Option Validation")
    public void validateDropDownMenu() {
        new HomePage().clickOnLink(DROPDOWN);
        assertTrue(new DropdownPage().clickOnDropdown("Option 1").getSelectedOption("Option 1"));
        assertTrue(new DropdownPage().clickOnDropdown("Option 2").getSelectedOption("Option 2"));
    }
}
