package com.dotdash.webtest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebPage {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;

    public WebPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForVisibilityOfElement (String cssSelector) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }
}
