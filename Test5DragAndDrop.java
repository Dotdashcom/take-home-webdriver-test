package com.dotdash;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class Test5DragAndDrop extends BasePage {

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("http://localhost:7080/drag_and_drop");

        Actions act = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id=\"column-a\"]"));
        WebElement dest = driver.findElement(By.xpath("//div[@id=\"column-b\"]"));
        act.dragAndDrop(source, dest).build().perform();
        //Thread.sleep(3000);

        //Assert it was dropped
        WebElement droppedBank = driver.findElement(By.xpath("//div[@id=\"column-b\"]"));
        Assert.assertTrue(droppedBank.isDisplayed());

        driver.switchTo().defaultContent();

        //Thread.sleep(3000);
    }



}