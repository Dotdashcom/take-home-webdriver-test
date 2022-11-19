package com.dotdash.scripts;

import com.dotdash.pages.JavascriptAlerts;
import org.junit.Test;
import org.openqa.selenium.Alert;

import static org.hamcrest.CoreMatchers.equalTo;

public class JavascriptAlertsTest extends BaseWebTest<JavascriptAlerts> {

    @Test
    public void jsAlerts() {
        JavascriptAlerts javascriptAlertsPage = getInitialPage();
        Alert alert = javascriptAlertsPage.clickAlertButton();

        String expectedMessage = "I am a JS Alert";
        checkThat("JS Alert message is displayed", alert.getText(), equalTo(expectedMessage));
        alert.accept();
        checkThat("Alert click is successful", javascriptAlertsPage.getResultText(), equalTo("You successfuly clicked an alert"));

        alert = javascriptAlertsPage.clickConfirmButton();
        expectedMessage = "I am a JS Confirm";
        checkThat("JS Confirm message is displayed", alert.getText(), equalTo(expectedMessage));
        alert.accept();
        checkThat("Confirm action is successful", javascriptAlertsPage.getResultText(), equalTo("You clicked: Ok"));

        alert = javascriptAlertsPage.clickPromptButton();
        expectedMessage = "Hello World";
        alert.sendKeys(expectedMessage);
        alert.accept();
        checkThat("Prompt action is successful", javascriptAlertsPage.getResultText(), equalTo("You entered: " + expectedMessage));
    }
}
