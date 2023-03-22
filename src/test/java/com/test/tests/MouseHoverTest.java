package com.test.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverTest extends TestBase {

    @Test
    public void testMouseHover() {
        driver.get("http://localhost:7080/hovers");
        
        // Find all the image elements
        WebElement[] imageElements = {
                driver.findElement(By.cssSelector(".figure:nth-of-type(1)")),
                driver.findElement(By.cssSelector(".figure:nth-of-type(2)")),
                driver.findElement(By.cssSelector(".figure:nth-of-type(3)"))
        };
        
        // Perform a mouse hover on each image element
        Actions actions = new Actions(driver);
        for (WebElement imageElement : imageElements) {
            actions.moveToElement(imageElement).perform();
            assertTrue(imageElement.findElement(By.cssSelector(".figcaption")).isDisplayed());
        }
        
        driver.quit();
    }
}
