package com.dashDot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Floating_Menu extends Main {
    public void floatingMenu(){
        driver.get("http://localhost:7080/floating_menu ");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,3000)", "");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='menu']")).isDisplayed());
        driver.findElement(By.xpath("//*[@id='menu']/ul/li[1]/a")).click();

    }

}
