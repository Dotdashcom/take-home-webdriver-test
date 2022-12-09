package com.test.localhost.tests;

import com.test.localhost.utils.ConfigReader;
import com.test.localhost.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        }


    }



