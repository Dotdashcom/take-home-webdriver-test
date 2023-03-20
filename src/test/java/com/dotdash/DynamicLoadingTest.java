package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DynamicLoadingTest extends Util{

    protected DynamicLoadingPage dynamicLoadingPage;

    @BeforeTest
    public void setUp(){
        driver = getDriver();
        dynamicLoadingPage = PageFactory.initElements(driver, DynamicLoadingPage.class);
    }

    @Test
    public void test_Dynamic_Loading(){
        dynamicLoadingPage.clickStartButton();
        Assert.assertEquals(dynamicLoadingPage.getHelloWorldText().getText(),"Hello World!");
    }
    @AfterTest
    public void endTest(){
    	teardown();
    }
}