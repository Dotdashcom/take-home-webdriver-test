package com.tests;

import com.assignments.pages.FloatingMenuPage;
import com.assignments.pages.FramePage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;


import static com.assignments.constants.LinkNameConstants.IFRAMES;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public final class IFrameTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private IFrameTest() {

    }

    @Test(description = "Validate whether text entered in the frame is as expected",
            testName = "IFrame Validation")
    public void validateIFrame() {
        new HomePage().clickOnLink(IFRAMES);
        assertTrue(new FramePage().clickOnIFrameLink().enterTextInFrameArea("random")
                .getTextFromFrameField().contains("random"));
    }
}
