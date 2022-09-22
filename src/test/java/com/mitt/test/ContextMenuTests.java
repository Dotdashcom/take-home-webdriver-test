package com.mitt.test;

import com.mitt.pages.CheckBoxesPage;
import com.mitt.pages.ContextMenuPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenuTests extends BaseTest{

    ContextMenuPage contextMenuPage;

    @BeforeClass
    public void setUp(){
        contextMenuPage = new ContextMenuPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu(){
        contextMenuPage.rightClickContextMenu();
        contextMenuPage.verifyAlertMenuText();
    }

}
