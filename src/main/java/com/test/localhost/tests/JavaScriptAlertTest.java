package com.test.localhost.tests;

import com.test.localhost.pages.JavaScriptAlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertTest extends TestBase {

    @Test
    public void jsAlertTest(){
        JavaScriptAlertPage javaScriptAlertPage=new JavaScriptAlertPage(driver);
        javaScriptAlertPage.clickJavaScriptAlerts();
        javaScriptAlertPage.validateJsAlertMsg(driver);

    }
    @Test
    public void jsConfirmTest(){
        JavaScriptAlertPage javaScriptAlertPage=new JavaScriptAlertPage(driver);
        javaScriptAlertPage.clickJavaScriptAlerts();
        javaScriptAlertPage.validateJsConfirmMsg(driver);
    }
    @Test
    public void jsPromptTest(){
        JavaScriptAlertPage javaScriptAlertPage=new JavaScriptAlertPage(driver);
        javaScriptAlertPage.clickJavaScriptAlerts();
        javaScriptAlertPage.validateJsPrompt(driver);
    }



}
