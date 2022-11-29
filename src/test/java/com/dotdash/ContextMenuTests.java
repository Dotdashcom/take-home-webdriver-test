package com.dotdash;

import com.dotdash.basetest.BaseTest;
import com.dotdash.pageobjects.ContextMenuPage;
import com.dotdash.pageobjects.GeneratePage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContextMenuTests extends BaseTest {

    @Test
    public void shouldOpenAlertAfterRightClick() {
        ContextMenuPage contextMenuPage = GeneratePage.contextMenuPage().goToContextMenuPage().rightClickContextBox();

        assertThat(contextMenuPage.getAlertMessage(), is("You selected a context menu"));
    }
}
