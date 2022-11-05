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

public class IframeTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/iframe");
        
    }
    @Test
    public void frameTest() throws IOException {
    	
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("/html/body/div[4]/div/div")).click();
       
    	driver.switchTo().frame("mce_0_ifr");
    	String text="Type into Iframe";
    	driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys(text);
        String getText=driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).getText();
        System.out.println(getText);
        Assert.assertTrue(getText.contains(text),"message is not typed in inframe");
    }
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

