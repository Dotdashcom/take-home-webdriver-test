package tests;

import org.openqa.selenium.logging.LogEntries;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptErrorPage;

import static org.testng.Assert.assertTrue;

public class JavaScriptErrorTest extends BaseTest {
    @Test
    public void verifyJSError() {
        HomePage homePage = new HomePage(driver);
        JavaScriptErrorPage jsError = homePage.clickJavaScriptError();
        LogEntries logs = jsError.checkLogs();
        boolean isUndefinedError = logs.getAll().stream()
                .filter(log -> log.getMessage()
                        .contains("Cannot read properties of undefined (reading 'xyz')"))
                .count() > 0;
        assertTrue(isUndefinedError);
    }
}
