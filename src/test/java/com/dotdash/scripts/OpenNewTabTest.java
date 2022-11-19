package com.dotdash.scripts;

import com.dotdash.pages.NewTab;
import com.dotdash.pages.OpenNewTab;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class OpenNewTabTest extends BaseWebTest<OpenNewTab> {

    @Test
    public void openNewTab() {
        NewTab newTabPage = getInitialPage().openNewTab();

        String expectedMessage = "New Window";
        checkThat("New tab message is displayed", newTabPage.getNewTabText(), equalTo(expectedMessage));
    }
}
