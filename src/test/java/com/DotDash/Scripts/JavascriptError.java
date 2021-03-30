package com.DotDash.Scripts;

import com.DotDash.Pages.JavascriptErrorPage;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;import com.DotDash.BasePage.basePage;

import java.util.List;

public class JavascriptError extends basePage {

    @Test
    public void javascriptError() {
        driver.get(baseURL + "/javascript_error");

        JavascriptErrorPage javascriptErrorPage = new JavascriptErrorPage(driver);
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(javascriptErrorPage.gettxterror().contains("This page has a JavaScript error in the onload event"));

        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entry.getAll();
        for (LogEntry e : logs) {
            System.out.println(e);
        }
        for (LogEntry e : logs) {
            System.out.println("Message is: " + e.getMessage());
            if(e.getMessage().contains("Cannot read property 'xyz' of undefined")) {
                assertion.assertTrue(e.getMessage().contains("Cannot read property 'xyz' of undefined"));
            }
            System.out.println("Level is: " + e.getLevel());
        }
        assertion.assertAll();
    }

}
