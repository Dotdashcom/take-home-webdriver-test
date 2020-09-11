package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DDList extends Main {

    public void ddlist() throws InterruptedException {
        driver.get("http://localhost:7080/dropdown");
        driver.findElement(By.id("dropdown")).click();
        Thread.sleep(3000);
        //to select the first option
        driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).click();
        Thread.sleep(3000);
        //to select the 2nd option
        driver.findElement(By.xpath("//select[@id ='dropdown']/option[@value='2']")).click();

    }

}
