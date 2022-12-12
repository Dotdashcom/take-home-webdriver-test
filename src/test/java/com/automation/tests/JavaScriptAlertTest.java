package com.automation.tests;

import org.testng.annotations.Test;

public class JavaScriptAlertTest extends BaseTest{

    @Test
    public void test(){
        javaScriptAlertsPage.clickOnLink();
        javaScriptAlertsPage.verifyAlerts();
    }
}
