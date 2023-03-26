package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.test.pages.DynamicLoadingPage;

public class DynamicLoadingTest extends TestBase {

    @Test
    public void testDynamicLoading() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.clickStartButtonAndWait();
        assertTrue(dynamicLoadingPage.getFinishText().contains("Hello World!"));
    }
}
