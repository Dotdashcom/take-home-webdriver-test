package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.JavascriptError;
import pageObjects.Mouseclick;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class Javascripterror extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "javascript_error");

    }



    @Test
    public void Jslogmsg(){

        DesiredCapabilities dc= new DesiredCapabilities();
        LoggingPreferences lp=new LoggingPreferences();

        lp.enable(LogType.BROWSER, Level.ALL);
        dc.setCapability(CapabilityType.LOGGING_PREFS,lp);

        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logs) {
            System.out.println(new SimpleDateFormat(entry.getMessage()));
        }

    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        driver.close();
    }

}
