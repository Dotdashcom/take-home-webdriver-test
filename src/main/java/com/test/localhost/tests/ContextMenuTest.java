package com.test.localhost.tests;

import com.test.localhost.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends TestBase {

    @Test
    public void contextTest() {
        ContextMenuPage contextMenuPage=new ContextMenuPage(driver);
        contextMenuPage.clickContextMenu();
        contextMenuPage.rightClickTest(driver);
        Assert.assertEquals("You selected a context menu",contextMenuPage.validateText(driver));
    }
}
