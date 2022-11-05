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

public class MouseHoverTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/hovers");
        
    }
    @Test
    public void mouseHoverTest() throws IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	for(int i=1;i<=3;i++) {
    	Actions builder = new Actions(driver);
    	WebElement tagElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div["+i+"]/img"));
    	builder.moveToElement(tagElement).build().perform();
    	
    	String imagetext=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div["+i+"]/div/h5")).getText();
         System.out.println(imagetext);
         Assert.assertTrue(imagetext.contains("name: user"+i), "user info is not present");
    	}
    }
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

