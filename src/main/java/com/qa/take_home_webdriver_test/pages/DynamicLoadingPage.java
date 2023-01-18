package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BasePage {

    // PAGE INITIALIZATION:
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By START_BTN = By.cssSelector("div[id='start'] button");
    private static final By HELLO_HEADER = By.cssSelector("div[id='finish'] h4");

    // WEB ELEMENTS:
    private WebElement getStartBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(START_BTN));
        return driver.findElement(START_BTN);
    }

    private WebElement getHelloHeader() {
        wait.until(ExpectedConditions.presenceOfElementLocated(HELLO_HEADER));
        return driver.findElement(HELLO_HEADER);
    }

    // METHODS:
    public boolean isHelloHeaderDisplayed(String message) {
        try {
            log.info("User can see '" + message + "'. ");
            System.out.println(" =====> " + getHelloHeader().getText() + " <===== ");
            return getHelloHeader().isDisplayed() && getHelloHeader().getText().equals(message);
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }

    public void doClickStartBtn() {
        log.info("User clicks on the 'Start' button. ");
        getStartBtn().click();
        log.warn("Selenium is waiting for appearing of message. ");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(HELLO_HEADER));
    }

}


