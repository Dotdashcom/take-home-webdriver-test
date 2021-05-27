//package com.dotdash.stepDeffinition;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.logging.LogEntries;
//import org.openqa.selenium.logging.LogEntry;
//import org.openqa.selenium.logging.LogType;
//import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.util.Date;
//import java.util.logging.Level;
//
//public class JavaScriptErrorTest {
//
//    public WebDriver driver;
//
//    @Before
//    public void setup(){
//
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        LoggingPreferences loggingPreferences = new LoggingPreferences();
//        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
//        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
//        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//        driver = new ChromeDriver(capabilities);
//
//
//    }
//
//    @After
//    public void teardown(){
//        driver.quit();
//
//    }
//
//    public void getJavaScriptLogInfo(){
//        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//
//        for(LogEntry entry : logEntries){
//
//            System.out.println(new Date(entry.getTimestamp()+" "+entry.getLevel()+" "+entry.getMessage()));
//
//        }
//
//    }
//
//    @Test
//    public void jsErrorTest(){
//        driver.get("http://localhost:7080/javascript_error");
//        getJavaScriptLogInfo();
//
//
//    }
//
//}
//







