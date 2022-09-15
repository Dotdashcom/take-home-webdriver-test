package com.dotdash.app.pageobjects;

import com.dotdash.core.helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;

public class JavascriptErrorsPage extends BasePage {
    public JavascriptErrorsPage(WebDriver driver) {
        super(driver);
    }

    public String getJSConsoleError(){
        return driver.manage().logs().get(LogType.BROWSER).getAll().toString();
    }
}
