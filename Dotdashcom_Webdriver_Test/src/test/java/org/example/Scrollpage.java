package org.example;

import Resources.driverConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Mouseclick;
import pageObjects.ScrollPage;

import java.io.IOException;

public class Scrollpage extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "floating_menu");

    }

    @Test
    public void clickinbox() throws InterruptedException {
        ScrollPage sp = new ScrollPage(driver);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");

        Assert.assertTrue(sp.floating().isDisplayed());
    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
    }

}
