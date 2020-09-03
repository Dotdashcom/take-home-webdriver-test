package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Iframe {

    /*
    Iframe: http://localhost:7080/iframe Test iframe.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/");

        WebElement link = driver.findElement(By.linkText("Frames"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);
        driver.findElement(By.linkText("iFrame")).click();
        UtilWait.wait(1);

        driver.findElement(By.id("mceu_15-open")).click();
        driver.switchTo().frame("mce-ico mce-i-newdocument");

       // driver.findElement(By.className("mce-ico mce-i-newdocument")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]")).sendKeys("AlpAslan");
        //driver.switchTo().frame(driver.findElement("");

//         Frame is a html document inside another html document.
//         Web driver handles one page/html document at a time. To control another frame, we always need to switch method

        //    driver.close();

    }

}
