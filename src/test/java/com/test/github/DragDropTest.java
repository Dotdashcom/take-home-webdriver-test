package com.test.github;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/drag_and_drop");
    }
    @Test
    public void dragDropTest() {
    	WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"column-a\"]")));
       
    	WebElement elementA=driver.findElement(By.xpath("//*[@id=\"column-a\"]"));	
       		
    	WebElement elementB=driver.findElement(By.xpath("//*[@id=\"column-b\"]"));					
    	Actions act=new Actions(driver);					
		
        act.dragAndDrop(elementA, elementB).build().perform();
        
        //WebElement verifyText=driver.findElement(By.xpath("//*[@id=\"column-b\"]/header"));
       
    }
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}

