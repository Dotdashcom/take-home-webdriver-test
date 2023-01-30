package com.ddm.testcases;

import com.ddm.pageobjects.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTests extends BaseTestClass {

    protected ContextMenuPage contextMenuPage;

    @BeforeMethod
    public void setUpMethodContextMenu() {
        contextMenuPage = landingPage.goTo("/context_menu", ContextMenuPage.class);
    }


    @Test
    public void ContextMenuTest() {
        contextMenuPage.contextClickOnTarget();

        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu");
    }
}
