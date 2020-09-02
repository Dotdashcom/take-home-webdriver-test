package com.dotdash;

import org.openqa.selenium.logging.*;

import org.testng.Assert;


/**
 * Created by Denys on 9/1/20
 **/
public class DotDashJavaScriptErrors extends BaseAPI {

    public static void navigateToJsErrorPage() {
        driver.get(baseURL + "javascript_error");
    }

    // Function to capture JSError log.
    public static LogEntries GetJSErrosLog() {
        // Capture all JSerrors and print In console.
        LogEntries jserrors = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry error : jserrors) {
            System.out.println(error.getMessage());
        }
        return jserrors;
    }

    // Assert Browser Log contains Errors
    public static void assertPageContainsErrors() {
        Assert.assertNotNull(GetJSErrosLog());
    }


}
