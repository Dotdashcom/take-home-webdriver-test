package org.example;

import Resources.driverConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DynamicControl;
import pageObjects.DynamicLoading;

import java.io.IOException;

public class Dynamicloading extends driverConfig {
    public WebDriver driver;

    public WebDriverWait w;

    DynamicControl dc;
    Actions a;


    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "dynamic_loading/2");
    }


    @Test
    public void loading() throws InterruptedException {

        DynamicLoading dl=new DynamicLoading(driver);
        Actions a=new Actions(driver);

        a.click(dl.startbtn()).build().perform();

        WebDriverWait w= new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(dl.textmsg()));

        String s=dl.textmsg().getText();

        System.out.println(s);

        Assert.assertEquals(s,"Hello World!");

    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        Thread.sleep(6000);
        driver.close();
    }

}