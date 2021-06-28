package com.task.tests;

import com.task.pages.javaScriptErrorsPage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Level;

public class javaScriptErrorsTest {

    javaScriptErrorsPage javaScriptErrorsPage = new javaScriptErrorsPage();


    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/javascript_error");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void javaScriptErrors() {

        LogEntries logEntries = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.filter(Level.ALL);

        for (LogEntry logEntry : logs ) {
            System.out.println(logEntry);
            Assert.assertTrue( logEntry.toString().contains("Cannot read property 'xyz' of undefined"));
            break;
        }

    }


}
