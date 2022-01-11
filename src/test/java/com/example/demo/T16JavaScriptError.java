package com.example.demo;

import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptErrorPage;

import java.util.ArrayList;
import java.util.List;

public class T16JavaScriptError extends TestMain{

    JavaScriptErrorPage javascriptErrorPage;
    String errorMessage = "Cannot read properties of undefined (reading 'xyz')";

    @Test
    public void testErrorInLog(){
        javascriptErrorPage = new JavaScriptErrorPage(driver);
        List<LogEntry> logs = javascriptErrorPage.getLogentries().getAll();
        Assert.assertFalse(logs.isEmpty());
        List<String> errorMessages = new ArrayList<>(logs.size());
        for(LogEntry log:logs){
            errorMessages.add(log.getMessage());
        }
        Assert.assertTrue(javascriptErrorPage.containsError(errorMessages, errorMessage));
    }
}