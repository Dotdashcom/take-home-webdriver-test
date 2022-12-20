package com.dotdashcom.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Iframe {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		 
		driver.get("http://localhost:7080/iframe");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void iframe() {
		
		String msg = "This is iframe.";
		driver.switchTo().frame("mce_0_ifr");
		WebElement body = driver.findElement(By.cssSelector("body"));
		body.clear();
		body.sendKeys(msg);
		
		String isAvailable = body.getText();
		Assert.assertEquals(isAvailable, msg);
		
	}
}
