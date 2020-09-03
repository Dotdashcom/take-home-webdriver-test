package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MouseHover {

    /*
Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/");
        UtilWait.wait(1);

        WebElement link = driver.findElement(By.linkText("Hovers"));
        UtilWait.wait(1);
        link.click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"))).perform();
        UtilWait.wait(1);
        action.moveToElement(driver.findElement(By.xpath("//div[@class='row']//div[2]//img[1]"))).perform();
        UtilWait.wait(1);
        action.moveToElement(driver.findElement(By.xpath("//div[3]//img[1]"))).perform();

        //    driver.close();

    }

}
