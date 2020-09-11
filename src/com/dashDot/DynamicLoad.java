package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoad extends Main{
    public void dynamicLoad() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_loading/2");
        driver.findElement(By.xpath("//*[@id='start']/button")).click();
        WebDriverWait w = new WebDriverWait(driver,15);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));
        String txt = driver.findElement(By.xpath("//*[@id='finish']/h4")).getText();
        System.out.println(txt);
    }
}
