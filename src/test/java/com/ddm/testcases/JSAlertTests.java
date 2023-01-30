package com.ddm.testcases;

import com.ddm.pageobjects.JSAlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSAlertTests extends BaseTestClass {

    protected JSAlertsPage jsAlertsPage;

    @BeforeMethod
    public void setUpMethodJSAlerts() {
        jsAlertsPage = landingPage.goTo("/javascript_alerts", JSAlertsPage.class);
    }

    @Test
    public void jsAlertTest() {
        SoftAssert sf = new SoftAssert();
        String alertText = jsAlertsPage.clickJSAlertAndAccept();
        sf.assertEquals(alertText, "I am a JS Alert", "The text in alert is NOT matching.");
        sf.assertEquals(jsAlertsPage.getResultAreaText(), "You successfuly clicked an alert");
        sf.assertAll();
    }

    @Test
    public void jsConfirmTest() {
        SoftAssert sf = new SoftAssert();
        String confirmText = jsAlertsPage.clickJSConfirmAndClickOK();
        sf.assertEquals(confirmText, "I am a JS Confirm", "The text in confirm is NOT matching.");
        sf.assertEquals(jsAlertsPage.getResultAreaText(), "You clicked: Ok");
        sf.assertAll();
    }

    @Test
    public void jsPromptTest() {
        SoftAssert sf = new SoftAssert();
        String text = "This is for prompt.";
        jsAlertsPage.clickJSPromptAndClickOK(text);
        sf.assertEquals(jsAlertsPage.getResultAreaText(), "You entered: " + text);
        sf.assertAll();
    }
}