package org.example;

import Resources.driverConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DragandDrop;
import pageObjects.DropDown;

import java.io.IOException;

public class Dropdown extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "dropdown");


    }

    @Test
    public void Dropdow() throws InterruptedException {
        DropDown d = new DropDown(driver);
        Select dp=new Select(d.dropdown());

        dp.selectByIndex(1);
        String s1=dp.getFirstSelectedOption().getText();
        System.out.println(s1);
        Assert.assertEquals(s1,"Option 1");

        dp.selectByIndex(2);
        String s2=dp.getFirstSelectedOption().getText();
        System.out.println(s2);
        Assert.assertEquals(s2,"Option 2");

    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        Thread.sleep(6000);

        driver.close();
    }

}