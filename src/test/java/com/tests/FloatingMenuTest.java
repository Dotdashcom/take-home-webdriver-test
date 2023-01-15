package com.tests;

import com.assignments.pages.FloatingMenuPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.FLOATING_MENU;
import static org.testng.Assert.assertTrue;

public final class FloatingMenuTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private FloatingMenuTest() {

    }

    @Test(description = "Validate Floating Menu on the page while scrolling",
            testName = "Floating Menu Validation")
    public void validateFloatingMenu() {
        new HomePage().clickOnLink(FLOATING_MENU);
        assertTrue(new FloatingMenuPage().isMenuVisible());
        new FloatingMenuPage().scrollToEndOfPage();
        assertTrue(new FloatingMenuPage().isMenuVisible());
    }
}
