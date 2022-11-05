package com.test.github;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptErrorTest___NOtWorking {
	WebDriver driver;
	public JavascriptExecutor jsExec;
    @BeforeTest
    public void setup() {
    	
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/javascript_error");
        
    }
    @Test
    public void javaScriptErrorTest() throws IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
//    	Set<String> LogTypes=driver.manage().logs().getAvailableLogTypes();
//    	 vfor(String LogType:LogTypes) {
//    		System.out.println(LogType);
//    	}
//    	
//    	LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//    	List<LogEntry> logs=logEntries.filter(Level.ALL);
//    	for(LogEntry entry : logs){
//    	System.out.println(entry);
    	
    }
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

