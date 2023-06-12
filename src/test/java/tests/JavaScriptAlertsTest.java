package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptAlertsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptAlertsTest extends BaseTest{
    @Test
    public void verifyJsAlerts() {
        HomePage homePage = new HomePage(driver);
        JavaScriptAlertsPage jsAlert = homePage.clickJavascriptAlert();
        String alertText = jsAlert.clickJavaScriptAlert();
        assertEquals(alertText, "I am a JS Alert");
    }
    @Test
    public void verifyJSConfirm() {
        HomePage homePage = new HomePage(driver);
        JavaScriptAlertsPage jsAlert = homePage.clickJavascriptAlert();
        String alertText = jsAlert.clickJavaScriptConfirm();
        assertEquals(alertText, "I am a JS Confirm");
    }

    @Test
    public void verifyJSPrompt() {
        HomePage homePage = new HomePage(driver);
        JavaScriptAlertsPage jsAlert = homePage.clickJavascriptAlert();
        String message = "test";
        jsAlert.clickJavaScriptPrompt(message);
        assertTrue(jsAlert.getResultMessage().contains(message));
    }

}
