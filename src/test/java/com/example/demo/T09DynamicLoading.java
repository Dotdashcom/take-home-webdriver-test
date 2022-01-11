package com.example.demo;

import pages.DynamicLoadingPage;
import org.testng.annotations.Test;
import org.testng.Assert;


public class T09DynamicLoading extends TestMain{
    DynamicLoadingPage dynamicLoadingPage;

    @Test
    public void testDynamicLoading(){
        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.clickStartButton();
        Assert.assertTrue(dynamicLoadingPage.getAlertText().equals("Hello World!"));
    }
}
