package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.GeneratePage;
import com.dotdash.pageobjects.OpenInNewTabPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenInNewTabTests extends BaseTest {

    @Test
    public void shouldSeeTextInSwitchedTab() {
        OpenInNewTabPage openInNewTabPage = GeneratePage
                .openInNewTabPage()
                .goToOpenInNewTabPage()
                .switchTabs();

        assertThat(openInNewTabPage.getSwitchedTabText(), is("New Window"));
    }
}
