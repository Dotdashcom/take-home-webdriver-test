package src.test;

import org.testng.annotations.Test;
import src.main.pages.*;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AlertsTest extends BaseTest {



    private JavaScriptAlertsPage javaScriptAlertsPage;

    @Test
    public void alertTest() {
        javaScriptAlertsPage = Browser.open(baseURL + "javascript_alerts", JavaScriptAlertsPage.class);

        javaScriptAlertsPage.triggerAlert();
        assertEquals(javaScriptAlertsPage.geAlertText(), "I am a JS Alert");
        javaScriptAlertsPage.acceptAlert();
        assertEquals(javaScriptAlertsPage.getResult(), "You successfuly clicked an alert");

        javaScriptAlertsPage.triggerConfirm();
        assertEquals(javaScriptAlertsPage.geAlertText(), "I am a JS Confirm");
        javaScriptAlertsPage.dismissAlert();
        assertEquals(javaScriptAlertsPage.getResult(), "You clicked: Cancel");

        javaScriptAlertsPage.triggerPrompt();
        javaScriptAlertsPage.setInput("This is new text for prompt.");
        javaScriptAlertsPage.acceptAlert();
        assertEquals(javaScriptAlertsPage.getResult(), "You entered: This is new text for prompt.");
    }

}
