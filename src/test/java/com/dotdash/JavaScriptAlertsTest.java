package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends Util{

    protected JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        javaScriptAlertsPage = PageFactory.initElements(driver, JavaScriptAlertsPage.class);
    }

    @Test
    public void js_Alert_Test(){

        Assert.assertEquals(javaScriptAlertsPage.jsAlertClick(),"You successfuly clicked an alert");
    }
    @Test
    public void js_Confirm_Test(){

        Assert.assertEquals(javaScriptAlertsPage.jsConfirmClick(),"You clicked: Ok");
    }
    @Test
    public void js_Prompt_Test(){

        Assert.assertEquals(javaScriptAlertsPage.jsPromptClick(),"You entered: text message");
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }
}