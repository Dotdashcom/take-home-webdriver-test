package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptErrorPage extends Util{

    protected WebDriver driver;

    private By jsErrorPage = By.cssSelector("[href='\\/javascript_error']");
    
    public JavaScriptErrorPage(WebDriver driver){
        this.driver = driver;
    }

    public void openJSErrorPage(){
        driver.findElement(jsErrorPage).click();
    }
    
    public List<String> jsErrorCheck() throws InterruptedException {
        List<String> errorMessages = new ArrayList<String>();
        List<String> message = new ArrayList<String>();
        message.add("no error");

        openJSErrorPage();
        LogEntries jserrors = driver.manage().logs().get(LogType.BROWSER);
        if(jserrors != null) {
            for (LogEntry error : jserrors) {
                System.err.println(error.getMessage());
                errorMessages.add(error.getMessage());
            }
            return errorMessages;
        }
        return message;
    }

}
