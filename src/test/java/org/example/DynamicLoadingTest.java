package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BasePage{

    protected DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        dynamicLoadingPage = PageFactory.initElements(driver, DynamicLoadingPage.class);
    }

    @Test
    public void DynamicLoadingTest(){
        dynamicLoadingPage.clickStartButton();
        Assert.assertEquals(dynamicLoadingPage.getHelloWorldText().getText(),"Hello World!");
    }
    @AfterMethod
    public void endTest(){
        teardown();
    }
}
