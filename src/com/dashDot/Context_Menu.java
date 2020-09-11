package com.dashDot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Context_Menu extends Main{
    public void contextMenu() throws InterruptedException {
        driver.get("http://localhost:7080/context_menu");
        WebElement context = driver.findElement(By.xpath("//div[@class='example']div[@id='hot-spot']"));
        Actions act = new Actions(driver);
        act.contextClick(context);
        Thread.sleep(5000);
        String txt = driver.switchTo().alert().getText();
        System.out.println(txt);

        }
}
