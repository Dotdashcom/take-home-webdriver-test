package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.FloatingMenuPage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.app.pageobjects.LoginPage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FloatingMenuTests extends BaseTest {
    HomePage homePage;
    FloatingMenuPage floatingMenuPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        floatingMenuPage = new FloatingMenuPage(driver);
    }

    @Test
    public void verifyFloatingMenuIsDisplayedAfterScrollDown() {
        homePage.clickFloatingMenuLink();
        floatingMenuPage.scrollDown();
        Assert.assertTrue(floatingMenuPage.isMenuDisplayed());
    }
}
