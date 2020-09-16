package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import utils.Driver;

import java.util.stream.Collectors;

public class OpenInNewWindowTests extends TestBase {

    /**
     * Open in New Tab
     * <p>
     * Test clicks on the Click Here link.
     * Test asserts that a new tab is opened with text New Window.
     */


    @Test
    @DisplayName("Test clicks on the Click Here link and asserts that a new tab is opened with text New Window.")
    public void newTabTest() {
        Driver.getDriver().findElement(By.linkText("Multiple Windows")).click();

        String oldWindowHandle = Driver.getDriver().getWindowHandle();

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(oldWindowHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        String expected = "New Window";
        String actual = Driver.getDriver().findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expected, actual, "Text is not correct!");
    }
}
