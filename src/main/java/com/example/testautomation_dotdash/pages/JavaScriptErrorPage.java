package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class JavaScriptErrorPage extends BasePage {

    public JavaScriptErrorPage(WebDriver driver){
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/javascript_error");
    }


    public boolean assertJSErrorMessage(){

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = logEntries.getAll();

        for(LogEntry logEntry : logs){
            System.out.println(logEntry);

            if (logEntry.toString().contains("Cannot read properties of undefined (reading 'xyz')")){
                return true;
            }
        }

        return false;
    }
}
