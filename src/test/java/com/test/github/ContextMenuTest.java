package com.test.github;

import java.util.List;

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

public class ContextMenuTest {
	WebDriver driver;
    @BeforeTest
    public void setup() {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/context_menu");
    }
    @Test
    public void contextmenuTest() {
    	
   	 WebDriverWait wait = new WebDriverWait(driver,30);
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"hot-spot\"]")));
    	WebElement element=driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));
    	Actions action = new Actions(driver).contextClick(element);
		action.build().perform();

		System.out.println("Sucessfully Right clicked on the element");
		Alert alert=driver.switchTo().alert();
		String textEdit = alert.getText();
		System.out.println("Alert Text is "+textEdit);
		Assert.assertEquals(textEdit,"You selected a context menu");

    }
    
    @AfterTest
    public void teardown() {
       // Close the driver
        driver.quit();
    }
}
