package com.dotdash.webtest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

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

    public static void scrollToElementWithJs(WebDriver driver, WebElement element) {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public boolean switchToAnotherTab(String title) {
        boolean foundTab = false;
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                foundTab = true;
                break;
            }
        }
        return foundTab;
    }
}
