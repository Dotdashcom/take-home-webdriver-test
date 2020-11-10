package Tests;

import PageRepositories.JavaScriptAlerts;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Listeners({ UITestListeners.class })
public class JavaScriptAlertsTest extends BaseTest {
    @Test(priority=1)
    @Description("Test JavaScript Alerts Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Feature("JavaScript Alerts")
    public void javascript_alerts_test() {
        JavaScriptAlerts javaScriptAlerts = new JavaScriptAlerts(driver);

        javaScriptAlerts.navigate_to_javascript_alerts_page(base_url);
        javaScriptAlerts.validate_javascript_alerts_page_header();

        javaScriptAlerts.click_js_alert();
        javaScriptAlerts.verify_js_alart();
        javaScriptAlerts.click_js_confirm();
        javaScriptAlerts.verify_js_confirm();
        //TODO: Currently This is not working. Need to find a JS equivalent to type in the alert
//        javaScriptAlerts.click_js_prompt();
//        javaScriptAlerts.type_js_prompt();
//        javaScriptAlerts.verify_js_prompt_result();
    }
}
