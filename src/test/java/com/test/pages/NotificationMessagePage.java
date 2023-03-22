package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.util.Config;

public class NotificationMessagePage {

    private WebDriver driver;

    private By clickHereLink = By.linkText("Click here");
    private By message = By.id("flash");

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("notification"));
    }

    public void clickClickHereLink() {
        driver.findElement(clickHereLink).click();
    }

    public boolean isMessageDisplayed() {
        return driver.findElement(message).isDisplayed();
    }
}
