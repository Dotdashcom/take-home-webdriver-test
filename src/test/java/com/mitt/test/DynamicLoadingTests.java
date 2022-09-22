package com.mitt.test;

import com.mitt.pages.DynamicContentPage;
import com.mitt.pages.DynamicLoadingPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoadingTests extends BaseTest{

    DynamicLoadingPage dynamicloadingPage;

    @BeforeClass
    public void setUp(){
        dynamicloadingPage = new DynamicLoadingPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu(){
        dynamicloadingPage.dynamicContentLoadingVerification();
    }
}
