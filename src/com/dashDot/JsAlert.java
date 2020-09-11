package com.dashDot;

import org.openqa.selenium.By;

public class JsAlert extends Main{
    public void jsAlert() throws InterruptedException {
        driver.get("http://localhost:7080/javascript_alerts");
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String txt = driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println(txt);
    }
}
