package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBoxesPage extends BasePage {

    // PAGE INITIALIZATION:
    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By CHECKBOX1 = By.cssSelector("input[type='checkbox']:first-of-type");
    private static final By CHECKBOX2 = By.cssSelector("input[type='checkbox']:last-of-type");


    // WEB ELEMENTS:
    private WebElement getCheckBox1() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX1));
        return driver.findElement(CHECKBOX1);
    }

    private WebElement getCheckBox2() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX2));
        return driver.findElement(CHECKBOX2);
    }

    // METHODS:
    public boolean clickCheckBox1() {
        try {
            if (!getCheckBox1().isSelected() && getCheckBox1().isDisplayed()) {
                log.info("User clicks on the 'checkbox 1'");
                getCheckBox1().click();
            } else {
                log.info("User undoes click on the 'checkbox 1'");
                getCheckBox1().click();
            }
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
        return getCheckBox1().isSelected() || !getCheckBox1().isSelected();
    }

    public boolean clickCheckBox2() {
        try {
            if (getCheckBox2().isSelected() && getCheckBox2().isDisplayed()) {
                log.info("User undoes click on the 'checkbox 2'");
                getCheckBox2().click();
            } else {
                log.info("User clicks on the 'checkbox 2'");
                getCheckBox2().click();
            }
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
        return getCheckBox2().isSelected() || !getCheckBox2().isSelected();
    }

}


