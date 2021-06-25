package tests;


import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.JSErrorPage;
import utilities.EndPoints;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;

public class JSError extends TestBase {


    @Test
    public void testJSErrors() {
        JSErrorPage jsep = new JSErrorPage();
        extentTest = extentReports.createTest("JavaScript Error Test");
        extentTest.info("Navigate to JavaScript Error Page");
        jsep.navigateTo(EndPoints.JSERROR);


        LogEntries logEntries = jsep.driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.filter(Level.ALL);
        extentTest.info("Errors are Searching");

        String searchedError="";
        int index=1;
        for (int i=0; i<logs.size(); i++){
            extentTest.info("The "+index+". Error in the page is=> "+ logs.get(i));
            if (logs.get(i).toString().contains("Cannot read property 'xyz' of undefined")){
                searchedError = logs.get(i).toString();}
            index++;
        }

        Assert.assertTrue(searchedError.contains("Cannot read property 'xyz' of undefined"));
        extentTest.info("The Error is Verified which Contains 'Cannot read property 'xyz' of undefined' ");

        extentTest.pass("JavaScript Error Test is Successful");





    }
}
