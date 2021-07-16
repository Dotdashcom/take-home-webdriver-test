package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test4ContextMenu extends BasePage {
    @Test
    public void testContextMenu() {
        driver.get(" http://localhost:7080/context_menu");
        WebElement dashedBox = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(dashedBox)
                .sendKeys(Keys.RIGHT)
                .perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");

    }
}