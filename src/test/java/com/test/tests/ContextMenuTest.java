package com.test.tests;

import org.junit.jupiter.api.Test;

import com.test.pages.ContextMenuPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextMenuTest extends TestBase {

    @Test
    public void testContextMenu() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.rightClickOnBox();

        String alertText = contextMenuPage.getAlertText();
        assertEquals("You selected a context menu", alertText);
    }

}
