package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Collections;
import java.util.List;
import java.util.Set;


public class JavaScriptErrorPage extends BasePage {


    @BeforeClass
    public static void setUp() {
        DriverTest.getDriver().get("http://localhost:7080/javascript_error");
    }


    @Test
    public void findJSError() {
        Set<String> logTypes = DriverTest.getDriver().manage().logs().getAvailableLogTypes();
        if (logTypes.contains("browser")) {
            LogEntries logEntries = DriverTest.getDriver().manage().logs().get(LogType.BROWSER);
            List<LogEntry> logList = logEntries.getAll();
            List<String> stringList = Collections.singletonList(logList.toString());

            for (String each : stringList) {

                if (each.contains("Cannot read properties of undefined (reading 'xyz')")) {
                    System.out.println("Log List: " + each);
                } else {
                    throw new NotFoundException("The text of: 'Cannot read properties of undefined (reading 'xyz') not included");
                }
            }
        }
    }

    @AfterClass
    public static void tearDown(){
        DriverTest.getDriver().close();
    }
}
