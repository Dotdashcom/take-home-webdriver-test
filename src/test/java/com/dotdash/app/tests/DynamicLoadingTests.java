package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.DynamicLoadingPage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicLoadingTests extends BaseTest {
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
