package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop extends Main{
    public void dragDrop() throws InterruptedException {
        driver.get("http://localhost:7080/drag_and_drop ");
        //driver.findElement(By.id("content"));
        //driver.switchTo().activeElement();
        WebElement drag = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        Actions act = new Actions(driver);
        //act.dragAndDrop(target,drag).build().perform();
        act.dragAndDrop(drag,target).build().perform();
       // Thread.sleep(2000);
    }
}
