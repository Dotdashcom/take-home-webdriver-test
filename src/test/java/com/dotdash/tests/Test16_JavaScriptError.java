package com.dotdash.tests;

import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test16_JavaScriptError {

    /**
     * Test finds the JavaScript error on the page.
     * Test asserts that the page contains error: Cannot read properties of undefined (reading 'xyz')
     */

    @Test
    public void javaScriptErrorTest() {

        String url = ConfigurationReader.getProperty("base.url") + "/javascript_error";
        Driver.getDriver().get(url);

        String expectedError = "Cannot read properties of undefined (reading 'xyz')";

        LogEntries logEntries = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        String actualError = "";
        for (LogEntry each : logEntries) {
            if (each.getMessage().contains(expectedError)){
                actualError = each.getMessage();
            }
        }

        Assert.assertTrue(actualError.contains(expectedError));

        Driver.closeDriver();
    }
}
