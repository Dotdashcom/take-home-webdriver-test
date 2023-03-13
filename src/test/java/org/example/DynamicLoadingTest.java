package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

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
