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
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationMessageTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/notification_message_rendered");
        
    }
    @Test
    public void notificationMessageTest() throws IOException {
    	
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	for(int i=0;i<=2;i++) {
    	driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        String getText=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
         System.out.println(getText);
         Assert.assertTrue(getText.contains("Action successful")|| getText.contains("Action unsuccesful, please try again"), "No messages is displaying");
         }
    }
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

