package com.dotdash.webtest;

import com.dotdash.webtest.utils.ConfigReader;
import com.dotdash.webtest.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static WebDriver driver;

    @BeforeSuite
    public void testSetupForSuite() {
        ConfigReader.initializeProperties();
    }

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}