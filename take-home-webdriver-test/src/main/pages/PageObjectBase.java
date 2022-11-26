package com.framework.pages;

import com.framework.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public abstract class PageObjectBase {
    protected WebDriver driver;
    protected Properties prop = Utils.loadConfig();
    protected PageObjectBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

} 

