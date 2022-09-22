package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Date;

public class JsErrorPage extends BasePage {

    public JsErrorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("javaScript_error_url"));
    }

    public void jserrorVerification() throws InterruptedException {

        boolean isJsErrorPresent = false;
        LogEntries logEntries = getDriver().manage().logs().get("browser");
        for (LogEntry entry : logEntries) {
            String errorLog= entry.getMessage().toString();
            if(errorLog.contains("Cannot read properties of undefined")){
                isJsErrorPresent = true;
            }
        }
        Assert.assertEquals(true, isJsErrorPresent );
        Log.info("Js error validated Successfully");
    }
}
