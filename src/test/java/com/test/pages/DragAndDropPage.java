package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.util.Config;

public class DragAndDropPage {

    private WebDriver driver;

    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("dragdrop"));
    }

    public void dragColumnAToColumnB() {
        Actions actions = new Actions(driver);
        WebElement sourceElement = driver.findElement(columnA);
        WebElement targetElement = driver.findElement(columnB);
            
        // Wait for the elements to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(sourceElement));
        wait.until(ExpectedConditions.elementToBeClickable(targetElement));
            
        // Perform click and hold on source element
        actions.clickAndHold(sourceElement).build().perform();
        
        // Move the element to the target element and release the mouse button
        actions.moveToElement(targetElement).release().build().perform();
    }




    public String getColumnAText() {
        return driver.findElement(columnB).getText();
    }

    public String getColumnBText() {
        return driver.findElement(columnA).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}
