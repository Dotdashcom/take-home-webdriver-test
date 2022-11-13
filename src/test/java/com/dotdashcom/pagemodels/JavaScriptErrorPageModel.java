package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

public class JavaScriptErrorPageModel extends PageObject {

    public static final String PAGE_URL = "/javascript_error";

    public JavaScriptErrorPageModel(WebDriver driver) {
        super(driver);
    }

    public LogEntries getLogEntries() {
        return driver.manage().logs().get(LogType.BROWSER);
    }
}
