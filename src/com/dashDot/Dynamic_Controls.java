package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dynamic_Controls extends Main{
    public void dynControls(){
        driver.get("http://localhost:7080/dynamic_controls");
        //driver.switchTo().frame("checkbox-example");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String txt = driver.findElement(By.xpath("//p[@id='message']")).getText();
        System.out.println(txt);
        //driver.switchTo().frame("input-example");
        driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
        //WebDriverWait wait1 = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        String msg = driver.findElement(By.xpath("//*[@id='message']")).getText();
        System.out.println(msg);


    }
}
