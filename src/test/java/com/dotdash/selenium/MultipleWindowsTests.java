package com.dotdash.selenium;

import com.dotdash.selenium.pages.HomePage;
import com.dotdash.selenium.pages.MultipleWindowsPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultipleWindowsTests extends SetUpTearDown {
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
