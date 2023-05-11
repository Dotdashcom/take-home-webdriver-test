package com.dotDash.test.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class TestBaseDotDash {

    public WebDriver driver;
    public String Url = "http://localhost:7080";

    public TestBaseDotDash(){

    }

    @BeforeMethod
    public void setup(){
        this.driver = DriverHelper.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
