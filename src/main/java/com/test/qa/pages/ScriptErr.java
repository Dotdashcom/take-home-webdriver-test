package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ScriptErr extends TestBase {


    public ScriptErr() {
        PageFactory.initElements(driver, this);

    }




    public void JavaScript_Error() {
        String ExpectedError = "Cannot read properties of undefined (reading 'xyz')";

        LogEntries JSError = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry error : JSError) {
            System.out.println(error.getMessage());

            if (error.getMessage().contains(ExpectedError)) {
                Assert.assertTrue(true);

            }else
                break;

        }
    }

}
