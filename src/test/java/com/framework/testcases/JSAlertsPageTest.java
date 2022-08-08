package com.framework.testcases;

import com.framework.pages.JSAlertsPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSAlertsPageTest extends TestBase {
    JSAlertsPage jsAlertsPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @AfterTest
    public void teardown() {
        super.cleanup();
    }

    @Test(priority = 1, description = "User is on the JS alerts page")
    public void user_is_on_js_alerts_page() {
        jsAlertsPage = new JSAlertsPage(driver);
        jsAlertsPage.navigate();
        String actualURL = jsAlertsPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/javascript_alerts";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can click JS Alert button")
    public void user_can_get_message_after_js_alert_button_click() {
        jsAlertsPage = new JSAlertsPage(driver);
        jsAlertsPage.navigate();
        String actualMessage = jsAlertsPage.clickJSAlertButton().getResults();
        String expectedMessage = "You successfuly clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(priority = 2, description = "User can click JS Confirm button")
    public void user_can_get_message_after_js_confirm_button_click() {
        jsAlertsPage = new JSAlertsPage(driver);
        jsAlertsPage.navigate();
        String actualMessage = jsAlertsPage.clickJSConfirmButton().getResults();
        String expectedMessage = "You clicked: Ok";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(priority = 2, description = "User can click JS Prompt button")
    public void user_can_get_message_after_js_prompt_button_click() {
        String message = "Hello!";
        jsAlertsPage = new JSAlertsPage(driver);
        jsAlertsPage.navigate();
        String actualMessage = jsAlertsPage.clickJSPromptButton(message).getResults();
        String expectedMessage = "You entered: " + message;
        Assert.assertEquals(actualMessage, expectedMessage);
    }


}
