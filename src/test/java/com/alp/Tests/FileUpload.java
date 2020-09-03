package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {

    /*
    File Upload: http://localhost:7080/upload Test File Upload.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080");

        WebElement link = driver.findElement(By.linkText("File Upload"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(3);

        driver.findElement(By.id("file-upload")).click();
        driver.findElement(By.id("file-submit")).sendKeys("/Users/alp/Desktop/some-file.txt");//file location





        //driver.findElement(By.id("file-upload")).click();


        //driver.findElement(By.xpath("//input[@id='file-upload']")).click();

        //    driver.close();

//        syntax for uploading
//        Public void fileUpload(String path) {WebELement upload = driver.findELement;Upload.sendKeys(path)
    }

}
