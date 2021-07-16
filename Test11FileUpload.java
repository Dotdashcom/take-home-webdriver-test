package com.dotdash;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Test11FileUpload extends BaseMethod{

    @Test
    public void FileUpload() throws InterruptedException {
        driver.get("http://localhost:7080/upload");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys("C:\\Users\\yarid\\Downloads\\some-file");
        Thread.sleep(3000);
    }
}
