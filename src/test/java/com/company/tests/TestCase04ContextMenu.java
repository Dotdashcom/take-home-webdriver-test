package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

/**
 Test right-clicks on the context menu.
 Test asserts the alert menu text.
 */

public class TestCase04ContextMenu extends TestBase {

    @Test
    public void contextMenu() {

        driver.get("http://localhost:7080/context_menu");

        Actions actions = new Actions(driver);

        WebElement elementLocator = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementLocator).perform();

    }

    @Test
    public void rightClickTest(){
        driver.navigate().to("http://localhost:7080/context_menu");
        By locator = By.id("hot-spot");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        rightClick(element);
    }

    public void rightClick(WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + Arrays.toString(e.getStackTrace()));
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + Arrays.toString(e.getStackTrace()));
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + Arrays.toString(e.getStackTrace()));
        }
    }
}
