package com.dotdashcom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class MainTest {

    public static final String BASE_URL = "http://localhost:7080";
    public WebDriver driver;

    @BeforeSuite
    public void start() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupDriver() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
