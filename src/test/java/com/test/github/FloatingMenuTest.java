package com.test.github;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FloatingMenuTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/floating_menu");
        
    }
    @Test
    public void floatingMenuTest() throws IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", "");
        
        String getText= driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a")).getText();
        Assert.assertTrue(getText.contains("Home"),"Text is not present");
    
    }
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

