package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Click on "Remove" box element and wait until "It's gone!" text appears.
 * Then get text from the "It's gone!" element and print it.
 */
public class Test8DynamicControl extends BasePage {

    @Test
    public void testWaitForElement() {
        driver.get("http://localhost:7080/dynamic_controls");
        WebElement addOrRemoveBtn = driver.findElement(By.cssSelector("[id='checkbox-example']>button"));
        //Click Remove button to delete checkbox and wait until "It's gone!" confirmation message
        addOrRemoveBtn.click();
        By itsGone = By.xpath("//p[text()=\"It's gone!\"]");
        WebElement webElement = findByVisibility(itsGone,10);
        System.out.println(webElement.getText());

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


    @Test
    public void testClickOnElement() {
        driver.get("http://localhost:7080/dynamic_controls");
        WebElement enableOrDisableBtn = driver.findElement(By.cssSelector("#input-example>button"));
        enableOrDisableBtn.click();
        By textBoxLocator = By.cssSelector("#input-example>input");
        WebElement textBoxWeElement = findByClickability(textBoxLocator, 10);
//        WebElement textBoxElement = driver.findElement(textBox);
        textBoxWeElement.sendKeys("hi selenium");
        //additionally test that the element is enabled
        Assert.assertTrue(textBoxWeElement.isEnabled());
    }


    /**
     * Wait until specified amount of time and verify element is displayed or not.
     * @param locator = locator of the Web element
     * @param timeout = wait time in seconds
     * @return WebElement
     */
    public WebElement findByClickability(By locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

}

