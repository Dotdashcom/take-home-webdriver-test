package com.qa.pages;

import com.qa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility extends BasePage {
    public static void wait(WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void navigateBack()
    {
        driver.navigate().back();
    }

    public static void waitUntilDisappear(WebElement ele)
    {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driverWait.until(ExpectedConditions.invisibilityOf(ele));
    }

}
