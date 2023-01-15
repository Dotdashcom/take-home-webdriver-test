package com.tests;

import com.assignments.pages.DynamicContentPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import static com.assignments.constants.LinkNameConstants.DYNAMIC_CONTENT;
import static org.testng.Assert.assertFalse;

public final class DynamicContentTest extends BaseTest {


    /**
     * Private constructor for avoiding external instantiation.
     */
    private DynamicContentTest() {

    }

    @Test(description = "Validate Content get Changed on Every Refresh",
            testName = "Dynamic Content Validation")
    public void validateDynamicContent() {
        new HomePage().clickOnLink(DYNAMIC_CONTENT);
        String contentBeforeRefresh = new DynamicContentPage().getSourceCode();
        String contentAfterRefresh = new DynamicContentPage().clickOnClickHere().getSourceCode();
        assertFalse(contentBeforeRefresh.equals(contentAfterRefresh));
    }
}
