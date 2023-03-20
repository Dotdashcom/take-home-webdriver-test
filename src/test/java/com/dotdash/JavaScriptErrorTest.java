package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptErrorTest extends Util{
    protected JavaScriptErrorPage javaScriptErrorPage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        javaScriptErrorPage = PageFactory.initElements(driver, JavaScriptErrorPage.class);
    }

    @Test
    public void js_Error_Test() throws InterruptedException {
        Assert.assertTrue(javaScriptErrorPage.jsErrorCheck().contains(prop.getProperty("JSerrorString")));
    }
    @AfterClass
    public void endTest(){
        teardown();
    }


}