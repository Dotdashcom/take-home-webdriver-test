package com.dashDot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Checkboxes extends Main {
    public void checkboxes(){
        driver.get("http://localhost:7080/checkboxes");
        WebElement chk1 = driver.findElement(By.xpath("//*[contains(text(),' checkbox 1']"));
        Assert.assertTrue(chk1.isSelected());
        //to uncheck the second checkbox
        WebElement chk2 = driver.findElement(By.xpath("//*[contains(text(),' checkbox 2']"));
        Assert.assertTrue(chk1.isSelected());
    }
}
