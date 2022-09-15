package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.app.pageobjects.MultipleWindowsPage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultipleWindowsTests extends BaseTest {
    HomePage homePage;
    MultipleWindowsPage multipleWindowsPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        multipleWindowsPage = new MultipleWindowsPage(driver);
    }

    @Test
    public void verifyMessageFromNewTab(){
        homePage.clickMultipleWindowsLink();
        multipleWindowsPage.clickOpenNewTabLink();
        multipleWindowsPage.switchToNewTab();
        Assert.assertEquals("New Window", multipleWindowsPage.getNewTabMessage());
    }
}
