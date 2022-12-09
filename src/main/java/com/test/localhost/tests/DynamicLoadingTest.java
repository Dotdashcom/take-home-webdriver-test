package com.test.localhost.tests;

import com.test.localhost.pages.DynamicLoading;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends TestBase{

    @Test
    public void dynamicLoadingTest(){
        DynamicLoading dynamicLoading=new DynamicLoading(driver);
        dynamicLoading.clickButtons();
        Assert.assertEquals(dynamicLoading.getMessage(driver),"Hello World!");
    }
}
