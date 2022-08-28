package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JSError extends Base {

    By content = By.id("content");

    public JSError(WebDriver driver) {
        super(driver);
    }

    public Boolean jsError(){
            LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry logEntry : entries){
                if (logEntry.getMessage().contains("Cannot read properties of undefined (reading 'xyz')")){
                    System.out.println(logEntry.getMessage());
                    return true;
                }
            }
        return false;
    }

    public Boolean compareErrorMessage(){
        return jsError();
    }
}
