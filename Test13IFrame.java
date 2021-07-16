package com.dotdash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test13IFrame extends BaseMethod {

    @Test
    public void iFrames() throws Exception {
        driver.get("http://localhost:7080/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = findByVisibility(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        editor.sendKeys("Hello World!");
        String afterText = editor.getText();
        Assert.assertFalse(beforeText.equals(afterText));
        Thread.sleep(1000);
    }



}
