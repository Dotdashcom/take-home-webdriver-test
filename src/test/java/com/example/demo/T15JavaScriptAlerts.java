package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

public class T15JavaScriptAlerts extends TestMain{
    JavaScriptAlertsPage javaScriptAlertsPage;

    @Test
    public void testJavaScriptAlerts(){
        javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.clickJSAlert();
        Assert.assertEquals(javaScriptAlertsPage.getAlertText(),"I am a JS Alert");
        javaScriptAlertsPage.closeAlert();

        javaScriptAlertsPage.clickJSConfirmButton();
        Assert.assertEquals(javaScriptAlertsPage.getAlertText(), "I am a JS Confirm");
        javaScriptAlertsPage.closeAlert();

        javaScriptAlertsPage.clickJSPrompt();
        javaScriptAlertsPage.typeOnPrompt("test alert");
        javaScriptAlertsPage.closeAlert();
        Assert.assertEquals(javaScriptAlertsPage.getEnteredText(), "You entered: test alert");


    }
}
