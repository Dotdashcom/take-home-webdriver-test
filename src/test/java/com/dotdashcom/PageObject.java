package com.dotdashcom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void rightClick(WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document. " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element is not found in DOM. " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element is not clickable. " + e.getStackTrace());
        }
    }
}
