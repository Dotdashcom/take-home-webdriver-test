package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public class File_upload extends Main {
    public void fileUpload(){
        driver.get("http://localhost:7080/upload");
        //RemoteWebDriver driver1;
       driver.findElement(By.xpath("//*[@id='file-upload']")).click();
       WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("Pictures/images (1).jpg");

        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
    }
}
