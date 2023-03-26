package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import com.test.pages.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends TestBase {

    private JavaScriptAlertsPage jsAlertsPage;

    @Test
    public void testJSAlert() {
        String expectedAlertMsg = "I am a JS Alert";
        String expectedLogMsg = "You successfuly clicked an alert";

        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.clickJSAlertButton();

        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();
        alert.accept();

        String actualLogMsg = jsAlertsPage.getResultMessage();

        assertEquals(expectedAlertMsg, actualAlertMsg);
        assertEquals(expectedLogMsg, actualLogMsg);

    }

    @Test
    public void testJSConfirm() {
        String expectedConfirmMsg = "I am a JS Confirm";
        String expectedLogMsg = "You clicked: Ok";

        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.clickJSConfirmButton();

        Alert alert = driver.switchTo().alert();
        String actualConfirmMsg = alert.getText();
        alert.accept();
        String actualLogMsg = jsAlertsPage.getResultMessage();

        assertEquals(expectedConfirmMsg, actualConfirmMsg);
        assertEquals(expectedLogMsg, actualLogMsg);

    }

    @Test
    public void testJSPrompt() {
        String expectedPromptMsg = "Hello World";
        String expectedLogMsg = "You entered: " + expectedPromptMsg;

        jsAlertsPage = new JavaScriptAlertsPage(driver);
        jsAlertsPage.clickJSPromptButton(expectedPromptMsg);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(expectedPromptMsg);
        alert.accept();
        String actualLogMsg = jsAlertsPage.getResultMessage();
        assertEquals(expectedLogMsg, actualLogMsg);
    }


}
