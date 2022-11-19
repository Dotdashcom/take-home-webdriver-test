package com.dotdash.scripts;

import com.dotdash.pages.FloatingMenu;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class FloatingMenuTest extends BaseWebTest<FloatingMenu> {

    @Test
    public void floatingMenuDisplayed() {
        FloatingMenu floatingMenuPage = getInitialPage();

        checkThat("Menu is displayed at top of the page", floatingMenuPage.isFloatingMenuDisplayed(), is(true));

        floatingMenuPage.scrollToPageBottom();

        checkThat("Menu is displayed after scrolling", floatingMenuPage.isFloatingMenuDisplayed(), is(true));
    }
}
