package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.DynamicContentPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DynamicContentTests extends BaseTest {


    @Test
    public void contentShouldNotBeTheSame() {
        DynamicContentPage dynamicContentPage = GeneratePage.dynamicContentPage().goToDynamicContentPage();
        Reporter.log("Logging into Selenium Playground");
        List<String> initialTextContents = dynamicContentPage.getDynamicTexts();
        List<String> initialImageContents = dynamicContentPage.getImageLinks();

        dynamicContentPage.refreshCurrentPage();

        List<String> refreshedTextContents = dynamicContentPage.getDynamicTexts();
        List<String> refreshedImageContents = dynamicContentPage.getImageLinks();

        assertThat(initialTextContents, is(not(refreshedTextContents)));
        assertThat(initialImageContents, is(not(refreshedImageContents)));
    }
}
