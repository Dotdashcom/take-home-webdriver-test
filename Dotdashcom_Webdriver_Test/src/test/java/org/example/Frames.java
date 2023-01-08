package org.example;

import Resources.driverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Frame;
import pageObjects.ScrollPage;

import javax.swing.*;
import java.io.IOException;

public class Frames extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "iframe");

    }

    @Test
    public void clickinbox() throws InterruptedException {
        Frame f = new Frame(driver);
        Actions a=new Actions(driver);

        driver.switchTo().frame(0);
        a.click(f.txtbx()).build().perform();
        f.txtbx().clear();
        Thread.sleep(5000);
        a.sendKeys("I have entered the text").build().perform();

        System.out.println(f.txtbx().getText());
        String s=f.txtbx().getText();
        Assert.assertEquals(s,"I have entered the text");


    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }

}
