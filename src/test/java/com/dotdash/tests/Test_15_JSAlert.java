package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.JSAlertPage;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

public class Test_15_JSAlert extends TestBase {
    @Test
    public void js_alert_test() {

        JSAlertPage javaScriptAlertPage = new JSAlertPage();
        javaScriptAlertPage.navigatePages("JavaScript Alerts");
        javaScriptAlertPage.clickForJSAlert.click();
        Alert alert = DriverUtils.getDriver().switchTo().alert();
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
