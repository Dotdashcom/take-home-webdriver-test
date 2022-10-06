package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptError extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/javascript_error");
    }

    @Test
    public void javascriptErrorTest() {
        LogEntries log = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs =  log.getAll();
        String expected = "Cannot read properties of undefined (reading 'xyz')";
        String actual =  logs.get(0).getMessage();
        Assert.assertTrue(actual.contains(expected));
    }
}

