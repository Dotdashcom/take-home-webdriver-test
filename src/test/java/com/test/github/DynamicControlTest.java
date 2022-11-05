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

public class DynamicControlTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_content");
    }
    @Test
    public void dynamicRefreshTest() {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	int i=0;
        for(i=0;i<=5;i++) {
    	  driver.navigate().refresh();
    	  WebElement image=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"));
          String getText=image.getAttribute("src");
          System.out.println(getText);
          
    }
    }
    
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

