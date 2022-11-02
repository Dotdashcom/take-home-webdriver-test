package com.takehomewebdrivertest;

import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {

    ConfigFileReader configFileReader;

    public static ChromeDriver driver;

    @Before(value = "@UI")
    public void setUp() {
        configFileReader= new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--allow-insecure-localhost", "--window-size=1920,1080");
        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().window().maximize();
    }

    @After(value = "@UI")
    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
