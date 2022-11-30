package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.FloatingMenuPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FloatingMenuTests extends BaseTest {


    @Test
    public void shouldSeeFloatingMenuWhenScroll() {
        FloatingMenuPage floatingMenuPage = GeneratePage
                .floatingMenuPage()
                .goToFloatingMenuPage()
                .scrollPageDown();

        assertThat(floatingMenuPage.getFloatingMenuButtons().size(), is(4));
        floatingMenuPage.getFloatingMenuButtons().forEach(element -> assertThat(element.isDisplayed(), is(true)));
    }
}
