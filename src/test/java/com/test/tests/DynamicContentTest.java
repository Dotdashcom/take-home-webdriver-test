package com.test.tests;

import org.junit.jupiter.api.Test;

import com.test.pages.DynamicContentPage;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DynamicContentTest extends TestBase {

    @Test
    public void testDynamicContent() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

        String content1 = dynamicContentPage.getContent();
        dynamicContentPage.refreshPage();
        String content2 = dynamicContentPage.getContent();

        assertNotEquals(content1, content2);
    }

}
