package com.academy.techcenture;

import com.academy.techcenture.pages.JavaScriptAlertsPage;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends BaseClassTest {

    @Test
    public void javaScriptAlertsTest(){
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver, softAssert);
        javaScriptAlertsPage.navigateTo("/javascript_alerts");
        javaScriptAlertsPage.verifyJavaScriptAlerts();
    }
}
