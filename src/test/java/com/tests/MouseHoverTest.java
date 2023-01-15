package com.tests;

import com.assignments.pages.HomePage;
import com.assignments.pages.MouseHoverPage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.MOUSE_HOVER;
import static org.testng.Assert.assertTrue;

public final class MouseHoverTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private MouseHoverTest() {

    }

    @Test(description = "Validate on hovering each image additional details are displayed",
            testName = "Mouse Hover Validation")
    public void validateMouseHover() {
        new HomePage().clickOnLink(MOUSE_HOVER);
        assertTrue(new MouseHoverPage().validateMouseHover());
    }
}
