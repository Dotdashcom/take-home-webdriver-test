package com.dotdash.core.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public String baseUrl = "http://localhost:7080/"; // This can be retrieved from a config file

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(baseUrl);

    }

    protected void waitForElementToAppear(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        try {
            waitForElementToAppear(element);
            element.click();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(WebElement element, String keys) {
        try {
            click(element);
            element.clear();
            element.sendKeys(keys);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
