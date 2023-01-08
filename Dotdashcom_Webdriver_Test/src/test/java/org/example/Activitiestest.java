package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.activities;

import java.io.IOException;
import java.util.Properties;

import static org.apache.logging.log4j.core.async.AsyncLoggerContextSelector.isSelected;

public class Activitiestest extends driverConfig
{
    public WebDriver driver;


    @BeforeTest
    public void startdriver() throws IOException
    {
        driver=invokedriver();
       driver.get(baseUrl+"checkboxes");

    }

    @Test
    public void checkbox1()
    {
        activities a= new activities(driver);
        a.checkbox1().click();
        Assert.assertTrue(a.checkbox1().isSelected());
    }
    @Test
    public void checkbox2() {
        activities a= new activities(driver);
        a.checkbox2().click();
        Assert.assertFalse(a.checkbox2().isSelected());
    }

    @AfterTest
    public void closebrowser() throws InterruptedException {
        Thread.sleep(6000);
        driver.close();
    }

}
