package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.JavaScriptAlerts;

public class JavaScriptAlertsTest extends TestBase {

    @Test
    public void javaScriptAlertsTest(){
        JavaScriptAlerts javaScriptAlerts = new JavaScriptAlerts(driver);
        javaScriptAlerts.jsAlert(driver);
        javaScriptAlerts.jsConfirm(driver);
        javaScriptAlerts.jsPrompt(driver);
    }
}
