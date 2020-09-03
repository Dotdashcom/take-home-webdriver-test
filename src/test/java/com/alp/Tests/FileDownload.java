package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownload {

    /*
    File Download: http://localhost:7080/download Test File Download.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/");

        WebElement link = driver.findElement(By.linkText("File Download"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);

        driver.findElement(By.linkText("some-file.txt")).click();


        //    driver.close();


    }

}
