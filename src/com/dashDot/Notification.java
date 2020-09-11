package com.dashDot;

import org.junit.Assert;
import org.openqa.selenium.By;

public class Notification extends Main{
    public void notification(){
        driver.get("http://localhost:7080/notification_message_rendered");
        driver.findElement(By.xpath("//*[@id='content']/div/p/a")).click();
        String msg = driver.findElement(By.xpath("//*[@id='flash']")).getText();
        System.out.println(msg);
        Assert.assertEquals("Action successful",msg);
    }
}
