package com.dotdash.tests;

import com.dotdash.pages.JavaScriptErrorPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class JavaScriptErrorTest extends TestBase {

    @Test
    public void jsError() {

        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage();
        javaScriptErrorPage.navigatePages("JavaScript onload event error");

        LogEntries jserrors = Driver.getDriver().manage().logs().get(LogType.BROWSER);
        String expectedResult = "Cannot read properties of undefined (reading 'xyz')";

        for (LogEntry error : jserrors) {
            String temp = error.getMessage();
            System.out.println(temp);
            if(temp.contains(expectedResult)){
                System.err.println(error.getMessage());

                Assertions.assertTrue(temp.contains(expectedResult));
            }


        }




    }


}
