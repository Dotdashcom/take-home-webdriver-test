package com.dotdash.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

import java.util.Date;
import java.util.logging.Level;

public class JavaScriptErrorPage {

    WebDriver driver;

    public JavaScriptErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verify_page_contains_js_error(String err) {
        boolean is_existing_expected_js_err = false;
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            Level log_level = entry.getLevel();
            String log_msg = entry.getMessage();
            if (log_level.getName() == "SEVERE" && log_msg.contains(err)) {
                is_existing_expected_js_err = true;
            }
        }

        Assert.assertTrue(is_existing_expected_js_err, "[ERR] Expected js error does not exist!");
    }
}
