package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.ContextMenuPage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContextMenuTests extends BaseTest {
    HomePage homePage;
    ContextMenuPage contextMenuPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void verifyContextMenuMessage(){
        homePage.clickContextMenuLink();
        contextMenuPage.rightClickDottedBox();
        Assert.assertEquals("You selected a context menu", contextMenuPage.getAlertMessage());
    }
}
