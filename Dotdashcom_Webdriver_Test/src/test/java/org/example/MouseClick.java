package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Mouseclick;

import java.awt.*;
import java.io.IOException;

public class MouseClick extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "context_menu");

    }

    @Test
    public void clickinbox() throws InterruptedException {
        Mouseclick a = new Mouseclick(driver);
        Actions m = new Actions(driver);
//        m.moveToElement(a.clickonbox()).moveByOffset(80,270).contextClick().build().perform();
        m.moveToElement(a.clickonbox()).contextClick().build().perform();
        String text = driver.switchTo().alert().getText();
        Assert.assertFalse(text.isEmpty());
        System.out.println(text);
        driver.switchTo().alert().accept();
    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        driver.close();
    }

}
