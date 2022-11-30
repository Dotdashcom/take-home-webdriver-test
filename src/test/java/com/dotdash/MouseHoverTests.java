package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.GeneratePage;
import com.dotdash.pageobjects.MouseHoverPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MouseHoverTests extends BaseTest {

    @Test
    public void shouldSeeHoveredInformation() {
        MouseHoverPage mouseHoverPage = GeneratePage
                .mouseHoverPage()
                .goToMouseHoverPage();

        List<Boolean> displayedList = mouseHoverPage.areElementsDisplayed();

        displayedList.forEach(displayed -> assertThat(displayed, is(true)));
    }
}
