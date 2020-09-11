package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Hover_to_Element extends Main{
    public void hovertoele() throws InterruptedException {
        driver.get("http://localhost:7080/hovers ");
        Actions act =new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"))).build().perform();
        Thread.sleep(1000);
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"))).build().perform();
        Thread.sleep(1000);
        act.moveToElement(driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"))).build().perform();
    }
}