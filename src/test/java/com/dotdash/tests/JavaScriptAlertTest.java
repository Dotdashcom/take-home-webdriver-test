package com.dotdash.tests;

import com.dotdash.pages.JavaScriptAlertPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;

public class JavaScriptAlertTest extends TestBase {


    @Test
    public void jsAlertTest(){

        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.navigatePages("JavaScript Alerts");
        javaScriptAlertPage.clickForJSAlert.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        String alertMsg1 = alert.getText();

        Assertions.assertEquals("I am a JS Alert", alertMsg1);

        alert.accept();
        javaScriptAlertPage.clickForJSConfirm.click();
        alertMsg1 = alert.getText();

        Assertions.assertEquals("I am a JS Confirm", alertMsg1);

        alert.accept();
        javaScriptAlertPage.clickForJSPrompt.click();
        alert.sendKeys("Hello World!");
        alert.accept();

        Assertions.assertTrue(javaScriptAlertPage.resultMsg.getText().contains("Hello World!"));






    }



}
