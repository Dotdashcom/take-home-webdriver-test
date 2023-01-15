package com.tests;

import com.assignments.pages.HomePage;
import com.assignments.pages.MultipleWindowPage;
import org.testng.annotations.Test;
import static com.assignments.constants.LinkNameConstants.MULTIPLE_WINDOW;
import static org.testng.Assert.assertTrue;

public final class MultipleWindowTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private MultipleWindowTest() {

    }

    @Test(description = "Validate new window tab is opened by clicking on Click Here button",
            testName = "Multiple Window Validation")
    public void validateMultipleWindow() {
        new HomePage().clickOnLink(MULTIPLE_WINDOW);
        assertTrue(new MultipleWindowPage().clickOnClickHere().switchToWindowAndGetTitle().contains("New Window"));
    }
}
