package com.company.tests;

import com.company.base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase04ContextMenu extends TestBase {

    @Test
    public void contextMenu() {

        driver.get("http://localhost:7080/context_menu");

        Actions actions = new Actions(driver);
        //WebElement contextMenuBox = driver.findElement(By.xpath("//*[@id='hot-spot']"));


        WebElement elementLocator = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementLocator).perform();


    }

    @Test
    public void rightClickTest() throws InterruptedException {
        driver.navigate().to("http://localhost:7080/context_menu");
        By locator = By.id("hot-spot");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        rightClick(element);

        Thread.sleep(3000);

//        WebElement elementEdit =driver.findElement(By.cssSelector(".context-menu-item.icon.icon-edit>span"));
//        elementEdit.click();
//        Alert alert=driver.switchTo().alert();
//        String textEdit = alert.getText();
//        Assert.assertEquals(textEdit, "clicked: edit", "Failed to click on Edit link");
    }

    public void rightClick(WebElement element) {
        try {
            Actions action = new Actions(driver).contextClick(element);
            action.build().perform();

            System.out.println("Sucessfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }
}
