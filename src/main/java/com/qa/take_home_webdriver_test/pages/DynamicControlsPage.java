package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends BasePage {

    // PAGE INITIALIZATION:
    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By CHECKBOX = By.cssSelector("input[type='checkbox']");
    private static final By MESSAGE = By.cssSelector("p[id='message']");
    private static final By REMOVE_ADD_BTN = By.cssSelector("button[onclick='swapCheckbox()']");
    private static final By ENABLE_DISABLE = By.cssSelector("button[onclick='swapInput()']");


    // WEB ELEMENTS:
    private WebElement getCheckBox() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CHECKBOX));
        return driver.findElement(CHECKBOX);
    }

    private WebElement getMessage() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MESSAGE));
        return driver.findElement(MESSAGE);
    }

    private WebElement getRemoveAddBtn() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(REMOVE_ADD_BTN));
        return driver.findElement(REMOVE_ADD_BTN);
    }

    private WebElement getEnableDisableBtn() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ENABLE_DISABLE));
        return driver.findElement(ENABLE_DISABLE);
    }

    // METHODS:
    public boolean isMessageDisplayed(String message) {
        try {
            log.info("User sees '" +message+"'. ");
            System.out.println(" =====> " + getMessage().getText() + " <===== ");
            return getMessage().isDisplayed() && getMessage().getText().equals(message);
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

    public void doClickCheckBox() {
        log.info("User clicks on the checkbox. ");
        getCheckBox().click();
    }

    public void doRemoveAddCheckBox() {
        log.info("User clicks on the 'Remove/Add' button. ");
        getRemoveAddBtn().click();
        log.warn("Selenium is waiting for appearing of message. ");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MESSAGE));
    }

    public void doClickOnEnableDisable() {
        log.info("User clicks on the 'Enable/Disable' button. ");
        getEnableDisableBtn().click();
        log.warn("Selenium is waiting for appearing of message. ");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MESSAGE));
    }
}


