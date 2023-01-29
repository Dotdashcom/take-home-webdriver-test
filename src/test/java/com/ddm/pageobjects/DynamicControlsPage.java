package com.ddm.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends WebPage {

    @FindBy(css = "form#checkbox-example > button")
    protected WebElement addORremoveButton;

    @FindBy(css = "form#checkbox-example > p")
    protected WebElement checkBoxStatusMessage;

    @FindBy(css = "form#input-example > button")
    protected WebElement enableORdisableButton;

    @FindBy(css = "form#input-example > p")
    protected WebElement inputFieldStatusMessage;


    public DynamicControlsPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void removeCheckBox() {
        addORremoveButton.click();

        FluentWait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
        try {
            driverWait.until(statusText -> checkBoxStatusMessage.getText().equalsIgnoreCase("It's gone!"));
        } catch (WebDriverException e) {
            System.out.println("Driver exection occured." + e.getMessage());
        }
    }

    public void addCheckBox() {
        addORremoveButton.click();

        FluentWait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
        try {
            driverWait.until(statusText -> checkBoxStatusMessage.getText().equalsIgnoreCase("It's back!"));
        } catch (WebDriverException e) {
            System.out.println("Driver exection occured." + e.getMessage());
        }
    }

    public void enableInputField() {
        enableORdisableButton.click();

        FluentWait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
        try {
            driverWait.until(statusText -> inputFieldStatusMessage.getText().equalsIgnoreCase("It's enabled!"));
        } catch (WebDriverException e) {
            System.out.println("Driver exection occured." + e.getMessage());
        }
    }

    public void disableInputField() {
        enableORdisableButton.click();

        FluentWait<WebDriver> driverWait = new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
        try {
            driverWait.until(statusText -> inputFieldStatusMessage.getText().equalsIgnoreCase("It's disabled!"));
        } catch (WebDriverException e) {
            System.out.println("Driver exection occured." + e.getMessage());
        }
    }

}
