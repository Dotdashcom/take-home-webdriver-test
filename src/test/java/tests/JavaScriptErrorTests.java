package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JavaScriptErrorTests extends TestBase {

    /**
     * 16. JavaScript Error
     * <p>
     * Test finds the JavaScript error on the page.
     * Test asserts that the page contains error: Cannot read property 'xyz' of undefined.
     */

    @Test
    @DisplayName("Test finds the JavaScript error on the page and asserts that the page contains error: Cannot read property 'xyz' of undefined.")
    public void jsErrorTest() {
        Driver.getDriver().findElement(By.linkText("JavaScript onload event error")).click();

        LogEntries logEntries = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        String expectedError = "Cannot read property 'xyz' of undefined";

        String logs = logEntries.toJson().stream().map(LogEntry::getMessage).collect(Collectors.joining());

        Assertions.assertTrue(logs.contains(expectedError), "Error message not found in logs!");
    }
}
