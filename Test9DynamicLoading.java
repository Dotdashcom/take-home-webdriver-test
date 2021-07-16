package com.dotdash;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test9DynamicLoading extends BasePage {


    @Test
    public void testFindElementUsingExplicitWait() {
        driver.get("http://localhost:7080/dynamic_loading/2");
        driver.findElement(By.xpath("//button")).click();
        By locator = By.cssSelector("#finish>h4");
        //This test fails as we expected since element is not visible on page
        findByVisibility(locator,5);

    }

    /**
     * Test passes as element is present in DOM.
     */
    @Test
    public void testElementIsPresentWithExplicitWait() {
        driver.get("http://localhost:7080/dynamic_loading/2");
        driver.findElement(By.xpath("//button")).click();
        By locator = By.cssSelector("#finish>h4");
        //This test fails as we expected since element is not visible on page
        findByPresence(locator,5);
    }

    /**
     * Wait until specified amount of seconds and verify element is displayed or not.
     * @param locator = locator of the Web element
     * @param timeout = wait time in seconds
     * @return
     */
    public WebElement findByVisibility(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    /**
     * Wait until specified amount of seconds and verify element is displayed or not.
     * @param locator = locator of the Web element
     * @param timeout = wait time in seconds
     * @return
     */
    public WebElement findByPresence(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return webElement;
    }

}
