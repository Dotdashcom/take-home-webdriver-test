package com.test.github;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class DynamicLoadingTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_loading/2");
    }
    @Test
    public void dynamicLoadingTest() {
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
         WebDriverWait wait = new WebDriverWait(driver,30);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,\"finish\")]/h4")));
         String getText= driver.findElement(By.xpath("//*[contains(@id,\"finish\")]/h4")).getText();
         Assert.assertTrue(getText.contains("Hello World!"),"Text is not present");
   
    }
    
   
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

