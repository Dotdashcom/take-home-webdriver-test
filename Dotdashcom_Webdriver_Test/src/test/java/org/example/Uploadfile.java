package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.UploadFile;
import pageObjects.activities;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Uploadfile extends driverConfig
{
    public WebDriver driver;


    @BeforeTest
    public void startdriver() throws IOException
    {
        driver=invokedriver();
        driver.get(baseUrl+"upload");

    }

    @Test
    public void uploa() throws IOException, InterruptedException {
        UploadFile uf= new UploadFile(driver);
        activities ac= new activities(driver);
        Actions a=new Actions(driver);

//        a.click(uf.upload()).build().perform();

        Thread.sleep(5000);

        uf.upload().sendKeys("F:\\IDM\\Documents\\some-file.txt");





    }

    @AfterTest
    public void closebrowser() throws InterruptedException
    {
        Thread.sleep(6000);
        driver.close();
    }



}
