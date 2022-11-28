package com.dotdash.selenium;

import com.dotdash.selenium.pages.ContextMenuPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContextMenuTests extends SetUpTearDown {
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
