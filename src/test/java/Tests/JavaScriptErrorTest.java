package Tests;

import PageRepositories.JavaScriptError;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.*;


@Listeners({ UITestListeners.class })
public class JavaScriptErrorTest extends BaseTest {
    @Test(priority=1)
    @Description("Test JavaScript Error")
    @Severity(SeverityLevel.NORMAL)
    @Feature("JavaScript Error")
    public void javascript_error_test() {
        JavaScriptError javaScriptError = new JavaScriptError(driver);

        javaScriptError.navigate_to_javascript_error_page(base_url);
        javaScriptError.verify_the_error_log("Cannot read property 'xyz' of undefined");
    }
}
