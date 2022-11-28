package com.dotdash.selenium;

import com.dotdash.selenium.pages.FloatingMenuPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FloatingMenuTests extends SetUpTearDown {
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
