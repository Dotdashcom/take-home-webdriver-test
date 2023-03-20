package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicContentTest extends Util {

    protected DynamicContentPage dynamicContentPage;

    @BeforeTest
    public void setUp(){
        driver = getDriver();
        dynamicContentPage = PageFactory.initElements(driver, DynamicContentPage.class);
    }

    @Test
    public void dynamic_Content_Tests(){

        dynamicContentPage.verifyDynamicContent();
        Assert.assertNotEquals(dynamicContentPage.beforeChangeText1,dynamicContentPage.afterChangeText1);
        Assert.assertNotEquals(dynamicContentPage.beforeChangeText2,dynamicContentPage.afterChangeText2);
        Assert.assertNotEquals(dynamicContentPage.beforeChangeText3,dynamicContentPage.afterChangeText3);
    }
    
    @AfterTest
    public void endTest(){
    	teardown();
    }
}