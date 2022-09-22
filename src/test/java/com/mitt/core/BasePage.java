package com.mitt.core;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    @Getter
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findElement(By locator) {
        waitForElementToAppear(locator);
        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        if (isElementPresent(locator)) return getDriver().findElement(locator);
        return null;
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
    protected  boolean isElementPresent(By by) {
        try {
            return getDriver().findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            Log.error("Element is not present on web page");
            return false;
        } catch (Exception e) {
            Log.error("There is some issue, could you plesae check script");
            return false;
        }
    }
    protected boolean isSelected(By by) {
        return getDriver().findElement(by).isSelected();
    }
    protected void wait(int mili) {
        try {
           Thread.sleep(mili);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected boolean pageSourceVerify(String text) {

        if(getDriver().getPageSource().contains(text)) return true;

        else return false;
    }
}
