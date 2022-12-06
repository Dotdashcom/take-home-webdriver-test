package com.web.testcases;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.JavaScriptErrorPage;


public class JavaScriptErrorTest extends TestBase{

    JavaScriptErrorPage javaScriptErrorPage;

    public JavaScriptErrorTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/javascript_error");
        javaScriptErrorPage = new JavaScriptErrorPage();

    }

    @Test()
    public void verifyJavaScriptError(){

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry entry:logEntries){
                Assert.assertTrue(entry.getMessage().contains("Cannot read properties"));
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}