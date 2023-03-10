package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends BasePage{

    protected JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        javaScriptAlertsPage = PageFactory.initElements(driver, JavaScriptAlertsPage.class);
    }

    @Test
    public void jsAlertTest(){

        Assert.assertEquals(javaScriptAlertsPage.jsAlertClick(),"You successfuly clicked an alert");
    }
    @Test
    public void jsConfirmTest(){

        Assert.assertEquals(javaScriptAlertsPage.jsConfirmClick(),"You clicked: Ok");
    }
    @Test
    public void jsPromptTest(){

        Assert.assertEquals(javaScriptAlertsPage.jsPromptClick(),"You entered: text message");
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }
}
