package org.example;

import Resources.driverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DynamicControl;

import java.io.IOException;
import java.util.function.Function;

public class Dynamiccontrol extends driverConfig {
    public WebDriver driver;

    public WebDriverWait w;



    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "dynamic_controls");



    }


    @Test
    public void checkbox() throws InterruptedException {
        DynamicControl dc=new DynamicControl(driver);
        Actions a=new Actions(driver);

        a.click(dc.removbtn()).build().perform();
        WebDriverWait w= new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.invisibilityOf(dc.dynamicchkbx()));
        Assert.assertFalse(dc.dynamicchkbx().isDisplayed());


        a.click(dc.adbtn()).build().perform();
        w.until(ExpectedConditions.visibilityOf(dc.dynamicchkbx()));
        Assert.assertTrue(dc.dynamicchkbx().isDisplayed());
    }

    @Test
    public void inputbox() throws InterruptedException {

        DynamicControl dc=new DynamicControl(driver);
        Actions a=new Actions(driver);

        a.click(dc.enabtn()).build().perform();
        WebDriverWait w= new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.elementToBeClickable(dc.textbox()));
        Assert.assertTrue(dc.textbox().isEnabled());


        a.click(dc.disabtn()).build().perform();
        w.until(ExpectedConditions.elementToBeClickable(dc.textbox()));
        Thread.sleep(6000);
        Assert.assertFalse(dc.textbox().isEnabled());

    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        driver.close();
    }

}