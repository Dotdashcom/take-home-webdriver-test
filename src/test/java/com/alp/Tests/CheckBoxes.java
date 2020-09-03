package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxes {

    /*
CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
    */

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/"); //or i can put http://localhost:7080/checkboxes, but i would like to show link.click()

        WebElement link = driver.findElement(By.linkText("Checkboxes"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);

        driver.findElement(By.xpath("//body//input[1]")).click();
        UtilWait.wait(1);
        driver.findElement(By.xpath("//body//input[1]")).click();
        UtilWait.wait(1);
        driver.findElement(By.xpath("//body//input[2]")).click();
        UtilWait.wait(1);
        driver.findElement(By.xpath("//body//input[2]")).click();

        driver.navigate().back();
        // driver.close();
    }
}



