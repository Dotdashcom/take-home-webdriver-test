package com.dotdash.selenium;

import com.dotdash.selenium.pages.DynamicLoadingPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicLoadingTests extends SetUpTearDown {
    HomePage homePage;
    DynamicLoadingPage dynamicLoadingPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test
    public void verifyHelloWorldTextIsDisplayed() throws InterruptedException {
        homePage.clickDynamicLoadingLink();
        dynamicLoadingPage.start();
        Assert.assertEquals("Hello World!", dynamicLoadingPage.getMessage());
    }
}