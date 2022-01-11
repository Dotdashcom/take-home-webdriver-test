package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicContentPage;

public class T07DynamicContent extends TestMain{
    DynamicContentPage dynamicContentPage;

    @Test
    public void testDynamicContent(){
        dynamicContentPage = new DynamicContentPage(driver);
        String OldContent = dynamicContentPage.getContent();
        dynamicContentPage.refreshPage();
        Assert.assertFalse(OldContent.equals(dynamicContentPage.getContent()));
    }
}
