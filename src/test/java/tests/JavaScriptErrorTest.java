package tests;

import enums.Pages;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.List;
import java.util.logging.Level;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaScriptErrorTest extends TestBase {

    @Test(description = "JavaScript Error Test")
    public void javaScriptErrorTest() {
        BrowserUtils.openPage(driver, Pages.JAVASCRIPT_ERROR_PAGE);
        List<LogEntry> errorLogs = BrowserUtils.getBrowserLogs(driver, Level.SEVERE);
        if (errorLogs.size() != 0) {
            assertThat(errorLogs.toString()).contains("Cannot read properties of undefined (reading 'xyz')");
        }
    }
}
