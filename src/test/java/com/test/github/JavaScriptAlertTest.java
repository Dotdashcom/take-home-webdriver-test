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

public class JavaScriptAlertTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/javascript_alerts");
        
    }
    @Test
    public void javaScriptAlertTest() throws IOException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        String alertText=driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("I am a JS Alert"), "Alert text is not present");
        driver.switchTo().alert().accept();
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        String alertTextJSConfirm=driver.switchTo().alert().getText();
        Assert.assertTrue(alertTextJSConfirm.contains("I am a JS Confirm"), "Alert text is not present");
        driver.switchTo().alert().accept();
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        String alertTextJSPrompt=driver.switchTo().alert().getText();
        Assert.assertTrue(alertTextJSPrompt.contains("I am a JS prompt"), "Alert text is not present");
        String text="Hello JS Prompt";
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        
       String verifedEnteredText=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertTrue(verifedEnteredText.contains(text), "Text is not entered");
    }
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

